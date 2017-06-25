package com.larry.service.impl;

import com.larry.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by huang on 2017/6/23.
 */

@Service
public class DemoServiceImpl implements DemoService{

    public void showDemo() {
        System.out.println("过来了");
    }
}
