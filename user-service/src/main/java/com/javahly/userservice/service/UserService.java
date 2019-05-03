package com.javahly.userservice.service;

import com.javahly.userservice.dao.UserDao;
import com.javahly.userservice.dto.LoginDTO;
import com.javahly.userservice.dto.RespDTO;
import com.javahly.userservice.entity.User;
import com.javahly.userservice.exception.CommonException;
import com.javahly.userservice.exception.ErrorCode;
import com.javahly.userservice.util.BPwdEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/28
 */

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.err.println(userDao.findUserByUsername(username));
        return userDao.findUserByUsername(username);
    }

    public RespDTO login(String username , String password){
        User user= userDao.findUserByUsername(username);
        if(null==user){
            throw new CommonException(ErrorCode.USER_NOT_FOUND);
        }
        if(!BPwdEncoderUtils.matches(password,user.getPassword())){
            throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
        }

        
        JWT jwt = authServiceClient.getToken("Basic dWFhLXNlcnZpY2U6MTIzNDU2", "password", username, password);
        // 获得用户菜单
        if(null==jwt){
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUser(user);
        loginDTO.setToken(jwt.getAccess_token());
        return RespDTO.onSuc(loginDTO);
    }
}
