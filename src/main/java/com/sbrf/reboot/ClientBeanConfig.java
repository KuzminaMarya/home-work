package com.sbrf.reboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientBeanConfig {
   @Bean
    public ClientBean clientBean(){
       return new ClientBean("Neil");
   }
}
