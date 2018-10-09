package com.step.springcloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @Autowired
    FeginHi feignHi;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }

    @GetMapping(value = "/feignHi")
    public String feginHi(@RequestParam String name) {
        return "I am feignHi : "+feignHi.sayHiFromClientOne(name);
    }
}
