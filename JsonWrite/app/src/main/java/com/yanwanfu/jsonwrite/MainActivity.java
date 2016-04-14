package com.yanwanfu.jsonwrite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//把数据输出成Json格式
/**
 * 输出效果 *
 * {
 *  "languages":[
 *      {"id":1,"ide":"Eclipse","name":"Java"},
 *      {"id":2,"ide":"XCode","name":"swife"},
 *      {"id":3,"ide":"Visual Studio","name":"C#"}
 *       ],
 *  "cat":"it"
 * }
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            JSONObject root = new JSONObject();
            root.put("cat", "it");

            JSONObject lan1 = new JSONObject();
            lan1.put("id",1);
            lan1.put("ide","Eclipse");
            lan1.put("name","Java");

            JSONObject lan2 = new JSONObject();
            lan2.put("id",2);
            lan2.put("ide","XCode");
            lan2.put("name","swife");

            JSONObject lan3 = new JSONObject();
            lan3.put("id",3);
            lan3.put("ide","Visual Studio");
            lan3.put("name","C#");

            JSONArray array = new JSONArray();
            array.put(lan1);
            array.put(lan2);
            array.put(lan3);

            root.put("languages",array);

            System.out.println(root.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
