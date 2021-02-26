package cn.twt.survey.app.handler;

import cn.twt.survey.app.SurveyApplication;
import cn.twt.survey.app.context.UserInfo;
import cn.twt.survey.app.entity.User;
import cn.twt.survey.app.service.UserService;
import cn.twt.survey.app.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    @Autowired
    SurveyApplication surveyApplication;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token =  CookieUtil.getCookie(request,"token");
        if(token != null && !"".equals(token)){
            User user = userService.getUserByToken(token);
            if(user != null){
                UserInfo.setUser(user);
                return true;
            }
        }
        response.sendRedirect(request.getContextPath()+"/login.html");
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        try{
            UserInfo.removeUser();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
