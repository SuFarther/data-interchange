package com.onecbuying;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ClassPathXmlApplicationContext
 * @company 公司
 * @Description 手写SpringIoC思路
 * 1、解析xml
 * 2、使用beanId查找对应xml节点,获取class节点属性
 * 3、使用java反射机制初始化类
 * 4、使用java的反射机制给私有属性
 * SpringIOC实现原理:
 * Dom4j+java反射机制
 * @createTime 2022年08月13日 00:00:00
 */
public class ClassPathXmlApplicationContext {
    private static String  PATH;
    private static String ID;
    private static String CLASS;
    private static String NAME;
    private static String VALUE;

    public void init(){
        ID = "id";
        CLASS = "class";
        NAME = "name";
        VALUE = "value";
    }

    public ClassPathXmlApplicationContext(String path){
        init();
        //获取spring读取文件名称
        PATH = path;
    }

    public Object getBean(String beanId) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1、解析xml
        if(StringUtils.isEmpty(beanId)){
            return null;
        }
        //1、读取资源文件
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(this.getClass().getClassLoader().getResource(PATH));
        //获取根节点(beans目录)
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();
        //遍历二级节点
        for (Element element : elements){
            String id = element.attributeValue(ID);
            if(!beanId.equals(id)){
                //结束本次循环
                continue;
            }
            // 2、使用beanid查找对应xml节点，获取class节点属性
            // 从配置文件中获取bean
            String attClass = element.attributeValue(CLASS);
            // 3、使用java的反射机制初始化类
            Class<?> forName = Class.forName(attClass);
            Object newInstance = forName.newInstance();
            // 4、获取属性
            List<Element> sonEle = element.elements();
            for (Element el : sonEle) {
                // 获取配置文件属性名称
                String attField = el.attributeValue(NAME);
                String attFieldValue = el.attributeValue(VALUE);
                Field declaredField = forName.getDeclaredField(attField);
                declaredField.setAccessible(true);
                declaredField.set(newInstance, attFieldValue);
            }
            return newInstance;
        }
        return null;
    }

}
