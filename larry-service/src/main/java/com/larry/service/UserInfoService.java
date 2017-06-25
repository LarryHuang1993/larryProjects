package com.larry.service;

import com.larry.model.Result;
import com.larry.model.UserInfo;

/**
 * Created by huang on 2017/6/11.
 */
public interface UserInfoService {
    Result save(UserInfo user);
}
