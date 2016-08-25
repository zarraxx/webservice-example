package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 * Created by zarra on 16/6/15.
 */
@Controller
@RequestMapping("/")
public class RestController {


    @PostConstruct
    public  void setup(){
        System.out.println();
    }



    @RequestMapping("/add")
    public @ResponseBody
    Integer add (@RequestParam("a")Integer a,@RequestParam("b")Integer b){
        return a+b;
    }
}
