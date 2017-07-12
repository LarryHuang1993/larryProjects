package com.larry.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huang on 2017/7/11.
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @RequestMapping("/demo")
    public String demo(){
        return "Hello";
    }
}
