package com.onecbuying;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.onecbuying.pojo.User;
import org.junit.Test;

/**
 * @version 1.0
 * @ClassName JsonTest
 * @company 公司
 * @Description JSON转JSON对象,JSON对象转JSON数组
 * @createTime 2022年08月11日 15:05:05
 */
public class JsonTest {

    @Test
    public void testJSON(){
        String json = "{\"id\":\"20\",\"name\":\"苏东坡\",\"items\":[{\"itemId\":\"20\",\"itemName\":\"猫咪科技\"},{\"itemId\":\"21\",\"itemName\":\"猫咪俱乐部\"}]}{\"id\":\"20\",\"name\":\"苏东坡\",\"items\":[{\"itemId\":\"20\",\"itemName\":\"猫咪科技\"},{\"itemId\":\"21\",\"itemName\":\"猫咪俱乐部\"}]}";
        // 先转换成jsonobject对象
        JSONObject jsonObject = JSONObject.parseObject(json);
        //  String id = (String) jsonobject.get("id");
        String id = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        System.out.println("id:"+id+",name:"+name);
        // 把对象转成对象数组
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (int i = 0; i < jsonArray.size(); i++){
            JSONObject object = jsonArray.getJSONObject(i);
//            JSONObject object2 = (JSONObject) jsonObject.get(i);
            String itemId = object.getString("itemId");
            String itemName = object.getString("itemName");
            System.out.println("itemId:"+itemId+",itemName:"+itemName);
            System.out.println("itemId:"+itemId+",itemName:"+itemName);
        }
    }


    /*
    **
     * @description:  json转对象(企业用的最多)
     * @param:
     * @return: void
     * @author 苏东坡
     * @date: 2022/8/11 3:39 PM
     */
    @Test
    public void testJSON2(){
        String json = "{\"id\":\"20\",\"name\":\"苏东坡\",\"items\":[{\"itemId\":\"20\",\"itemName\":\"猫咪科技\"},{\"itemId\":\"21\",\"itemName\":\"猫咪俱乐部\"}]}{\"id\":\"20\",\"name\":\"苏东坡\",\"items\":[{\"itemId\":\"20\",\"itemName\":\"猫咪科技\"},{\"itemId\":\"21\",\"itemName\":\"猫咪俱乐部\"}]}";
        User user = JSONObject.parseObject(json, User.class);
        System.out.println(user);
    }
}
