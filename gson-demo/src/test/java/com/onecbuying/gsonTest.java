package com.onecbuying;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import pojo.Items;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName gsonTest
 * @company 公司
 * @Description TODO
 * @createTime 2022年08月11日 16:23:23
 */
public class gsonTest {

    /*
    **
     * @description: 转换普通对象（Bean）
     * 将JavaBean转换为json，或将json字符串转换为JavaBean
     * 使用Gson解析Person的实例
     * 先创建Items对象。
     *  在创建Gson对象。
     *  调用Gson的String toJson(Object)方法，来将对象转换为json字符串
     * @param:
     * @return: void
     * @author 苏东坡
     * @date: 2022/8/11 4:26 PM
     */
    @Test
    public void testGsonJavaBean(){
        List<Items> listItems = new ArrayList<>();
        //创建Bean
        Items i1 = new Items("22","抖音科技");
        Items i2 = new Items("23","抖音俱乐部");
        listItems.add(i1);
        listItems.add(i2);
        //创建Gson对象
        Gson  gson = new Gson();
        // 调用Gson的String toJson(Object)方法将Bean转换为json字符串
        String listJson = gson.toJson(listItems);
        System.out.println(listJson);


//        将Items实例的json字符串转换为Items对象
//        调用Gson的 T fromJson(String, Type)将List集合的json串反序列化为List对象

        List<Items> plist = gson.fromJson(listJson, new TypeToken<List<Items>>(){}.getType());

        System.out.println(plist);
    }


    /*
    **
     * @description: gson转map集合
     * @param:
     * @return: void
     * @author 苏东坡
     * @date: 2022/8/11 4:53 PM
     */
    @Test
    public void testGsonMap(){
        Map<String,Items> map = new HashMap<>();
        map.put("p1",new Items("20","小白科技"));
        map.put("p2",new Items("21","小白俱乐部"));
        //创建Gson对象
        Gson  gson = new Gson();
        // 调用Gson的String toJson(Object)方法将Bean转换为json字符串
        String mapJson = gson.toJson(map);
        System.out.println(mapJson);
        Map<String, Items> jsonMap = gson.fromJson(mapJson, new TypeToken<Map<String, Items>>() {}.getType());
        System.out.println(jsonMap);
    }
}
