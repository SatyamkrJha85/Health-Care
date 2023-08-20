package com.example.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcare.MainActivity;
import com.example.healthcare.R;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1=
            {
                    {"doctor Name : Ajit Sate","Hospital Address : Delhi","Exp : 5yrs","Mobile no : 8252786832","Fees : 600"},
                    {"doctor Name : Mahesh","Hospital Address : Mumbai","Exp : 4yrs","Mobile no : 8252786890","Fees : 400"},
                    {"doctor Name : Suresh prs","Hospital Address : Bihar","Exp : 2yrs","Mobile no : 9052786832","Fees : 600"},
                    {"doctor Name : Ramesh Das","Hospital Address : Delhi","Exp : 3yrs","Mobile no : 8952786832","Fees : 800"},
                    {"doctor Name : Kartik Mishra","Hospital Address : UP","Exp : 1yrs","Mobile no : 8252786832","Fees : 200"},
                    {"doctor Name : Dinesh Sahu","Hospital Address : MP","Exp : 7yrs","Mobile no : 5652786832","Fees : 400"},

            };
    private String[][] doctor_details2=
            {
                    {"doctor Name : Suman Das","Hospital Address : Panjab","Exp : 8yrs","Mobile no : 3452786832","Fees : 600"},
                    {"doctor Name : Ajit Sate","Hospital Address : MP","Exp : 4yrs","Mobile no : 6252786832","Fees : 500"},
                    {"doctor Name : Santosh Res","Hospital Address : Rajashan","Exp : 5yrs","Mobile no : 4552786832","Fees : 300"},
                    {"doctor Name : Rahul pradhan","Hospital Address : kashmir","Exp : 6yrs","Mobile no : 3252786832","Fees : 200"},
                    {"doctor Name : Swagato maithy","Hospital Address : Hariyana","Exp : 9yrs","Mobile no : 2452786832","Fees : 600"},
                    {"doctor Name : Suman sankar","Hospital Address : Nepal","Exp : 5yrs","Mobile no : 5252786832","Fees : 400"},

            };
    private String[][] doctor_details3=
            {
                    {"doctor Name : Prem Sate","Hospital Address : Wb","Exp : 2yrs","Mobile no : 5452786832","Fees : 600"},
                    {"doctor Name : Sanjay Palit","Hospital Address : Delhi","Exp : 2yrs","Mobile no : 6252786832","Fees : 400"},
                    {"doctor Name : Santosh Res","Hospital Address : Rajashan","Exp : 5yrs","Mobile no : 4552786832","Fees : 300"},
                    {"doctor Name : Rahul pradhan","Hospital Address : kashmir","Exp : 6yrs","Mobile no : 3252786832","Fees : 200"},
                    {"doctor Name : Swagato maithy","Hospital Address : Hariyana","Exp : 9yrs","Mobile no : 2452786832","Fees : 600"},
                    {"doctor Name : Suman sankar","Hospital Address : Nepal","Exp : 5yrs","Mobile no : 5252786832","Fees : 400"},
            };
    private String[][] doctor_detail4=
            {
                    {"doctor Name : Harsh Suman","Hospital Address : Bengal","Exp : 5yrs","Mobile no : 9252786832","Fees : 600"},
                    {"doctor Name : Sanjay Palit","Hospital Address : Delhi","Exp : 2yrs","Mobile no : 6252786832","Fees : 400"},
                    {"doctor Name : Santosh Res","Hospital Address : Rajashan","Exp : 5yrs","Mobile no : 4552786832","Fees : 300"},
                    {"doctor Name : Rahul pradhan","Hospital Address : kashmir","Exp : 6yrs","Mobile no : 3252786832","Fees : 200"},
                    {"doctor Name : Swagato maithy","Hospital Address : Hariyana","Exp : 9yrs","Mobile no : 2452786832","Fees : 600"},
                    {"doctor Name : Suman sankar","Hospital Address : Nepal","Exp : 5yrs","Mobile no : 5252786832","Fees : 400"},

            };
    private String[][] doctor_details5=
            {
                    {"doctor Name : priya chy","Hospital Address : Patna","Exp : 3yrs","Mobile no : 6552786832","Fees : 1000"},
                    {"doctor Name : Ajit Sate","Hospital Address : Delhi","Exp : 5yrs","Mobile no : 8252786832","Fees : 600"},
                    {"doctor Name : Sanjay Palit","Hospital Address : Delhi","Exp : 2yrs","Mobile no : 6252786832","Fees : 400"},
                    {"doctor Name : Santosh Res","Hospital Address : Rajashan","Exp : 5yrs","Mobile no : 4552786832","Fees : 300"},
                    {"doctor Name : Rahul pradhan","Hospital Address : kashmir","Exp : 6yrs","Mobile no : 3252786832","Fees : 200"},
                    {"doctor Name : Swagato maithy","Hospital Address : Hariyana","Exp : 9yrs","Mobile no : 2452786832","Fees : 600"},
                    {"doctor Name : Suman sankar","Hospital Address : Nepal","Exp : 5yrs","Mobile no : 5252786832","Fees : 400"},

            };


Button back_btn1;
TextView text_view_dd_title;
String [][] doctor_details={};
HashMap<String,String> item;
ArrayList list;
SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
         back_btn1=findViewById(R.id.back_btn1);
        text_view_dd_title=findViewById(R.id.text_view_dd_title);



        // for back to activity
        back_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, find_doctor.class));
            }
        });
        // for text
        Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        text_view_dd_title.setText(title);

        // Condition Check
        if(title.compareTo("Family Physicians")==0){
            doctor_details=doctor_details1;
        }
        else if(title.compareTo("Dietician")==0){
            doctor_details=doctor_details2;
        }
        else if(title.compareTo("Dentist")==0){
            doctor_details=doctor_details3;
        }
        else if(title.compareTo("Surgeon")==0){
            doctor_details=doctor_detail4;
        }
        else if(title.compareTo("Cardioclogist")==0){
            doctor_details=doctor_details5;
        }
        else{
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        }

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons "+doctor_details[i][4]+"/-");
            list.add(item);

        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,
        R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst=findViewById(R.id.list_view_dd);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[position][0]);
                it.putExtra("text3",doctor_details[position][1]);
                it.putExtra("text4",doctor_details[position][3]);
                it.putExtra("text5",doctor_details[position][4]);
                startActivity(it);
            }
        });

    }
}