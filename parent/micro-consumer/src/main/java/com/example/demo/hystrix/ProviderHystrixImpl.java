package com.example.demo.hystrix;

import com.example.demo.feign.ProviderFeign;
import org.springframework.stereotype.Component;

@Component
public class ProviderHystrixImpl implements ProviderFeign {

    @Override
    public String hello() {
        return " call failed , hystrix start";
    }
}
