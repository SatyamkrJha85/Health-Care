package com.example.healthcare;

import android.content.Context;
import android.widget.Toast;

public class Utility {

    static void showtoast(Context context,String message){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }
}
