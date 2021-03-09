package com.example.akanksha.json_services_179;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void nextpage(View view) {
        Intent intent=new Intent(MainActivity.this,Home.class);
        startActivity(intent);
    }

}