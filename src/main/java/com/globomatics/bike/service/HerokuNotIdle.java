package com.globomatics.bike.service;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

public class HerokuNotIdle {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(HerokuNotIdle.class);

    @Scheduled(fixedDelay =  120000)  //calls every 2 mins
    public void herokuNotIdle(){
        RestTemplate restTemplate = new RestTemplate();
        try{
            restTemplate.getForObject("https://bikesurveryweb.herokuapp.com/admin", Object.class);
        }
        catch(Exception e){
            LOG.warning("Heroku Not Idle Service goes wrong");
        }
    }

}
