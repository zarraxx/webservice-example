package com.example.controller;

import com.example.dao.SampleDao;
import com.example.entity.Sample;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    SampleDao sampleDao;

    @PostConstruct
    public  void setup(){
        System.out.println();
    }



    @RequestMapping("/add")
    public @ResponseBody
    Integer add (@RequestParam("a")Integer a,@RequestParam("b")Integer b){
        return a+b;
    }


    @RequestMapping("/putToDb")
    public @ResponseBody
    Sample putToDb (@RequestParam("k")String key, @RequestParam("v")String  v){
        Sample sample = new Sample();
        sample.setId(key);
        sample.setValue(v);
        return sampleDao.saveAndFlush(sample);
    }
}
