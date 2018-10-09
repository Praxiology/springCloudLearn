package com.step.springcloud.user;

import org.springframework.stereotype.Component;

@Component
public class HytrixSchedual implements FeginHi {
    @Override
    public String sayHiFromClientOne(String name) {

        return name + "sorry ! 请求备用接口";
    }
}
