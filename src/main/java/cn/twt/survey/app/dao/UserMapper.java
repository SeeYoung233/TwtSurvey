package cn.twt.survey.app.dao;

import cn.twt.survey.app.entity.User;
import cn.twt.survey.app.service.UserService;
import cn.twt.survey.app.util.ApiResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper

public interface UserMapper {
    public User login(long phone, String pwd);
    public User getUserByPhone(long phone);
    public User getUserByToken(String token);
    public boolean register(long phone, String pwd, String name);
}
