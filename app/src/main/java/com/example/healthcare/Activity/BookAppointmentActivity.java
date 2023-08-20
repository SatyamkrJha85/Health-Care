package com.example.healthcare.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.healthcare.MainActivity;
import com.example.healthcare.R;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    TextView tv;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    Button select_time_btn,bookappointment,book_back_btn;
    Button select_date_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        ed1=findViewById(R.id.fullname);
        ed2=findViewById(R.id.Address);
        ed3=findViewById(R.id.contact_no);
        ed4=findViewById(R.id.fees);
        tv=findViewById(R.id.title_text_book);
        select_date_btn=findViewById(R.id.select_date_btn);
        select_time_btn=findViewById(R.id.select_time_btn);
        book_back_btn=findViewById(R.id.book_back_btn);
        bookappointment=findViewById(R.id.bookappointment);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);


        Intent it=getIntent();
        String title=it.getStringExtra("text1");
        String fullname=it.getStringExtra("text2");
        String address=it.getStringExtra("text3");
        String contact=it.getStringExtra("text4");
        String fees=it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText(fees);

        // date Picker
        initDatePicker();
       select_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        // Time Picker
        initTimePicker();
        select_time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });


        // back btn code

       book_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointmentActivity.this,find_doctor.class));
            }
        });




        // book btn code
       bookappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookAppointmentActivity.this, "Appointment Booked Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookAppointmentActivity.this, MainActivity.class));
                finish();

            }
        });

    }


    // funtction for date picker
private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                select_date_btn.setText(dayOfMonth+"/"+month+"/"+year);

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
                select_time_btn.setText(hourOfDay+":"+minute);

            }
        };

    Calendar cal=Calendar.getInstance();
    int hrs=cal.get(Calendar.HOUR);
    int mins=cal.get(Calendar.MINUTE);

    int style= AlertDialog.THEME_HOLO_DARK;
    timePickerDialog=new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);

}





}