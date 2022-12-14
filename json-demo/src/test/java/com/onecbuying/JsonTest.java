package com.onecbuying;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.onecbuying.pojo.Items;
import com.onecbuying.pojo.User;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


    /*
    **
     * @description:  自定义json(自己封装json)
     * @param:
     * @return: void
     * @author 苏东坡
     * @date: 2022/8/11 3:58 PM
     */
    @Test
    public void testCustomiseJSON(){
      JSONObject root =  new JSONObject();
      root.put("id",30);
      root.put("name","李四");
      JSONArray  jsonArray = new JSONArray();
      JSONObject object1 =  new JSONObject();
      object1.put("itemId",20);
      object1.put("itemName","西瓜科技");
      JSONObject object2 =  new JSONObject();
      object2.put("itemId",21);
      object2.put("itemName","西瓜俱乐部");
      jsonArray.add(object1);
      jsonArray.add(object2);
      root.put("items",jsonArray);
      System.out.println(root.toJSONString());
    }

    /*
    **
     * @description:  使用实体类封装字符串 对象转json
     * @param:
     * @return: void
     * @author 苏东坡
     * @date: 2022/8/11 4:07 PM
     */
    @Test
    public void testEncapsulateEntityJSON(){
        User user = new User();
        user.setId("70");
        user.setName("王五");
        List<Items> listItems = new ArrayList<>();
        Items item1 = new Items();
        item1.setItemId("22");
        item1.setItemName("抖音科技");
        Items item2 = new Items();
        item2.setItemId("23");
        item2.setItemName("抖音俱乐部");
        listItems.add(item1);
        listItems.add(item2);
        user.setItems(listItems);
        System.out.println(JSONObject.toJSONString(user));
    }

    /*
    **
     * @description:  读取xml文件
     * @param: null
     * @return:
     * @author 苏东坡
     * @date: 2022/8/12 2:08 PM
     */
    @Test
    public void testReadXml() throws DocumentException {
        //1、获取到读取对象
        SAXReader reader = new SAXReader();
        //读取文件 转换陈Document
        Document document = reader.read("/System/Volumes/Data/Security/work-file/idea_manage/data-interchange/数据交换格式&反射机制&SpringIOC原理分析资料/student.xml");
        //获取到根节点
        Element rootElement = document.getRootElement();
        getNodes(rootElement);
    }

    /*
    **
     * @description: 获取xml根节点下面的节点使用递归
     * @param: rootElement
     * @return: void
     * @author 苏东坡
     * @date: 2022/8/12 2:13 PM
     */
    public void getNodes(Element rootElement){
        String name = rootElement.getName();
        System.out.println("获取节点名称:"+name);
        //获取属性ID
        List<Attribute> attributes = rootElement.attributes();
        for(Attribute attribute : attributes) {
            System.out.println("属性名称:"+attribute.getName()+",属性值:"+attribute.getText());
        }
        if(!rootElement.getTextTrim().equals("")){
            System.out.println("属性名称:"+rootElement.getName()+",属性值:"+rootElement.getText());
        }
        //使用迭代器遍历(判断是否有下一个节点)
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while(elementIterator.hasNext()){
            Element next = elementIterator.next();
            getNodes(next);
        }
    }
}
