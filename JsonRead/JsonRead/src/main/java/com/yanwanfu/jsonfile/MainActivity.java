package com.yanwanfu.jsonfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 解析assets/test.json
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //读取流
            InputStreamReader isr = new InputStreamReader(getAssets().open("test.json"),"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line=br.readLine())!=null){
                System.out.println(line); //输出
                builder.append(line);
            }
            //Json对象（解析根节点）
            JSONObject root = new JSONObject(builder.toString());
            System.out.println("cat="+root.getString("cat"));
            //Json数组（解析数组节点）
            JSONArray array = root.getJSONArray("languages");
            for (int i = 0; i < array.length() ; i++) {
                JSONObject lan = array.getJSONObject(i);
                System.out.println("id="+lan.getInt("id"));
                System.out.println("ide="+lan.getString("ide"));
                System.out.println("name="+lan.getString("name"));
            }

            //关闭流
            br.close();
            isr.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
