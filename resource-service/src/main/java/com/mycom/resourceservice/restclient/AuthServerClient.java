package com.mycom.resourceservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authServer",
    url = "http://localhost:8081", fallbackFactory = AuthServerFallbackFactory.class,
    configuration = AuthServerConfig.class)
public interface AuthServerClient {

  @GetMapping(value = "/eval?requiredResponse={responseCode}&seconds={seconds}")
  String getDetails(@PathVariable int responseCode, @PathVariable long seconds);
}
