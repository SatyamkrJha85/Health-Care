package com.example.healthcare.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcare.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {


    EditText Gmail, password, repassword;
    Button signin_btn;
    TextView login_txt;
    String userId;
    android.widget.ProgressBar ProgressBar;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;
    private DatabaseReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Gmail = findViewById(R.id.Gmail);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        signin_btn = findViewById(R.id.signin_btn);
        ProgressBar = findViewById(R.id.ProgressBar);
        login_txt = findViewById(R.id.login_txt);
        firebaseFirestore = FirebaseFirestore.getInstance();

        signin_btn.setOnClickListener(v -> createAccount());
        login_txt.setOnClickListener(v -> startActivity(new Intent(RegisterActivity.this, LoginActivity.class)));
    }
        void createAccount(){
            String email  = Gmail.getText().toString();
            String mainpassword  = password.getText().toString();
            String confirmPassword  = repassword.getText().toString();

            boolean isValidated = validateData(email,mainpassword,confirmPassword);
            if(!isValidated){
                return;
            }
            createAccountInFirebase(email,mainpassword);
        }
        void createAccountInFirebase(String email, String password){
        changeInProgress(true);

            FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        // Done
                        Toast.makeText(RegisterActivity.this, "Account creating is sucsssfull " +
                                "Check Email and verify yout account", Toast.LENGTH_SHORT).show();
                        firebaseAuth.getCurrentUser().sendEmailVerification();
                        firebaseAuth.signOut();

                    }
                    else{
                        // Failed
                        Toast.makeText(RegisterActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }








        void changeInProgress(boolean inProgress){
            if(inProgress){
                ProgressBar.setVisibility(View.VISIBLE);
                signin_btn.setVisibility(View.GONE);
            }else{
                ProgressBar.setVisibility(View.GONE);
                signin_btn.setVisibility(View.VISIBLE);
            }
        }


        boolean validateData(String email,String mainpassword,String confirmPassword){
            //validate the data that are input by user.
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Gmail.setError("Email is invalid");
                return false;
            }
            if(mainpassword.length()<6){
                password.setError("Password length is invalid");
                return false;
            }
            if(!mainpassword.equals(confirmPassword)){
                repassword.setError("Password not matched");
                return false;
            }
            return true;
        }
    }