package com.example.demo.feign;

import com.example.demo.hystrix.ProviderHystrix;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "micro-provider", fallback = ProviderHystrix.class)
public interface ProviderFeign {

    @RequestMapping(value = "/provider/hello")
    String hello();
}
