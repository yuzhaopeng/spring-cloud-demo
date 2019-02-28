package com.example.demo.feign;

import com.example.demo.hystrix.ProviderHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="micro-provider",fallback = ProviderHystrixImpl.class)
public interface ProviderFeign {

    @RequestMapping(value = "/provider/hello")
    String hello();
}
