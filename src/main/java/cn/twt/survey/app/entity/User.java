package cn.twt.survey.app.entity;

import org.springframework.context.annotation.Bean;

public class User {
    public int id;
    public String name;
    public String pwd;
    public long phone;
    public String token;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public String gettoken() {
        return token;
    }

    public String getPwd() {
        return null;
    }


}
