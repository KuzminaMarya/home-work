package com.sbrf.reboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
   @Bean
    public ClientBean clientBean(){
       return new ClientBean("Neil",32);
   }

    @Bean
    public AccountBean accountBean(){
        return new AccountBean(234,56789,"USD");
    }
}
