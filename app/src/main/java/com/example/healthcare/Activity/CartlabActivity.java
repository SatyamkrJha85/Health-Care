package com.example.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.healthcare.Database;
import com.example.healthcare.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CartlabActivity extends AppCompatActivity {

    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    TextView tvTotal;
    ImageView list_view_cart;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button datebtn,timebtn,btn_checkout,btn_back;
    private String[][] packages={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartlab);
        tvTotal=findViewById(R.id.cart_total_cost);
        datebtn=findViewById(R.id.select_date_btn_cart);
        timebtn=findViewById(R.id.select_time_btn_cart);
        btn_checkout=findViewById(R.id.checkout_btn);
        btn_back=findViewById(R.id.back_btn_cart);
        list_view_cart=findViewById(R.id.list_view_cart);

    /*    SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String email=sharedPreferences.getString("email","").toString();
        Database db=new Database(getApplicationContext(),"healthcare",null,1);
        float totalAmount = 0;
        ArrayList dbdata=db.getCartData(email,"lab");

// Something Problem Here data not save to Toast and activity
       // Toast.makeText(this, "Why not showing timestamp 3:33"+dbdata, Toast.LENGTH_SHORT).show();

        packages=new String[dbdata.size()][];
        for(int i=0;i<packages.length;i++){
            packages[i]=new String[5];
        }
        for(int i=0;i<dbdata.size();i++){
            String arrData = dbdata.get(i).toString();
            String[] strData=arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0]=strData[0];
            packages[i][4]="Cost : "+strData[1]+"/-";
            totalAmount=totalAmount+Float.parseFloat(strData[1]);
        }
        tvTotal.setText("Total Cost : "+totalAmount);

        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5",packages[i][4]);
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
        R.layout.multi_lines,
        new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        list_view_cart.setAdapter(sa);


     */
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartlabActivity.this,LabTestActivity.class));
            }
        });
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(CartlabActivity.this,LabTestBookActivity.class);
        /*        it.putExtra("price",tvTotal.getText());
                it.putExtra("date",timebtn.getText());
                it.putExtra("time",timebtn.getText());

         */
                startActivity(it);
            }
        });
        // date Picker
        initDatePicker();
        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        // Time Picker
        initTimePicker();
        timebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

    }
    // funtction for date picker
    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                datebtn.setText(dayOfMonth+"/"+month+"/"+year);

            }
        };
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timebtn.setText(hourOfDay+":"+minute);

            }
        };

        Calendar cal=Calendar.getInstance();
        int hrs=cal.get(Calendar.HOUR);
        int mins=cal.get(Calendar.MINUTE);

        int style= AlertDialog.THEME_HOLO_DARK;
        timePickerDialog=new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);

    }

}