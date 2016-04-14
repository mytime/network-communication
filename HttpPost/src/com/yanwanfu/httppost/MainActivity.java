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
 * 使用Http post 方式读写网络数据的方法
 * 
 * 申请翻译接口
 * http://fanyi.youdao.com/openapi?path=data-mode
 * 
 * 授权的地址
 * http://fanyi.youdao.com/openapi.do?keyfrom=niupeiwang&key=412892605&type=data&doctype=json&version=1.1&q=good
 * 
 * 网址部分：http://fanyi.youdao.com/openapi.do
 * 
 * 参数部分：?keyfrom=niupeiwang&key=412892605&type=data&doctype=json&version=1.1&q=good
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
				//String : 初始值
				//void   : 过程
				//void   : 结果
				//ctrl+1 补全未导入的方法
				new AsyncTask<String ,Void, Void>(){

					@Override
					protected Void doInBackground(String... params) {
						try {
							URL url = new URL(params[0]); 								//params[0] execute("http://fanyi.youdao.com/openapi.do")
							HttpURLConnection connection = (HttpURLConnection)url.openConnection();						//打开Url
							
							//........输出................
							connection.setDoOutput(true);								//默认是关闭的
							connection.setDoInput(true);
							connection.setUseCaches(false);								//忽略缓存
							connection.setRequestMethod("POST");						//请求方式
							
							OutputStream os =  connection.getOutputStream();
							OutputStreamWriter osw = new OutputStreamWriter(os,"utf-8");
							BufferedWriter bWriter = new BufferedWriter(osw);
							bWriter.write("keyfrom=niupeiwang&key=412892605&type=data&doctype=json&version=1.1&q=good"); //参数部分
							bWriter.flush();											//强制输出
							
							
							//.........输入...............
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
					
				}.execute("http://fanyi.youdao.com/openapi.do"); 														//网址部分
				
			}
		});
    }
   
}
