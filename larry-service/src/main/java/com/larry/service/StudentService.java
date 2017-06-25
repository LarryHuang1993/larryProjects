package com.larry.service;

import com.larry.model.StudentInfo;

import java.util.List;

/**
 * Created by huang on 2017/5/5.
 */
public interface StudentService {

    List<StudentInfo> query();

    StudentInfo findByName(String name);

    Integer add(StudentInfo stu);
}
