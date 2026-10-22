package com.example.hellodemo.service.impl;

import com.example.hellodemo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String getGreeting() {
        return "Hi, how are you?";
    }
}
