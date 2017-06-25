package com.larry.service.impl;

import com.larry.dao.UserDao;
import com.larry.model.SecurityUser;
import com.larry.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Larry on 2017/6/9.
 */
public class LarryUserService implements UserDetailsService {

    @Autowired
    private UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo user = dao.findUserByuserName(s);

        if (user == null) {
            throw new UsernameNotFoundException("UserName " + s + " not found");
        }
        // SecurityUser实现UserDetails并将UserInfo的UserName映射为username
        SecurityUser securityUser = new SecurityUser(user);
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return securityUser;
    }
}
