package com.example.akanksha.json_services_179;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String jsonStr = getListData();
        try {
            ArrayList<HashMap<String, String>> userList = new ArrayList<>();
            ListView lv = (ListView) findViewById(R.id.user_list);
            JSONObject jObj = new JSONObject(jsonStr);
            JSONArray jsonArry = jObj.getJSONArray("users");
            for (int i = 0; i < jsonArry.length(); i++) {
                HashMap<String, String> user = new HashMap<>();
                JSONObject obj = jsonArry.getJSONObject(i);
                user.put("name", obj.getString("name"));
                user.put("designation", obj.getString("designation"));
                user.put("location", obj.getString("location"));
                userList.add(user);
            }
            ListAdapter adapter = new SimpleAdapter(Home.this, userList, R.layout.list_row, new String[]{"name", "designation", "location"}, new int[]{R.id.name, R.id.designation, R.id.location});
            lv.setAdapter(adapter);
        } catch (JSONException ex) {
            Log.e("JsonParser Example", "unexpected JSON exception", ex);
        }
    }

    private String getListData() {
        String jsonStr = "{ \"users\" :[" +
                "{\"name\":\"Chris Dsouza\",\"designation\":\"Team Leader\",\"location\":\"Goa\"}" +
                ",{\"name\":\"Carol Rebeiro\",\"designation\":\"Assistant Leader\",\"location\":\"Mangalore\"}" +
                ",{\"name\":\"Ashvita Brice\",\"designation\":\"Member\",\"location\":\"Mumbai\"}" +
                ",{\"name\":\"Bosco Macklin\",\"designation\":\"Member\",\"location\":\"Mumbai\"}" +
                ",{\"name\":\"Shekhar Melito\",\"designation\":\"Member\",\"location\":\"Mumbai\"}" +
                ",{\"name\":\"ABC XYZ\",\"designation\":\"Member\",\"location\":\"Mumbai\"}" +
                ",{\"name\":\"AB CD\",\"designation\":\"Member\",\"location\":\"Mumbai\"}] }";
        return jsonStr;
    }

}
