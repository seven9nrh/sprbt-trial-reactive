package com.seven9nrh.sprbttrialreactive;

import com.seven9nrh.twitter.TwitterApiClientConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TwitterApiClientConfiguration.class)
class SprbtTrialReactiveApplicationTest {

  @BeforeAll
  static void beforeAll() {
    System.setProperty("com.seven9nrh.twitter.bearerToken", "HOGE");
  }

  @Test
  void contextLoads() {}
}
