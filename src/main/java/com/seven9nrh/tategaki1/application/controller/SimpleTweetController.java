package com.seven9nrh.tategaki1.application.controller;

import com.seven9nrh.tategaki1.repository.TweetDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class SimpleTweetController {

  @Autowired
  TweetDataRepository tweetDataRepository;

  @RequestMapping
  public String init() {
    return "tategaki";
  }

  @RequestMapping("/tweetsSerchRecent")
  public String tweetsSerchRecent(
    Model model,
    @RequestParam(name = "query", required = true) String query
  ) {
    IReactiveDataDriverContextVariable reactiveDataDriverContextVariable = new ReactiveDataDriverContextVariable(
      tweetDataRepository.tweetsSerchRecent(query),
      1
    );

    model.addAttribute("tweetDataList", reactiveDataDriverContextVariable);
    return "tategaki";
  }
}
