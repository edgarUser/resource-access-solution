package com.mycom.resourceservice.restclient;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;

public class FallbackWithFactory implements AuthServerClient{

  @Override
  public String getDetails() {
    throw new NoFallbackAvailableException("Boom!", new RuntimeException());
  }
}
