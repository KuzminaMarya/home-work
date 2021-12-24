package com.sbrf.reboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    void BeanTest(){

        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");//Для bin через xml
        ApplicationContext ctx1=new AnnotationConfigApplicationContext(ClientBeanConfig.class);//Для bin через аннотации
        ClientBean client=(ClientBean) ctx.getBean("clientBean", ClientBean.class);
        assertEquals("Neil",client.getName());
    }
}
