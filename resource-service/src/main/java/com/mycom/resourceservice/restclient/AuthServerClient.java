package com.mycom.resourceservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "authServer",
    url = "http://localhost:8081", fallbackFactory = AuthServerFallbackFactory.class,
    configuration = AuthServerConfig.class)
public interface AuthServerClient {

  @RequestMapping(method = RequestMethod.GET, value = "/eval?requiredResponse={responseCode}&seconds={seconds}")
  String getDetails(@PathVariable int responseCode, @PathVariable long seconds);
}
