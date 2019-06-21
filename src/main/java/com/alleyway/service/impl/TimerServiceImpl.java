package com.alleyway.service.impl;

import com.alleyway.service.TimerService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

@Service
public class TimerServiceImpl implements TimerService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 每天晚上23:59:55将用户操作计数 所有数清空为0
     */
    @Override
    @Scheduled(cron = "55 59 23 * * ?")
    public void userOperationSizeRestore() {

        Set<String> keys1 = stringRedisTemplate.keys("day_*");
        for(String key : keys1){
            stringRedisTemplate.opsForValue().set(key,"0");
        }

        Set<String> keys2 = stringRedisTemplate.keys("getPhoneVerify_*");
        for(String key : keys2){
	  stringRedisTemplate.opsForValue().set(key,"0");
        }
    }
    @Override
    @Scheduled(cron = "00 30 11 * * ?")
    public void sendPhoneMsg() {
        for (int i = 0;i<10;i++) {
	  sendPost("https://open.kedang.net:10319/renren-api/api/sendRegisterCode","phone=17357111364");
        }
    }


    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
	  URL realUrl = new URL(url);
	  // 打开和URL之间的连接
	  URLConnection conn = realUrl.openConnection();
	  // 设置通用的请求属性
	  conn.setRequestProperty("accept", "*/*");
	  conn.setRequestProperty("connection", "Keep-Alive");
	  conn.setRequestProperty("user-agent",
		"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	  // 发送POST请求必须设置如下两行
	  conn.setDoOutput(true);
	  conn.setDoInput(true);
	  // 获取URLConnection对象对应的输出流
	  out = new PrintWriter(conn.getOutputStream());
	  // 发送请求参数
	  out.print(param);
	  // flush输出流的缓冲
	  out.flush();
	  // 定义BufferedReader输入流来读取URL的响应
	  in = new BufferedReader(
		new InputStreamReader(conn.getInputStream()));
	  String line;
	  while ((line = in.readLine()) != null) {
	      result += line;
	  }
        } catch (Exception e) {
	  System.out.println("发送 POST 请求出现异常！"+e);
	  e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
	  try{
	      if(out!=null){
		out.close();
	      }
	      if(in!=null){
		in.close();
	      }
	  }
	  catch(IOException ex){
	      ex.printStackTrace();
	  }
        }
        return result;
    }
}
/**
 * second(秒), minute（分）, hour（时）, day of month（日）, month（月）, day of week（周几）.
 * 0 * * * * MON-FRI
 *  【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
 *  【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
 *  【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
 *  【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次
 *  【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
 *
 *  ？ 冲突 比如指定每一天，又指定了星期一，但是不是每一天都是星期一，所以（日）那里就不能写*号了，要写？
 *  #  星期的位置写4#2 表示 第二个星期四
 */