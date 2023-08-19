package com.mycom.resourceservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.mycom.resourceservice.restclient"})
public class ApplicationConfig {

}
