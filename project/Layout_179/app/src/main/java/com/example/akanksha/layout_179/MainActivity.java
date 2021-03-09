package com.example.akanksha.layout_179;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    TextView result;
    Button add, sub, mul, div,next;
    int res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.editText);
        num2 = findViewById(R.id.editText2);
        result = findViewById(R.id.textView);
        add = findViewById(R.id.button);
        sub = findViewById(R.id.button2);
        mul = findViewById(R.id.button3);
        div = findViewById(R.id.button4);
        next=findViewById(R.id.button6);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = num1.getText().toString();
                String s2 = num2.getText().toString();
                res = Integer.parseInt(s1) + Integer.parseInt(s2);
                result.setText(Integer.toString(res));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a1 = num1.getText().toString();
                String a2 = num2.getText().toString();
                res = Integer.parseInt(a1) - Integer.parseInt(a2);
                result.setText(Integer.toString(res));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m1 = num1.getText().toString();
                String m2 = num2.getText().toString();
                res = Integer.parseInt(m1) * Integer.parseInt(m2);
                result.setText(Integer.toString(res));

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d1 = num1.getText().toString();
                String d2 = num2.getText().toString();
                res = Integer.parseInt(d1) / Integer.parseInt(d2);
                result.setText(Integer.toString(res));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,List.class);
                startActivity(i);
            }
        });
    }
}
