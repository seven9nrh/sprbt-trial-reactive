package com.seven9nrh.sprbttrialreactive.repository;

import com.seven9nrh.twitter.model.TweetData;
import reactor.core.publisher.Flux;

public interface TweetDataRepository {
  Flux<TweetData> tweetsSerchRecent(String query);
}
