package cn.twt.survey.app.controller;

import cn.twt.survey.app.SurveyApplication;
import cn.twt.survey.app.context.UserInfo;
import cn.twt.survey.app.entity.User;
import cn.twt.survey.app.service.UserService;
import cn.twt.survey.app.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/api/user/login")
    public ApiResponse login(@RequestParam("phone") long phone,
                             @RequestParam("pwd") String pwd){
        if(phone == 0L || pwd.equals(""))return ApiResponse.fail(403,"Notnullable password or phone");
        User user =  userService.getUserByPhone(phone);
        if(user == null){
            return ApiResponse.fail(403,"Error password or phone");
        }else if(user.pwd.equals(pwd)){
            HashMap<String ,Object> map = new HashMap<String,Object>();
            map.put("id",user.id);
            map.put("name",user.name);
            map.put("phone",phone);
            return ApiResponse.success(map);
        }else {
            return ApiResponse.fail(403,"Error password or phone");
        }
    }
    @PostMapping("/api/user/register")
    public ApiResponse register(@RequestParam("phone") long phone,
                                @RequestParam("pwd") String pwd,
                                @RequestParam("name") String name){
        if(phone == 0L || pwd.equals("")|| name.equals(""))return ApiResponse.fail(403,"Notnullable param");
        if(userService.getUserByPhone(phone) != null)return ApiResponse.fail(403,"Phone has registered");
        Boolean regSucc = userService.register(phone,pwd,name);
        if(regSucc){
            return ApiResponse.success("null");
        }
        return ApiResponse.fail(403,"Register fail");

    }
    @GetMapping("/api/user/detail")
    public ApiResponse detail(){
        return ApiResponse.success(UserInfo.getUser());
    }
}
