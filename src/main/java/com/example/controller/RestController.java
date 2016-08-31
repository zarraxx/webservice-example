package com.example.controller;

import com.example.dao.SampleDao;
import com.example.dto.PutToJobReq;
import com.example.entity.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/putToDb",method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Sample putToDb(@RequestBody PutToJobReq req){
        Sample sample = new Sample();
        sample.setId(req.getKey());
        sample.setValue(req.getValue());
        return sampleDao.saveAndFlush(sample);
    }
}
