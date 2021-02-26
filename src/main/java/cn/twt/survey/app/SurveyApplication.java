package cn.twt.survey.app;

import cn.twt.survey.app.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.twt.survey.app.dao")
public class SurveyApplication {
    public static User currentUser;
    public static ThreadLocal<User> user;
    public static void main(String[] args) {
        SpringApplication.run(SurveyApplication.class, args);
    }


}
