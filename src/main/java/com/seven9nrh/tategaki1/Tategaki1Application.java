package com.seven9nrh.tategaki1;

import com.seven9nrh.twitter.TwitterApiClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// @Import(TwitterApiClientConfiguration.class)
public class Tategaki1Application {

  public static void main(String[] args) {
    SpringApplication.run(Tategaki1Application.class, args);
  }
}
