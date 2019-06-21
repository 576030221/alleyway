package com.alleyway.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis对java对象的存储
 *
 * redis有一个问题，就是在存对象的时候，会序列化成2进制文件。
 * 但是我们需要的是存的json格式的文件，这样方便我们测试，调试。
 * 而一般解决这个问题的方法，是需要在配置类中对这个类进行一些相关的配置，但是这样对每个类都要配置比较麻烦。
 * 这里我们采用别的方法，存的时候采用阿里巴巴的json对对象转化成json的String类型，然后存进去，取得时候需要传入转换成的类类型
 *
 */

@Service
public class RedisTemplateService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 将对象存入到redis中
     * 示例代码
     * redisTemplateService.set("key1",user);
     * 其中的user是User对象
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(String key ,T value){

        try {

	  //任意类型转换成String
	  String val = beanToString(value);

	  if(val==null||val.length()<=0){
	      return false;
	  }

	  stringRedisTemplate.opsForValue().set(key,val);
	  return true;
        }catch (Exception e){
	  return false;
        }
    }

    /**
     * 将对象从redis中获取出来
     * 示例代码
     * redisTemplateService.get("key1",User.class);
     * 需要传入User字节码文件
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key,Class<T> clazz){
        try {
	  String value = stringRedisTemplate.opsForValue().get(key);

	  return stringToBean(value,clazz);
        }catch (Exception e){
	  return null ;
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T stringToBean(String value, Class<T> clazz) {
        if(value==null||value.length()<=0||clazz==null){
	  return null;
        }

        if(clazz ==int.class ||clazz==Integer.class){
	  return (T)Integer.valueOf(value);
        }
        else if(clazz==long.class||clazz==Long.class){
	  return (T)Long.valueOf(value);
        }
        else if(clazz==String.class){
	  return (T)value;
        }else {
	  return JSON.toJavaObject(JSON.parseObject(value),clazz);
        }
    }

    /**
     *
     * @param Every T values
     * @param T 任意类型
     * @return String
     */
    private <T> String beanToString(T value) {

        if(value==null){
	  return null;
        }
        Class <?> clazz = value.getClass();
        if(clazz==int.class||clazz==Integer.class){
	  return ""+value;
        }
        else if(clazz==long.class||clazz==Long.class){
	  return ""+value;
        }
        else if(clazz==String.class){
	  return (String)value;
        }else {
	  return JSON.toJSONString(value);
        }
    }

}
