package com.mycom.resourceservice.restclient;

import feign.FeignException;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;

public class FallbackWithFactory implements AuthServerClient{

  private final Throwable cause;

  public FallbackWithFactory(Throwable cause){
    this.cause = cause;
  }

  @Override
  public String getDetails(int responseCode, long seconds) {
    if(cause instanceof FeignException.BadRequest){
      return "Bad request";
    }else if( cause instanceof  FeignException.Conflict){
      return "Conflict";
    }
    throw new NoFallbackAvailableException("Boom!", new RuntimeException());
  }
}
