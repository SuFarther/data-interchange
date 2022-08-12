package com.onecbuying;

import com.onecbuying.pojo.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
     * @description: Java反射机制获取类的对象
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
        //3、创建带有参的构造函数
        Constructor<?> constructor = forName.getConstructor(String.class, String.class);
        User user3 = (User) constructor.newInstance("12", "西瓜");
        System.out.println("使用有参构造函数:"+user3);
    }


    /*
    **
     * @description:  java反射机制所有私有属性
     * @param:
     * @return: void
     * @author 苏东坡
     * @date: 2022/8/12 3:17 PM
     */
    @Test
    public void testUser2() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
       //1、使用java的反射机制 获取类的所有属性 方法 并且为私有属性赋值
        Class<?> forName = Class.forName("com.onecbuying.pojo.User");
        // 2、获取到当前类的所有属性
        Field[] declaredFields = forName.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("获取类的属性成员:"+field.getName());
        }
        // 3、获取当前类的所有的方法
        Method[] declaredMethods = forName.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("获取类的所有方法名字:"+declaredMethod.getName());
        }
        // 4、使用java反射机制给私有属性赋值
        System.out.println("--------------");
        User user  = (User) forName.newInstance();
        Field fieldId = forName.getDeclaredField("id");
        //设置权限可以获取私有属性（允许反射操作私有属性）
        fieldId.setAccessible(true);
        fieldId.set(user,"20");
        Field fieldName = forName.getDeclaredField("name");
        //设置权限可以获取私有属性（允许反射操作私有属性）
        fieldName.setAccessible(true);
        fieldName.set(user,"张三");
        System.out.println(user);
    }
}
