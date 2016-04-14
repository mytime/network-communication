# network-communication
网络通信

##HttpGet
使用httget方式请求网络数据

###主要代码：
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
				
##HttpPost
使用httppost方式向网络提交数据和获取数据

###主要代码
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
					
				}.execute("http://fanyi.youdao.com/openapi.do"); 