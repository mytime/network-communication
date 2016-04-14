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
 * ʹ��Http get ��ʽ��ȡ�������ݵķ���
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
				//�첽
				//String :��ʼֵ
				//void: ����
				//void: ���
				//ctrl+1 ��ȫδ����ķ���
				new AsyncTask<String ,Void, Void>(){

					@Override
					protected Void doInBackground(String... params) {
						try {
							URL url = new URL(params[0]); 								//params[0] ȡ��һ��ֵ
							URLConnection connection = url.openConnection();			//��Url
							InputStream is = connection.getInputStream();				//��ȡ����������
							InputStreamReader isr = new InputStreamReader(is,"utf-8");	//���ֽ���ת���ַ���
							BufferedReader bReader = new BufferedReader(isr);			//�����ȡ
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
