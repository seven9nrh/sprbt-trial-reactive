package com.seven9nrh.tategaki1.repository;

import com.seven9nrh.twitter.model.TweetData;
import reactor.core.publisher.Flux;

public interface TweetDataRepository {
  Flux<TweetData> tweetsSerchRecent(String query);
}
