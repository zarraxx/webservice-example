package com.example.service;

import javax.jws.WebService;

/**
 * Created by zarra on 16/9/22.
 */
@WebService(targetNamespace = "http://ws.xyan.net.cn/demo/helloInterface")
public interface Hello {
    String hello(String who);
}
