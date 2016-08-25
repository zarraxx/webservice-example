package com.example.service;

import javax.jws.WebService;

/**
 * Created by zarra on 16/6/15.
 */
@WebService(endpointInterface = "com.example.service.Add",
        targetNamespace = "http://ws.xyan.net.cn/demo/addService")
public class AddService implements Add{
    public int add(int a,int b){
        return a+b;
    }
}
