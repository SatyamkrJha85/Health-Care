package com.example.healthcare.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcare.Database;
import com.example.healthcare.MainActivity;
import com.example.healthcare.R;
import com.example.healthcare.Utility;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity {


    EditText gmail1,password;
    Button login_btn;
    TextView signup_txt;
    ProgressBar progressBar;
    private DatabaseReference usersRef;
    Utility utility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gmail1 = findViewById(R.id.gmail1);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);
        progressBar = findViewById(R.id.ProgressBar);
        signup_txt = findViewById(R.id.signup_txt);

        signup_txt.setOnClickListener((v) -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));

        login_btn.setOnClickListener((v) -> loginUser());

    }

        void loginUser(){
            String email  = gmail1.getText().toString();
            String mainpassword  = password.getText().toString();

            boolean isValidated = validateData(email,mainpassword);
            if(!isValidated){
                return;
            }
            // database

            loginAccountInFirebase(email,mainpassword);

        }
        void loginAccountInFirebase(String email, String password){
        FirebaseAuth firebaseAuth =FirebaseAuth.getInstance();
        changeInProgress(true);
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                changeInProgress(false);
                if(task.isSuccessful()){
                    //login sucess
                    Database db=new Database(getApplicationContext(),"healthcare",null,1);

                    db.register(email);
                    // For shared prefrence
                    SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("email",email);
                    editor.apply();

                    if(firebaseAuth.getCurrentUser().isEmailVerified()){
                        //Go to main Activity
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                    else{
                        // email auth failed
                        Toast.makeText(LoginActivity.this, "Email not verified please verify your email", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    //Failed
                    Toast.makeText(LoginActivity.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        }




    void changeInProgress(boolean inProgress){
        if(inProgress){
            progressBar.setVisibility(View.VISIBLE);
            login_btn.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.GONE);
            login_btn.setVisibility(View.VISIBLE);
        }
    }

    boolean validateData(String email,String mainpassword){

        //validate the data that are input by user.

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            gmail1.setError("Email is invalid");
            return false;
        }
        if(mainpassword.length()<6){
            password.setError("Password length is invalid");
            return false;
        }
        return true;
    }

}