package com.mycom.resourceservice.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthServerFallbackFactory implements FallbackFactory<FallbackWithFactory> {

  @Override
  public FallbackWithFactory create(Throwable cause) {
    return new FallbackWithFactory(cause);
  }
}
