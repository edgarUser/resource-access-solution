package com.mycom.resourceservice.controller;

import com.mycom.resourceservice.model.Resource;
import com.mycom.resourceservice.restclient.TrustServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ResourceController {
    @Autowired
    TrustServiceClient trustServiceClient;

    @GetMapping("/resource")
    public Resource greeting(@RequestParam int requiredResponse, @RequestParam long seconds) {
        return Resource.builder().id(UUID.randomUUID().toString())
                .status(trustServiceClient.getDetails(requiredResponse, seconds)).build();

    }

}
