package com.example.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthcare.MainActivity;
import com.example.healthcare.R;

public class HealthTips extends AppCompatActivity {
Button back_btn_to_health;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);
        back_btn_to_health=findViewById(R.id.back_btn_to_health);
        back_btn_to_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthTips.this, MainActivity.class));
                finish();
            }
        });
    }
}