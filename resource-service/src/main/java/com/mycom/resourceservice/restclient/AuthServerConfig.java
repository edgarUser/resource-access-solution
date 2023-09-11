package com.mycom.resourceservice.restclient;

import feign.Retryer;
import org.springframework.context.annotation.Bean;

public class AuthServerConfig {

  @Bean
  Retryer retryer() {

    return new Retryer.Default(500, 500, 5);
  }

}
