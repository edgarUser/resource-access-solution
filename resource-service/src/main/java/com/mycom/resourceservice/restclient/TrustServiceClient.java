package com.mycom.resourceservice.restclient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "trustService",
        url = "http://localhost:8081", fallbackFactory = TrustServiceFallbackFactory.class,
        configuration = TrustServiceConfig.class)
public interface TrustServiceClient {

    @CircuitBreaker(name = "trustServiceCircuitBreaker")
    @RequestMapping(method = RequestMethod.GET, value = "/eval?requiredResponse={responseCode}&seconds={seconds}")
    String getDetails(@PathVariable int responseCode, @PathVariable long seconds);
}
