package com.wd.util;




import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.atomic.AtomicInteger;

public class asd2 extends Thread{

    //10个原子对象 对应每个线程的执行记录
    private static AtomicInteger[] count = new AtomicInteger[10];

    public static void addi()
    {
//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");System.out.println(dateFormat.format(date));


        String url="http://111.9.27.52:6880/partnerService/getProStop?partnerid=test&sign=123";
		       /* Map<String,String> map=new HashMap<>();
		        map.put("carno","川AR112C");
		        String json= JSON.toJSONString(map);*/
        String b[]={"川A1000I","川A100I","川A1002I","川A1003I","川A1004I","川A1005I","川A1006I","川A1007I","川A1008I","川A1009I"};
        Random r = new Random();
        String x = b[r.nextInt(10)];
        String params = "{\"carno\":'"+x+"'}";
        String result;

        long start = System.currentTimeMillis();
        result = sendJsonHttpPost(url, params);
        long end = System.currentTimeMillis();
        Long id=Long.valueOf(Thread.currentThread().getName().split("-")[1]);
        System.out.println(id);
        int i=count[id.intValue()].addAndGet(1);
        String allresult=Thread.currentThread().getName() + "，执行到第" + i + "次"+"\n";
        allresult+=x+"\n"+params+"\n"+result+"\n";
        allresult+=Thread.currentThread().getName()+"结束:-----耗时："+(end-start)+"毫秒"+"\n";

        if((end-start)>3000) {
            System.out.println("!!!!!!!!!!线程3秒超时");
            allresult+="!!!!!!!!!!线程3秒超时"+"\n";
        }
        System.out.println(allresult);
        writeFile(allresult);
    }

    //获取线程ID
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

    public static String writeFile(String context) {
        FileWriter fw = null;
        try {
            String fileName=Thread.currentThread().getName();
            File f=new File("D:/"+fileName+".txt");
            if(!f.exists()){
                f.createNewFile();
            }
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(context);
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
        for (int i = 0; i < 2000; i++) {
            addi();
        }
    }

    public static void main(String args[]) throws InterruptedException, BrokenBarrierException
    {
        asd[] vaList = new asd[10];

        for (int i = 0; i < vaList.length; i++) {
            vaList[i] = new asd();
            count[i]=new AtomicInteger(1);
        }
        for (int i = 0; i < vaList.length; i++) {
            vaList[i].start();

        }
        for (int i = 0; i < vaList.length; i++) {
            vaList[i].join();
            vaList[i].sleep(5000);
        }
        System.out.println("#######################################################");


    }


}