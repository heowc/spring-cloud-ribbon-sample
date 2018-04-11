package com.heowc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudRibbonServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonServer1Application.class, args);
    }


    @GetMapping("/")
    public String index() {
        return "::: server 1 :::";
    }
}
