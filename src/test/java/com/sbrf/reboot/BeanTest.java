package com.sbrf.reboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    void BeanTestXML(){
        System.out.println("Инициализация бинов через xml");
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClientBean client=(ClientBean) ctx.getBean("clientBean", ClientBean.class);
        assertEquals("Neil",client.getName());
        assertEquals(32, client.getAge());
        AccountBean account=(AccountBean) ctx.getBean("accountBean", AccountBean.class);
        assertEquals(234,account.getNumber());
        assertEquals(56789,account.getBalance());
        assertEquals("USD",account.getCurrency());
        ctx.close();
    }

    @Test
    void BeanTestConfig(){
        System.out.println("Инициализация бинов через аннотации");
        ApplicationContext ctx= new AnnotationConfigApplicationContext(BeanConfig.class);
        ClientBean client=(ClientBean) ctx.getBean("clientBean", ClientBean.class);
        assertEquals("Neil",client.getName());
        assertEquals(32, client.getAge());
        AccountBean account=(AccountBean) ctx.getBean("accountBean", AccountBean.class);
        assertEquals(234,account.getNumber());
        assertEquals(56789,account.getBalance());
        assertEquals("USD",account.getCurrency());
    }
}
