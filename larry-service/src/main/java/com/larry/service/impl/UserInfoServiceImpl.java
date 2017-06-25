package com.larry.service.impl;

import com.larry.dao.UserDao;
import com.larry.model.Result;
import com.larry.model.UserInfo;
import com.larry.service.UserInfoService;
import com.larry.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by huang on 2017/6/11.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserDao dao;

    @Override
    public Result save(UserInfo user) {
        try {
            // TODO: 2017/6/11
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String password = bc.encode(user.getPassword());
            user.setPassword(password);
            user.setCreatedDate(new Date());
            user.setUpdatedDate(new Date());
            dao.save(user);
            return Result.info("su");
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),"操作失败",e);
            return Result.error("操作失败");
        }
    }
}
