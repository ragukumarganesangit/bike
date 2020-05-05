package com.globomatics.bike.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;

@Service
public class HerokuNotIdle {

    @PostConstruct
    @Scheduled(fixedDelay=120000)  //every 2 mins
    public void herokuNotIdle()
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("https://bikesurveryweb.herokuapp.com/admin", String.class);
    }

}
