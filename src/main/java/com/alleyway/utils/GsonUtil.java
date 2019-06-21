package com.alleyway.utils;

/**
 * describe:
 *
 * Gson与javaBean   List<bean> 之间的转换
 *
 * @author: 洪
 */
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Json2Bean / Json2List / Json2List<T>
 *
 * @author hcq
 */
public class GsonUtil {

    private GsonUtil() {

    }

    /**
     * Json 转为 bean
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T bean4Json(String json, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);

    }

    /**
     * Json 转为 List<bean>
     *
     * @param json
     * @param typeclazz
     * @param <T>
     * @return
     */
    public static <T> List<T> list4Json(String json, Class<T> typeclazz) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(typeclazz);
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    /**
     * 参数类型转换
     */
    private static class ParameterizedTypeImpl implements ParameterizedType {
        private Class clazz;

        public ParameterizedTypeImpl(Class clz) {
	  clazz = clz;
        }

        public Type[] getActualTypeArguments() {
	  return new Type[]{clazz};
        }

        public Type getRawType() {
	  return List.class;
        }

        public Type getOwnerType() {
	  return null;
        }
    }

    public static void main(String[] args) {

        String json1 = "{\"id\":1,\"name\":\"eric\"}";
        String json2 = "[{\"id\":1,\"name\":\"eric\"},{\"id\":2,\"name\":\"john\"}]";
        String json3 = "{\"page\":1,\"size\":10,\"total\":2,\"data\":[{\"id\":1,\"name\":\"eric\"},{\"id\":2,\"name\":\"john\"}]}";

        String helloworld = "helloworld!";
        String bl = "false";
        String integer = "123";
        String db = "23423d";

        User user = GsonUtil.bean4Json(json1, User.class);
        List<User> lists = GsonUtil.list4Json(json2, User.class);
        Page<User> page = GsonUtil.bean4Json(json3, Page.class);

        String res1 = GsonUtil.bean4Json(helloworld, String.class);
        Boolean res2 = GsonUtil.bean4Json(bl, Boolean.class);
        Integer res3 = GsonUtil.bean4Json(integer, Integer.class);
        Double res4 = GsonUtil.bean4Json(db, Double.class);

        System.out.println("user:" + user);
        System.out.println("lists:" + lists);
        System.out.println("page:" + page);

        User user1 = lists.get(0);
        System.out.println("user1:" + user1);

        System.out.println("===");

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }

    private class Page<T> {
        private int page;

        private int size;

        private int total;

        private List<T> data;

        public int getPage() {
	  return page;
        }

        public void setPage(int page) {
	  this.page = page;
        }

        public int getSize() {
	  return size;
        }

        public void setSize(int size) {
	  this.size = size;
        }

        public int getTotal() {
	  return total;
        }

        public void setTotal(int total) {
	  this.total = total;
        }

        public List<T> getData() {
	  return data;
        }

        public void setData(List<T> data) {
	  this.data = data;
        }

        @Override
        public String toString() {
	  return "User [page=" + page + ", size=" + size + ", total=" + total + ", data=" + data + "]";
        }
    }

    private class User {
        private int id;

        private String name;

        public int getId() {
	  return id;
        }

        public void setId(int id) {
	  this.id = id;
        }

        public String getName() {
	  return name;
        }

        public void setName(String name) {
	  this.name = name;
        }

        @Override
        public String toString() {
	  return "User [id=" + id + ", name=" + name + "]";
        }
    }
}