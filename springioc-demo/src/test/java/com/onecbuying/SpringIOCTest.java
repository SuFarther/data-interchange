package com.onecbuying;

import com.onecbuying.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version 1.0
 * @ClassName SpringIOCTest
 * @company 公司
 * @Description classPathXmlApplicationContext.getBean源码分析
 * 1、调用ApplicationContext的genBean方法会调用到AbstractApplicationContext的getBean方法，
 * 这个方法里面其实就是交由BeanFactory调用getBean
 * 2、DefaultListableBeanFactory中会先根据类型获取beanNames,然后根据beanName调用AbstractBeanFactory
 * 的doGetBean方法
 * 3、AbstractBeanFactory中首先转化beanName，然后看去缓存map中看是否存在已有数据，第一次调用肯定返回null。
 * 然后去获取RootBeanDefinition，获取DependsOn依赖的bean，如果存在依赖Bean需要先初始化依赖的bean，之后调用
 * getSingleton方法来获取单例类
 * 4、在DefaultSingletonBeanRegistry#getSingleton中又调用ObjectFactory#getObject来获取对象，这个函数
 * 里面主要调用了createBean来生成对象
 * 5、AbstractAutowireCapableBeanFactory#createBean
 *   5.1、resolveBeanClass根据BeanDefinition获取Bean的类并加载
 *   5.2、doCreateBean-->createBeanInstance这里会获取Bean的构建方法，并根据是否有构建方法，
 *   是否有构建参数最终bean的构建方式
 *   5.3、autowireConstructor会构建ConstructorResolver来构建Bean
 * 6、ConstructorResolver#autowireConstructor，从BeanDefinition中获取构建参数，之后根据Bean的class
 * 获取已有的构造函数并根据构造参数值获取相匹配的构造函数，之后就是调用SimpleInstantiationStrategy#instantiate
 * 方法，这个方法里面其实就是调用BeanUtils.instantiateClass(ctor, args)方法，利用java的反射机制来构建一个对象，
 * 到此就得到了需要构建的对象
 * 7、之后再AbstractAutowireCapableBeanFactory中会调用bean相关的PostProcessor，之后会调用populateBean方法
 * 8、populateBean这个方法会判断Bean是否autowire，如果是的话会进行自动注入，最后会调用applyPropertyValues方法，
 * 这个方法看名字也很好理解，就是对配置的属性值进行写入。到这里这个Bean的构建基本全部完成了，后续就是将Bean写入缓存Map
 * ，注册单例类等操作
 * @createTime 2022年08月12日 23:33:33
 */
public class SpringIOCTest {

    @Test
    public void testSpringIoc1(){
        //1、读取springxml配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、获取bean对象
        User user1 = (User) classPathXmlApplicationContext.getBean("user1");
        System.out.println(user1.getUserId()+"------"+user1.getUserName());
        User user2= (User) classPathXmlApplicationContext.getBean("user2");
        System.out.println(user2.getUserId()+"------"+user2.getUserName());
    }
}
