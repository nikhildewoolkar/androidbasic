package com.example.akanksha.json_179;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String JSON_STRING = "{\"employee\":{\"name\":\"AKanksha Singh\",\"salary\":65000}}";
    String name, salary;
    TextView employeeName, employeeSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        employeeName = (TextView) findViewById(R.id.name);
        employeeSalary = (TextView) findViewById(R.id.salary);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(JSON_STRING);
            JSONObject employee = obj.getJSONObject("employee");
            // get employee name and salary
            name = employee.getString("name");
            salary = employee.getString("salary");
            // set employee name and salary in TextView's
            employeeName.setText("Name: "+name);
            employeeSalary.setText("Salary: "+salary);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
