package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(){
        //服务提供者的访问地址
        //注意！ 此处使用服务名代替了ip:port
        String providerUrl = "http://micro-provider/provider/hello";
        String result = restTemplate.getForObject(providerUrl, String.class);
        return result;
    }
}
