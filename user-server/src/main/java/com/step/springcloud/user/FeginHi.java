package com.step.springcloud.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign 自动负载
 * **/
@FeignClient(serviceId = "ADMIN-SERVER",fallback = HytrixSchedual.class)
public interface FeginHi {

    @RequestMapping(value = "/hi",method = RequestMethod.POST)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
