package com.example.service;

import javax.jws.WebService;

/**
 * Created by zarra on 16/6/15.
 */
@WebService(targetNamespace = "http://ws.xyan.net.cn/demo/addInterface")
public interface Add {
     int add(int a,int b);
}
