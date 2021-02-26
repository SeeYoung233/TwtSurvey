package cn.twt.survey.app.controller;

import cn.twt.survey.app.SurveyApplication;
import cn.twt.survey.app.context.UserInfo;
import cn.twt.survey.app.entity.User;
import cn.twt.survey.app.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    SurveyApplication surveyApplication;
    @GetMapping("/api/hello")
    public ApiResponse hello(){
        return ApiResponse.success(UserInfo.getUser());
    }
}
