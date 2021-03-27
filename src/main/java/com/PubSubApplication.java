package com;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${base-url.context}")
@SpringBootApplication
public class PubSubApplication {

  private static final Log LOGGER = LogFactory.getLog(PubSubApplication.class);

  public static void main(String[] args) throws IOException {
	SpringApplication.run(PubSubApplication.class, args);
  }

  @GetMapping("")
  String hello() {
        return "Hello! Pub Sub Controller is running";
    }
}






