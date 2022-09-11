package com.seven9nrh.sprbttrialreactive;

import com.seven9nrh.twitter.TwitterApiClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(TwitterApiClientConfiguration.class)
public class SprbtTrialReactiveApplication {

  public static void main(String[] args) {
    SpringApplication.run(SprbtTrialReactiveApplication.class, args);
  }
}
