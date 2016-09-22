package com.example.service;

import javax.jws.WebService;

/**
 * Created by zarra on 16/9/22.
 */
@WebService(endpointInterface = "com.example.service.Hello",
        targetNamespace = "http://ws.xyan.net.cn/demo/helloService")
public class HelloService implements Hello {


    @Override
    public String hello(String who) {
        return "hello "+who;
    }
}
