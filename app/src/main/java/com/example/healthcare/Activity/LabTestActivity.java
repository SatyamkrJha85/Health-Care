package com.example.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.healthcare.MainActivity;
import com.example.healthcare.R;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages=
    {
        {"Package 1 : Full Body Checkup","","","","999"},
        {"Package 2 : Blood Glucose Fasting","","","","299"},
        {"Package 3 : COVID-19 Antibody","","","","899"},
        {"Package 4 : Thyroid","","","","499"},
        {"Package 5 : Immunity Check","","","","699"}

    };

    private String[] package_details={
            "Blood Glucose Fasting\n" +
                    " Complete Hemogram\n" +
                    "HBA1c\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "LDH Lactats Dehydrogenase, Serum\n" +
                    "Lipid Profile\n" +
                    "Liver Function Test",
            "Blood Glucose Fasting",
            "COVID-19 Antibody - 1gG",
            "Thyroid Profile-Total (T3, T4 & TSH Ultra-Sensitive)",
            "Complete Hemogram\n"+
                    "CRP (C Reactive Protein) Quantitative, Serum\n" +
                    " Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "Vitamin D Total-25 Hydroxy\n" +
                    "Liver Function Test\n" +
                    "Lipid Profile"
    };
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;
    Button gotocart_btn,back_btn_test;
    ListView list_view_lab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        list_view_lab=findViewById(R.id.list_view_lab);
        gotocart_btn=findViewById(R.id.gotocart_btn);
        back_btn_test=findViewById(R.id.back_btn_test);

        back_btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, MainActivity.class));
            }
        });
        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost"+packages[i][4]+"/-");
            list.add(item);

        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,
                R.id.line_c,R.id.line_d,R.id.line_e}
        );
        list_view_lab.setAdapter(sa);
        list_view_lab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[position][0]);
                it.putExtra("text2",package_details[position]);
                it.putExtra("text3",packages[position][4]);
                startActivity(it);

            }
        });
        gotocart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,CartlabActivity.class));
            }
        });

    }
}