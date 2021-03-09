package com.example.database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button btnreg;
    Button btnlogin;
    EditText txtname,txtage,txtpass,txtemail,txtphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper=new DatabaseHelper(this);
        btnlogin=(Button)findViewById(R.id.btnlog);
        btnreg=(Button)findViewById(R.id.regbtn);
        txtfname=(EditText)findViewById(R.id.fnameedittxt);
        txtlname=(EditText)findViewById(R.id.lnameedittxt);
        txtpass=(EditText)findViewById(R.id.passedittxt);
        txtemail=(EditText)findViewById(R.id.emailedittxt);
        txtphone=(EditText)findViewById(R.id.phoneedittxt);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String fname=txtfname.getText().toString();
                String lname=txtlname.getText().toString();
                String pass=txtpass.getText().toString();
                String email=txtemail.getText().toString();
                String phone=txtphone.getText().toString();
                InsertData(fname,lname,pass,email,phone);
                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void InsertData(String fname,String lname,String pass,String email,String phone)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, fname);
        contentValues.put(DatabaseHelper.COL_3, lname);
        contentValues.put(DatabaseHelper.COL_4, pass);
        contentValues.put(DatabaseHelper.COL_5, email);
        contentValues.put(DatabaseHelper.COL_6, phone);
        long id=db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }

}
