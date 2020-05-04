package com.globomatics.bike.service;

import com.globomatics.bike.models.Bike;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;

@Service
public class HerokuNotIdle {

    @PostConstruct
    @Scheduled(cron = "* * * * * *")
    public void herokuNotIdle()
    {
        RestTemplate restTemplate = new RestTemplate();
        Bike forObject = restTemplate.getForObject("https://bikesurveryweb.herokuapp.com/admin", Bike.class);
        System.out.println(forObject);
    }

}
