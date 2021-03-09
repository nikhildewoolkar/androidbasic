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
    EditText txtname,txtage,txtgender,txtdob,txtuname,txtpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper=new DatabaseHelper(this);
        btnlogin=(Button)findViewById(R.id.btnlog);
        btnreg=(Button)findViewById(R.id.regbtn);
        txtname=(EditText)findViewById(R.id.nameedittxt);
        txtage=(EditText)findViewById(R.id.ageedittxt);
        txtpass=(EditText)findViewById(R.id.genderedittxt);
        txtgender=(EditText)findViewById(R.id.genderedittxt);
        txtuname=(EditText)findViewById(R.id.unameedittxt);
        txtdob=(EditText)findViewById(R.id.dobedittxt);

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
                String name=txtname.getText().toString();
                String age=txtage.getText().toString();
                String pass=txtpass.getText().toString();
                String uname=txtuname.getText().toString();
                String gender=txtgender.getText().toString();
                String dob=txtdob.getText().toString();
                InsertData(name,age,gender,dob,uname,pass);
                Toast.makeText(getApplicationContext(),"Registered Successfully with the login",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void InsertData(String name, String age, String gender, String dob, String uname, String pass)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, name);
        contentValues.put(DatabaseHelper.COL_3, age);
        contentValues.put(DatabaseHelper.COL_4, gender);
        contentValues.put(DatabaseHelper.COL_5, dob);
        contentValues.put(DatabaseHelper.COL_6, uname);
        contentValues.put(DatabaseHelper.COL_7, pass);
        long id=db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }

}
