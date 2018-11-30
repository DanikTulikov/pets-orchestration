package com.tulikov.homeautomation.petsorchestartion.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

  @GetMapping("/ping")
  public String ping() {
    return "{\"status\": 200}";
  }
}
