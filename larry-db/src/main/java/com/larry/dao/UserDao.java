package com.larry.dao;

import com.larry.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Larry on 2017/6/9.
 */
@Transactional
public interface UserDao  extends CrudRepository<UserInfo,String> {

    UserInfo findUserByuserName(String userName);
}
