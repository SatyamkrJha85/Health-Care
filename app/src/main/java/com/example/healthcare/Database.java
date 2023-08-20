package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.CameraOfflineSession;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(email)";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "create table cart(email text,product text, price float,otype text)";
        sqLiteDatabase.execSQL(qry2);

        String qry3="create table orderplace(email text, fullname text,address text,contactno text,pincode int,date text,time text,amount float,otype text)";
        sqLiteDatabase.execSQL(qry3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addCart(String email, String product, Float price, String otype) {
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("product", product);
        cv.put("price", price);
        cv.put("otype", otype);
        SQLiteDatabase db1 = getWritableDatabase();
        db1.insert("cart", null, cv);
        db1.close();


    }

    public int checkCart(String email, String product) {
        int result = 0;
        String str[] = new String[2];
        str[0] = email;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from cart where email = ? and product = ?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        db.close();
        return result;
    }

    public void removeCart(String email, String otype) {
        String str[] = new String[2];
        str[0] = email;
        str[1] = otype;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart", "email=? and otype=?", str);
        db.close();
    }

    public void register(String email) {
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }

    public ArrayList getCartData(String email, String otype) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[2];
        str[0] = email;
        str[1] = otype;
        Cursor c = db.rawQuery("select * from cart where email = ? and otype = ?", str);
        if (c.moveToFirst()) {
            do {
                String product = c.getString(1);
                String price = c.getString(2);
                arr.add(product + "$" + price);
            } while (c.moveToNext());
        }
            db.close();
            return arr;
        }

        public void addOrder(String email,String fullname,String address,String contact,String pincode,String date,String time,float price,String otype){
        ContentValues cv=new ContentValues();
        cv.put("email",email);
            cv.put("fullname",fullname);
            cv.put("address",address);
            cv.put("contactno",contact);
            cv.put("pincode",pincode);
            cv.put("date",date);
            cv.put("time",time);
            cv.put("amount",price);
            cv.put("otype",otype);
            SQLiteDatabase db=getWritableDatabase();
            db.insert("orderplace",null,cv);
            db.close();

        }
  /*  public ArrayList getOrderData(String email) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[2];
        str[0] = email;
        Cursor c = db.rawQuery("select * from orderplace where email =?", str);
        if (c.moveToFirst()) {
            do {
                arr.add(c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getString(4)+"$"+
                        c.getString(5)+"$"+c.getString(6)+"$"+c.getString(7)+"$"+c.getString(8));
            } while (c.moveToNext());
        }
        db.close();
        return arr;
    }

   */

}
