package com.seven9nrh.sprbttrialreactive.application.controller;

import com.seven9nrh.sprbttrialreactive.repository.TweetDataRepository;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ServerWebExchange;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
@RequestMapping("/tweets")
public class TweetsController {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  TweetDataRepository tweetDataRepository;

  @RequestMapping
  public String init() {
    return "SearchAnyTweet";
  }

  @RequestMapping("/search_recent")
  public String tweetsSerchRecent(
    Model model,
    @RequestParam(name = "query", required = true) String query,
    ServerWebExchange exchange
  )
    throws UnsupportedEncodingException {
    IReactiveDataDriverContextVariable reactiveDataDriverContextVariable = new ReactiveDataDriverContextVariable(
      tweetDataRepository
        .tweetsSerchRecent(query)
        .doOnNext(tweetData -> logger.info(tweetData.toString())),
      1
    );

    HttpCookie oldCookie = exchange.getRequest().getCookies().getFirst("query");
    // try {
    if (oldCookie != null) {
      exchange
        .getResponse()
        .addCookie(
          ResponseCookie
            .from("oldQuery", URLEncoder.encode(oldCookie.getValue(), "UTF-8"))
            .build()
        );
    }
    exchange
      .getResponse()
      .addCookie(
        ResponseCookie.from("query", URLEncoder.encode(query, "UTF-8")).build()
      );
    model.addAttribute(
      "oldQuery",
      URLDecoder.decode(oldCookie.getValue(), "UTF-8")
    );

    model.addAttribute("query", query);
    model.addAttribute("tweetDataList", reactiveDataDriverContextVariable);
    return "SearchAnyTweet";
  }
}
