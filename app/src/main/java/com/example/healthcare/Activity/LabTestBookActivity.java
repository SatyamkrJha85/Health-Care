package com.example.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthcare.Database;
import com.example.healthcare.MainActivity;
import com.example.healthcare.R;

public class LabTestBookActivity extends AppCompatActivity {
 EditText edname,edadress,edcontact,edpincode;
 Button btnbooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
        edname=findViewById(R.id.fullname_book);
        edadress=findViewById(R.id.Address_book);
        edcontact=findViewById(R.id.contact_no_book);
        edpincode=findViewById(R.id.pincode_booking);
        btnbooking=findViewById(R.id.book_btn);

     /*   Intent intent=getIntent();
        String[] price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");
        String time=intent.getStringExtra("time");

      */

        btnbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String email =sharedPreferences.getString("email","").toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(email,edname.getText().toString(),edadress.getText().
                        toString(),edcontact.getText().toString(),edpincode.getText().toString(),date.
                        toString(),time.toString(),Float.parseFloat(price[1].toString()),"lab");

                db.removeCart(email,"lab");
                startActivity(new Intent(LabTestBookActivity.this, MainActivity.class));

            */
                Toast.makeText(LabTestBookActivity.this, "Your Booking Done Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this,MainActivity.class));
                finish();

            }
        });
    }
}