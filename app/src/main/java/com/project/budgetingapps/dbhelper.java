package com.project.budgetingapps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class dbhelper extends SQLiteOpenHelper {
    int jumlah;
    public dbhelper(Context context) {
        super(context, "cart.db", null, 1);
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy", Locale.getDefault());


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("drop Table if exists transport;");
        db.execSQL("drop Table if exists grocery;");
        db.execSQL("drop Table if exists entertainment;");
        db.execSQL("drop Table if exists saving;");
        db.execSQL("drop Table if exists bulanan;");

        db.execSQL("create Table transport(id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT,jumlah int,date TEXT);");
        db.execSQL("create Table grocery(id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT,jumlah int,date TEXT);");
        db.execSQL("create Table entertainment(id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT,jumlah int,date TEXT);");
        db.execSQL("create Table saving(id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT,jumlah int,date TEXT);");
        db.execSQL("create Table bulanan(jumlah INTEGER PRIMARY KEY);");

        String tanggal = dateFormat.format(new Date());
        db.execSQL("insert into bulanan(jumlah) values (5500000)");
        db.execSQL("insert into transport(nama,jumlah,date) values ('Coffee',55000,'" + tanggal + "')");
        db.execSQL("insert into transport(nama,jumlah) values ('Indomie',500)");
        db.execSQL("insert into transport(nama,jumlah) values ('Bu',2555)");
        db.execSQL("insert into transport(nama,jumlah) values ('as',51)");

        db.execSQL("insert into grocery(nama,jumlah) values ('Coffee',55000)");
        db.execSQL("insert into grocery(nama,jumlah) values ('Indomie',500)");
        db.execSQL("insert into grocery(nama,jumlah) values ('Bu',2555)");
        db.execSQL("insert into grocery(nama,jumlah) values ('as',51)");

        db.execSQL("insert into entertainment(nama,jumlah) values ('Coffee',55000)");
        db.execSQL("insert into entertainment(nama,jumlah) values ('Indomie',500)");
        db.execSQL("insert into entertainment(nama,jumlah) values ('Bu',2555)");
        db.execSQL("insert into entertainment(nama,jumlah) values ('as',51)");

        db.execSQL("insert into saving(nama,jumlah) values ('Coffee',55000)");
        db.execSQL("insert into saving(nama,jumlah) values ('Indomie',500)");
        db.execSQL("insert into saving(nama,jumlah) values ('Bu',2555)");
        db.execSQL("insert into saving(nama,jumlah) values ('as',51)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        db.execSQL("drop Table if exists transport;");
        db.execSQL("drop Table if exists grocery;");
        db.execSQL("drop Table if exists entertainment;");
        db.execSQL("drop Table if exists saving;");
    }

    public int jumlahbarang(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("PRAGMA table_info(transport)", null);
        int columnCount = cursor.getCount();

        return columnCount;
    }

    List<childitem2> ChildItemList(String tipe)
    {
        List<childitem2> ChildItemList
                = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        switch (tipe){
            case("Transport"):
                cursor = db.rawQuery("SELECT * FROM transport",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(1);
                    ChildItemList.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;

            case("Grocery"):
                cursor = db.rawQuery("SELECT * FROM grocery",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(1);
                    ChildItemList.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;

            case("Entertainment"):
                cursor = db.rawQuery("SELECT * FROM entertainment",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(1);
                    ChildItemList.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;

            case("Saving"):

                cursor = db.rawQuery("SELECT * FROM saving",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(1);
                    ChildItemList.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;
        }

        return ChildItemList;
    }
    List<childitem2> child(String tipe)
    {
        List<childitem2> child
                = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        switch (tipe){
            case("Transport"):
                cursor = db.rawQuery("SELECT * FROM transport",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(2);
                    child.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;
            case("Grocery"):
                cursor = db.rawQuery("SELECT * FROM grocery",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(2);
                    child.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;

            case("Entertainment"):
                cursor = db.rawQuery("SELECT * FROM entertainment",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(2);
                    child.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;

            case("Saving"):

                cursor = db.rawQuery("SELECT * FROM saving",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(2);
                    child.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;
        }

        return child;
    }

    List<childitem2> ambiltanggal(String tipe)
    {
        List<childitem2> ambiltangga
                = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        switch (tipe){
            case("Transport"):
                cursor = db.rawQuery("SELECT * FROM transport",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(3);
                    ambiltangga.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;

            case("Grocery"):
                cursor = db.rawQuery("SELECT * FROM grocery",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(3);
                    ambiltangga.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;

            case("Entertainment"):
                cursor = db.rawQuery("SELECT * FROM entertainment",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(3);
                    ambiltangga.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;

            case("Saving"):

                cursor = db.rawQuery("SELECT * FROM saving",null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String data = cursor.getString(3);
                    ambiltangga.add(new childitem2(data));
                    cursor.moveToNext();
                }
                cursor.close();
                break;
        }
        return ambiltangga;
    }

    public String ambildata (int id,String tipe){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        switch (tipe){
            case("Grocery"): cursor = db.rawQuery("SELECT * FROM grocery;",null);    break;
            case("Transport"):cursor = db.rawQuery("SELECT * FROM transport;",null);break;
            case("Entertainment"):cursor = db.rawQuery("SELECT * FROM entertainment;",null);break;
            case("Saving"):cursor = db.rawQuery("SELECT * FROM saving;",null);break;
        }

        assert cursor != null;
        cursor.moveToFirst();
        for (int i=0;i<id;i++){
            cursor.moveToNext();
        }
        String nama = cursor.getString(1);
        return nama;
    }
    public int ambiljumlah (int id,String tipe){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        switch (tipe){
            case("Grocery"): cursor = db.rawQuery("SELECT * FROM grocery;",null);    break;
            case("Transport"):cursor = db.rawQuery("SELECT * FROM transport;",null);break;
            case("Entertainment"):cursor = db.rawQuery("SELECT * FROM entertainment;",null);break;
            case("Saving"):cursor = db.rawQuery("SELECT * FROM saving;",null);break;
        }

        assert cursor != null;
        cursor.moveToFirst();
        for (int i=0;i<id;i++){
            cursor.moveToNext();
        }
        Integer jumlah = cursor.getInt(2);
        return jumlah;
    }
    public String ambildate (int id,String tipe){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        switch (tipe){
            case("Grocery"): cursor = db.rawQuery("SELECT * FROM grocery;",null);    break;
            case("Transport"):cursor = db.rawQuery("SELECT * FROM transport;",null);break;
            case("Entertainment"):cursor = db.rawQuery("SELECT * FROM entertainment;",null);break;
            case("Saving"):cursor = db.rawQuery("SELECT * FROM saving;",null);break;
        }
        assert cursor != null;
        cursor.moveToFirst();
        for (int i=0;i<id;i++){
            cursor.moveToNext();
        }
        String date = cursor.getString(3);
        return date;
    }
    public void hapus (int id,String tipe){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int usid = 0;
        switch (tipe){
            case("Grocery"): cursor = db.rawQuery("SELECT * FROM grocery;",null);
                assert cursor != null;
                cursor.moveToFirst();
                for (int i=0;i<id;i++){
                    cursor.moveToNext();
                }
                usid = cursor.getInt(0);
                db.execSQL("DELETE FROM grocery WHERE id = " + usid);
            break;
            case("Transport"):cursor = db.rawQuery("SELECT * FROM transport;",null);
                assert cursor != null;
                cursor.moveToFirst();
                for (int i=0;i<id;i++){
                    cursor.moveToNext();
                }
                 usid = cursor.getInt(0);
                db.execSQL("DELETE FROM transport WHERE id = " + usid);
                break;
            case("Entertainment"):cursor = db.rawQuery("SELECT * FROM entertainment;",null);
                assert cursor != null;
                cursor.moveToFirst();
                for (int i=0;i<id;i++){
                    cursor.moveToNext();
                }
                usid = cursor.getInt(0);
                db.execSQL("DELETE FROM entertainment WHERE id = " + usid);
                break;
            case("Saving"):cursor = db.rawQuery("SELECT * FROM saving;",null);
                assert cursor != null;
                cursor.moveToFirst();
                for (int i=0;i<id;i++){
                    cursor.moveToNext();
                }
                usid = cursor.getInt(0);
                db.execSQL("DELETE FROM saving WHERE id = " + usid);
                break;
        }
    }
    public void edit (int id,String tipe,String nama,int jumlah ){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int usid = 0;
        switch (tipe){
            case("Grocery"): cursor = db.rawQuery("SELECT * FROM grocery;",null);
                assert cursor != null;
                cursor.moveToFirst();
                for (int i=0;i<id;i++){
                    cursor.moveToNext();
                }
                usid = cursor.getInt(0);
                db.execSQL("UPDATE grocery SET nama = '" + nama + "', jumlah = '"+ jumlah +"' WHERE id = " + usid);
                break;
            case("Transport"):cursor = db.rawQuery("SELECT * FROM transport;",null);
                assert cursor != null;
                cursor.moveToFirst();
                for (int i=0;i<id;i++){
                    cursor.moveToNext();
                }
                usid = cursor.getInt(0);
                db.execSQL("UPDATE transport SET nama = '" + nama + "', jumlah = '"+ jumlah +"' WHERE id = " + usid);
                break;
            case("Entertainment"):cursor = db.rawQuery("SELECT * FROM entertainment;",null);
                assert cursor != null;
                cursor.moveToFirst();
                for (int i=0;i<id;i++){
                    cursor.moveToNext();
                }
                usid = cursor.getInt(0);
                db.execSQL("UPDATE entertainment SET nama = '" + nama + "', jumlah = '"+ jumlah +"' WHERE id = " + usid);
                break;
            case("Saving"):cursor = db.rawQuery("SELECT * FROM saving;",null);
                assert cursor != null;
                cursor.moveToFirst();
                for (int i=0;i<id;i++){
                    cursor.moveToNext();
                }
                usid = cursor.getInt(0);
                db.execSQL("UPDATE saving SET nama = '" + nama + "', jumlah = '"+ jumlah +"' WHERE id = " + usid);
                break;
        }
    }
    public void tambah (String tipe,String nama, int jumlah){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        String tanggal = dateFormat.format(new Date());
        switch (tipe){
            case("Transport"):
                cursor = db.rawQuery("SELECT * FROM transport",null);
                cursor.moveToLast();
                db.execSQL("insert into transport(nama,jumlah,date) values ('"+ nama+"','"+jumlah+"','" + tanggal + "')");
                cursor.close();
                break;

            case("Grocery"):
                cursor = db.rawQuery("SELECT * FROM grocery",null);
                cursor.moveToLast();
                db.execSQL("insert into grocery(nama,jumlah,date) values ('"+ nama+"','"+jumlah+"','" + tanggal + "')");
                cursor.close();
                break;

            case("Entertainment"):
                cursor = db.rawQuery("SELECT * FROM entertainment",null);
                cursor.moveToLast();
                db.execSQL("insert into entertainment(nama,jumlah,date) values ('"+ nama+"','"+jumlah+"','" + tanggal + "')");
                cursor.close();
                break;

            case("Saving"):

                cursor = db.rawQuery("SELECT * FROM saving",null);
                cursor.moveToLast();
                db.execSQL("insert into saving(nama,jumlah,date) values ('"+ nama+"','"+jumlah+"','" + tanggal + "')");
                cursor.close();
                break;
        }


    }

    public int ambilbulan(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM bulanan",null);
        cursor.moveToFirst();
        int juml = cursor.getInt(0);

        return juml;
    }

    public void editbulanan(int juml){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM bulanan",null);
        cursor.moveToFirst();
        db.execSQL("UPDATE bulanan SET jumlah = " + juml);
    }

    @SuppressLint("Range")
    public int ambilTotal(){
        int jumlahtotal =1;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;

        cursor = db.rawQuery("Select SUM (jumlah) as Total from grocery",null);
        cursor.moveToFirst();
        jumlahtotal += cursor.getInt(cursor.getColumnIndex("Total"));
        cursor.close();

        cursor = db.rawQuery("Select SUM (jumlah) from entertainment",null);
        cursor.moveToFirst();
        jumlahtotal += cursor.getInt(0);
        cursor.close();
        cursor = db.rawQuery("Select SUM (jumlah) from transport",null);
        cursor.moveToFirst();
        jumlahtotal += cursor.getInt(0);
        cursor = db.rawQuery("Select SUM (jumlah) from saving",null);
        cursor.moveToFirst();
        jumlahtotal += cursor.getInt(0);
        cursor.close();
        return jumlahtotal;
    }


}