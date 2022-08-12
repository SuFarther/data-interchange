package com.onecbuying;

import com.onecbuying.pojo.User;
import org.dom4j.DocumentException;
import org.junit.Test;

/**
 * @version 1.0
 * @ClassName ClassPathXmlApplicationContextTest
 * @company 公司
 * @Description TODO
 * @createTime 2022年08月13日 00:18:18
 */
public class ClassPathXmlApplicationContextTest {

    @Test
    public void testClassPathXmlApplicationContext() throws DocumentException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1、读取springxml配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、获取bean对象
        User user1 = (User) classPathXmlApplicationContext.getBean("user1");
        System.out.println(user1.getUserId()+"------"+user1.getUserName());
        User user2= (User) classPathXmlApplicationContext.getBean("user2");
        System.out.println(user2.getUserId()+"------"+user2.getUserName());
    }
}
