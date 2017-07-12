package com.larry.web;

import com.larry.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;

/**
 * Created by huang on 2017/6/23.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/index")
    public String demo(){
        demoService.showDemo();
        System.out.println("");
        return "hello spring boot";
    }
}
