package com.mycom.resourceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

  @GetMapping("/")
  public String greeting(){
    return "Hello world!";
  }

}
