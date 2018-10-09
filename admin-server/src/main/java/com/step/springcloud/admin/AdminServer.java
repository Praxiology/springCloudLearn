package com.step.springcloud.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class AdminServer {

    public static void main(String[] args) {
        SpringApplication.run(AdminServer.class);
    }

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hi(HttpServletRequest request, @RequestParam String name){

        if ("hytrix".equals(name)) {
            try {
                Thread.currentThread().sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return foo+request.getRequestURI()+request.getServerPort()+name;
    }
}
