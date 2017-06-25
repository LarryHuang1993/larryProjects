package com.larry.dao;

import com.larry.model.StudentInfo;

import java.util.List;

/**
 * Created by huang on 2017/5/5.
 */
//@Repository
//@Component
public interface StudentInfoDao{

//    StudentInfo query();

    StudentInfo findByName(String name);

    List<StudentInfo> selectStudent();
}
