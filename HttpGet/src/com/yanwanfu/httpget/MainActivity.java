package com.yanwanfu.httpget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.yanwanfu.httpdemo.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * 使用Http get 方式读取网络数据的方法
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//异步
				//String :初始值
				//void: 过程
				//void: 结果
				//ctrl+1 补全未导入的方法
				new AsyncTask<String ,Void, Void>(){

					@Override
					protected Void doInBackground(String... params) {
						try {
							URL url = new URL(params[0]); 								//params[0] 取第一个值
							URLConnection connection = url.openConnection();			//打开Url
							InputStream is = connection.getInputStream();				//获取网络输入流
							InputStreamReader isr = new InputStreamReader(is,"utf-8");	//把字节流转成字符流
							BufferedReader bReader = new BufferedReader(isr);			//缓冲读取
							String line;												
							while((line = bReader.readLine())!= null){
								System.out.println(line);
							}
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}
					
				}.execute("https://api.douban.com/v2/book/1220562");
				
			}
		});
    }
   
}
