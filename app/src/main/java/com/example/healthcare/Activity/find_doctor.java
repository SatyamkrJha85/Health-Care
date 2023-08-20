package com.example.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthcare.MainActivity;
import com.example.healthcare.R;

public class find_doctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView cardBacktohome=findViewById(R.id.cardBacktohome);
        cardBacktohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(find_doctor.this, MainActivity.class));
            }
        });

        CardView familyphysician=findViewById(R.id.cardFamilyphysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(find_doctor.this, DoctorDetailsActivity.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);

            }
        });

        CardView dietician=findViewById(R.id.cardDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(find_doctor.this, DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);

            }
        });
        CardView dentist=findViewById(R.id.cardDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(find_doctor.this, DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);

            }
        });

        CardView surgeon=findViewById(R.id.cardSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(find_doctor.this, DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);

            }
        });

        CardView cardiologists=findViewById(R.id.cardCardiologists);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(find_doctor.this, DoctorDetailsActivity.class);
                it.putExtra("title","Cardioclogist");
                startActivity(it);

            }
        });

    }
}