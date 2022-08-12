package com.onecbuying;

import com.onecbuying.pojo.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0
 * @ClassName ReflectionTest
 * @company 公司
 * @Description 反射测试类
 * @createTime 2022年08月12日 14:55:55
 */
public class ReflectionTest {

    /*
    **
     * @description:
     * @param:
     * @return: void
     * @author 苏东坡
     * @date: 2022/8/12 2:56 PM
     */
    @Test
    public void testUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
      //1、new方式创建对象
        User user = new User();
        System.out.println(user);
        // 2、 使用java的反射机制创建对象Class.forName("类的完整路径");
        Class<?> forName = Class.forName("com.onecbuying.pojo.User");
       //使用默认无参构造函数创建对象forName.newInstance();使用java的反射机制创建对象
        //forName.newInstance默认走的是类的无参构造函数,把类的无参构造函数私有化就可以禁止反射
        User user2 = (User) forName.newInstance();
        user2.setId("22");
        System.out.println(user2);
        //创建带有参的构造函数
        Constructor<?> constructor = forName.getConstructor(String.class, String.class);
        User user3 = (User) constructor.newInstance("12", "西瓜");
        System.out.println("使用有参构造函数:"+user3);

    }
}
