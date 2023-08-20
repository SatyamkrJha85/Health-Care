package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.healthcare.Activity.HealthTips;
import com.example.healthcare.Activity.LabTestActivity;
import com.example.healthcare.Activity.LoginActivity;
import com.example.healthcare.Activity.Medicine_List;
import com.example.healthcare.Activity.OrderDetailsActivity;
import com.example.healthcare.Activity.RegisterActivity;
import com.example.healthcare.Activity.find_doctor;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Welcome sir", Toast.LENGTH_SHORT).show();

        // Logout Activity
        CardView exit=findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                SharedPreferences myPrefs = getSharedPreferences("Activity",
                        MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(MainActivity.this,
                        LoginActivity.class);
                Toast.makeText(MainActivity.this, "Log_Out Successfull", Toast.LENGTH_SHORT).show();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

           // For find Doctor

        CardView findDoctor1=findViewById(R.id.cardFindDoctor);
        findDoctor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, find_doctor.class));
            }
        });

        // to check appointment

        CardView cardLabTest=findViewById(R.id.cardLabTest);
        cardLabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LabTestActivity.class));
            }
        });

        // for order details
        CardView cardorder=findViewById(R.id.cardOrderDetails);
        cardorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OrderDetailsActivity.class));
            }
        });
        CardView cardHealthdoctor=findViewById(R.id.cardHealthdoctor);
        cardHealthdoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HealthTips.class));
            }
        });
        CardView cardBuyMedicine=findViewById(R.id.cardBuyMedicine);
        cardBuyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Medicine_List.class));
            }
        });

    }
}