package com.example.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcare.Database;
import com.example.healthcare.R;

public class LabTestDetailsActivity extends AppCompatActivity {
 TextView tvPackageName,TvTotalcost,edDetails;
    //EditText edDetails;
    Button back_btn_test_detail,addtocart_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);
        tvPackageName=findViewById(R.id.text_view_lab_title_details);
        TvTotalcost=findViewById(R.id.ld_total_cost);
        edDetails=findViewById(R.id.textmultiline);
        back_btn_test_detail=findViewById(R.id.back_btn_test_detail);
        addtocart_btn=findViewById(R.id.addtocart_btn);


        edDetails.setKeyListener(null);
        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        TvTotalcost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        back_btn_test_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }
        });
        addtocart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String email=sharedPreferences.getString("email","").toString();
                String product=tvPackageName.getText().toString();
                float price =Float.parseFloat(intent.getStringExtra("text3").toString());
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(db.checkCart(email,product)==1){
                    Toast.makeText(LabTestDetailsActivity.this, "Product Already Added", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addCart(email,product,price,"Lab");
                    Toast.makeText(LabTestDetailsActivity.this, "Record Inserted to cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
                }
            }
        });



    }
}