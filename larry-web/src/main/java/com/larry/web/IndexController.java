package com.larry.web;

import com.larry.model.Result;
import com.larry.model.StudentInfo;
import com.larry.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2017/5/5.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private StudentService service;


    @RequestMapping("/index")
    public ModelAndView index(){
        System.out.println("hello");
        return new ModelAndView("index");
    }

    @RequestMapping("/queryAll")
    public Map<String,Object> query(){
        Iterable<StudentInfo> dto = service.query();
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> page = new HashMap<>();
        result.put("data",dto);
        result.put("recordsTotal",200);
        page.put("start",1);
        page.put("end",10);
        page.put("total",101);
        result.put("info",page);
        return result;
    }

    @RequestMapping("/add")
    public Result add(){
        StudentInfo stu = new StudentInfo();
        stu.setName("larry");
        stu.setAddress("深圳");
        stu.setAge(22);
        stu.setCreatedDate(new Date());
//        stu.setId(UuidUtil.getUuid());
        service.add(stu);
        return Result.info("成功");
    }

    @RequestMapping("/find")
    public StudentInfo find(String name){
        return service.findByName(name);
    }

    @RequestMapping("/queryall")
    @ResponseBody
    public List test(){
        return service.query();
    }
}
