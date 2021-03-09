package com.example.akanksha.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.editText);
        password=findViewById(R.id.editText3);
        login=findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.equals(username.getText().toString(),"admin")&& Objects.equals(password.getText().toString(),"password"))
                {
                    Toast.makeText(MainActivity.this,"You have successfully Authenticated",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(MainActivity.this,home.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Authentication Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
