package com.mycom.trustclient;

import java.util.concurrent.TimeUnit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvalController {

  @GetMapping(path = "/eval")
  public ResponseEntity<String> eval(@RequestParam int requiredResponse, @RequestParam long seconds)
      throws InterruptedException {

    TimeUnit.SECONDS.sleep(seconds);

    return switch (requiredResponse) {
      case 400 -> new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
      case 409 -> new ResponseEntity<>("Conflict", HttpStatus.CONFLICT);
      case 500 -> new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
      default -> new ResponseEntity<>("OK", HttpStatus.OK);
    };
  }

}
