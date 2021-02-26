package cn.twt.survey.app.service.impl;

import cn.twt.survey.app.dao.UserMapper;
import cn.twt.survey.app.entity.User;
import cn.twt.survey.app.service.UserService;
import cn.twt.survey.app.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(long phone, String pwd) {
        return userMapper.login(phone,pwd);
    }

    @Override
    public User getUserByPhone(long phone) {
        return userMapper.getUserByPhone(phone);
    }

    @Override
    public User getUserByToken(String token) {
        return userMapper.getUserByToken(token);
    }

    @Override
    public boolean register(long phone, String pwd, String name) {
        return userMapper.register(phone,pwd,name);
    }
}
