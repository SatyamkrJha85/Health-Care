package com.example.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.healthcare.Database;
import com.example.healthcare.MainActivity;
import com.example.healthcare.R;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsActivity extends AppCompatActivity {

    private String[][] order_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        backbtn=findViewById(R.id.back_btn_to_main);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailsActivity.this, MainActivity.class));
            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String email=sharedPreferences.getString("email","").toString();
        Database db=new Database(getApplicationContext(),"healthcare",null,1);
       // ArrayList dbdata=db.getOrderData(email);

     /*   order_details=new String[dbdata.size()][];
        for(int i=0;i<order_details.length;i++){
            String arrData=dbdata.get(i).toString();
            String[] strData=arrData.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0]=strData[0];
            order_details[i][1]=strData[1];
            if(strData[7].compareTo("medicine")==0){
                order_details[i][3]="Del:"+strData[4];
            }
            else {
                order_details[i][3]="Del:"+strData[4]+" "+strData[5];
            }
            order_details[i][2]="Rs."+strData[6];
            order_details[i][4]=strData[7];
        }

        list=new ArrayList();
        for(int i=0;i<order_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",order_details[i][0]);
            item.put("line2",order_details[i][1]);
            item.put("line3",order_details[i][2]);
            item.put("line4",order_details[i][3]);
            item.put("line5",order_details[i][4]);
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

      */
    }
}