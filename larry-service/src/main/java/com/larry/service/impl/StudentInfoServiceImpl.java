package com.larry.service.impl;

import com.larry.dao.StudentInfoDao;
import com.larry.model.StudentInfo;
import com.larry.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


/**
 * Created by huang on 2017/5/5.
 */
@Service
public class StudentInfoServiceImpl implements StudentService {

    @Autowired
    private StudentInfoDao dao;

    @Override
    public List<StudentInfo> query() {
        List<StudentInfo> list =  dao.selectStudent();
        return list;
    }

    @Override
    public StudentInfo findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Integer add(StudentInfo stu) {
        try {
            UUID.randomUUID();
            //dao.save(stu);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
