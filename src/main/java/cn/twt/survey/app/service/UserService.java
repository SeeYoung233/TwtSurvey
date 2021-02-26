package cn.twt.survey.app.service;

import cn.twt.survey.app.entity.User;
import cn.twt.survey.app.util.ApiResponse;

import java.util.List;

public interface UserService {
    public User login(long phone, String pwd);
    public User getUserByPhone(long phone);
    public User getUserByToken(String token);
    public boolean register(long phone,String pwd ,String name);
}
