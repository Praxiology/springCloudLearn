package com.step.springcloud.user;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String hiService(String name) {
        return restTemplate.getForObject("http://ADMIN-SERVER/hi?name="+name,String.class);
    }

    public String error(String name){
        return "HystrixCommand to ADMIN-SERVER / hi is error";
    }


}