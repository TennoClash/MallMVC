package com.wd.util;






import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;

public class asd extends Thread{
	public static int i=0;
	public static String oneresult="";
	public static String allresult="";
	CountDownLatch latch = new CountDownLatch(10);
	public static synchronized void addi()
	{
//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");System.out.println(dateFormat.format(date));
				
		
		String url="http://testlpn.ebopark.com:80/partnerService/getProStop?partnerid=test&sign=123";
		       /* Map<String,String> map=new HashMap<>();
		        map.put("carno","川AR112C");
		        String json= JSON.toJSONString(map);*/
		        String x = "川A"+getCode(5);
		        String params = "{\"carno\":'"+x+"'}";
		        String result;
		        long start = System.currentTimeMillis();
				
				
					result = sendJsonHttpPost(url, params);
					long end = System.currentTimeMillis(); 
					allresult+=Thread.currentThread().getName() + "，执行到第" + i + "次"+"\n";
					oneresult+=x+"\n"+params+"\n"+result+"\n";
					allresult+=Thread.currentThread().getName()+"结束:-----耗时："+(end-start)+"毫秒"+"\n";
					

	}
			
		    public static String sendJsonHttpPost(String url, String json) {

		        CloseableHttpClient httpclient = HttpClients.createDefault();
		        String responseInfo = null;
		        try {
		            HttpPost httpPost = new HttpPost(url);
		            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
		            ContentType contentType = ContentType.create("application/json", CharsetUtils.get("UTF-8"));
		            httpPost.setEntity(new StringEntity(json, contentType));
		            CloseableHttpResponse response = httpclient.execute(httpPost);
		            HttpEntity entity = response.getEntity();
		            int status = response.getStatusLine().getStatusCode();
		            if (status >= 200 && status < 300) {
		                if (null != entity) {
		                    responseInfo = EntityUtils.toString(entity);
		                }
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                httpclient.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		        return responseInfo;
		       
	}
		 
		    public static String getCode(int n) {
				String string = "0123456789ABCDEFG";
				char[] ch = new char[n]; 
				for (int i = 0; i < n; i++) {
					Random random = new Random();
					int index = random.nextInt(string.length());
					ch[i] = string.charAt(index);
				}
				String result = String.valueOf(ch);
				return result;
			}

		    private static AtomicInteger count = new AtomicInteger(0);

		 
		    public static String allResult() {
		    	System.out.println(allresult);
		        FileWriter fw = null;
		        try {
		        File f=new File("D:/cs.txt");
		        fw = new FileWriter(f, true);
		        } catch (IOException e) {
		        e.printStackTrace();
		        }
		        PrintWriter pw = new PrintWriter(fw);
		        pw.println(allresult);
		        pw.flush();
		        try {
		        fw.flush();
		        pw.close();
		        fw.close();
		        } catch (IOException e) {
		        e.printStackTrace();
		        }
				return null;
		    }
		    
	public void run()
	{

				try {
					for (int i = 1; i < 10; i++) {
						long start = System.currentTimeMillis();
						addi();
						long end = System.currentTimeMillis(); 
						//count.incrementAndGet();
						System.out.println(Thread.currentThread().getName() + "，执行到第" + i + "次");
						allresult+=Thread.currentThread().getName() + "，执行到第" + i + "次"+"\n";
						System.out.println(this.currentThread().getName()+"结束:-----耗时："+(end-start)+"毫秒");
						allresult+=this.currentThread().getName()+"结束:-----耗时："+(end-start)+"毫秒"+"\n";
						if((end-start)>20000) {
							System.out.println("!!!!!!!!!!线程20秒超时");
							allresult+="!!!!!!!!!!线程20秒超时"+"\n";
						}
					} 
				} finally {
					
					latch.countDown();
					allresult+=oneresult;
				}
				
				
			  // System.out.println(getName()+","+count.get());
	   }
	


	public static void main(String args[]) throws InterruptedException, BrokenBarrierException
	{
		asd[] vaList = new asd[10];
		
		
        for (int i = 0; i < vaList.length; i++) {
            vaList[i] = new asd();
        }
        for (int i = 0; i < vaList.length; i++) {
            vaList[i].start();
            
        }
        for (int i = 0; i < vaList.length; i++) {
        	vaList[i].join();
        	vaList[i].sleep(3000);
        }
        allResult();
        System.out.println("#######################################################");
        
        
    }

		    
}


