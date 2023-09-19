package com.mycom.resourceservice.controller;

import com.mycom.resourceservice.restclient.AuthServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @Autowired
    AuthServerClient authServerClient;

    @GetMapping("/greeting")
    public String greeting(@RequestParam int requiredResponse, @RequestParam long seconds) {
        return authServerClient.getDetails(requiredResponse, seconds);
    }

}
