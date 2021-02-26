package cn.twt.survey.app.context;

import cn.twt.survey.app.entity.User;
//储存当前用户信息，线程安全
public class UserInfo {
    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<User>();

    public static void setUser(User user){
        userThreadLocal.set(user);
    }
    public static User getUser(){
        return userThreadLocal.get();
    }
    public static void removeUser(){
        userThreadLocal.remove();
    }
}
