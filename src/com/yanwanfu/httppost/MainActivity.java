package com.yanwanfu.httppost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.yanwanfu.httpdemo.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

/**
 * ʹ��Http post ��ʽ��д�������ݵķ���
 * 
 * ���뷭��ӿ�
 * http://fanyi.youdao.com/openapi?path=data-mode
 * 
 * ��Ȩ�ĵ�ַ
 * http://fanyi.youdao.com/openapi.do?keyfrom=niupeiwang&key=412892605&type=data&doctype=json&version=1.1&q=good
 * 
 * ��ַ���֣�http://fanyi.youdao.com/openapi.do
 * 
 * �������֣�?keyfrom=niupeiwang&key=412892605&type=data&doctype=json&version=1.1&q=good
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
				//String : ��ʼֵ
				//void   : ����
				//void   : ���
				//ctrl+1 ��ȫδ����ķ���
				new AsyncTask<String ,Void, Void>(){

					@Override
					protected Void doInBackground(String... params) {
						try {
							URL url = new URL(params[0]); 								//params[0] execute("http://fanyi.youdao.com/openapi.do")
							HttpURLConnection connection = (HttpURLConnection)url.openConnection();						//��Url
							
							//........���................
							connection.setDoOutput(true);								//Ĭ���ǹرյ�
							connection.setDoInput(true);
							connection.setUseCaches(false);								//���Ի���
							connection.setRequestMethod("POST");						//����ʽ
							
							OutputStream os =  connection.getOutputStream();
							OutputStreamWriter osw = new OutputStreamWriter(os,"utf-8");
							BufferedWriter bWriter = new BufferedWriter(osw);
							bWriter.write("keyfrom=niupeiwang&key=412892605&type=data&doctype=json&version=1.1&q=good"); //��������
							bWriter.flush();											//ǿ�����
							
							
							//.........����...............
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
					
				}.execute("http://fanyi.youdao.com/openapi.do"); 														//��ַ����
				
			}
		});
    }
   
}
