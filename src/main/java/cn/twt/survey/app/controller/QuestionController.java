package cn.twt.survey.app.controller;

import cn.twt.survey.app.context.UserInfo;
import cn.twt.survey.app.entity.Option;
import cn.twt.survey.app.entity.Question;
import cn.twt.survey.app.entity.User;
import cn.twt.survey.app.service.OptionService;
import cn.twt.survey.app.service.PaperService;
import cn.twt.survey.app.service.QuestionService;
import cn.twt.survey.app.util.ApiResponse;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    PaperService paperService;
    @Autowired
    OptionService optionService;
    @PostMapping("/api/question/getQuestionByPaper")
    public ApiResponse getQuestionByPaper(@RequestParam("paperId") int paper){
        List<Question> questionList = questionService.getQuestionByPaper(paper);
        if(questionList != null){
            return ApiResponse.success(questionList);
        }else {
            return ApiResponse.fail(404,null);
        }
    }
    @PostMapping(value = "api/question/addQuestion",produces = "application/json;charset=UTF-8")
    public ApiResponse addQuestion(@RequestBody List<Question> questionList){
        int paperId = 0;
        User currentUser = UserInfo.getUser();
        for (Question question: questionList) {
            if(paperId == 0){
                paperId = question.getPaper();
                if(paperService.getPaperById(paperId).getOwner()!=currentUser.getId()){
                    return ApiResponse.fail(403,"illegal paperId");
                }
            }else {
                if(paperId != question.getPaper()){
                    return ApiResponse.fail(403,"illegal paperId");
                }
            }
        }
        if(questionService.addQuestion(questionList)){
            for (Question q:questionList) {
                List<Option> optionList = q.getOption();
                for (Option option:optionList) {
                    option.setQuestion(q.getId());
                }
                optionService.addOption(optionList);
            }

            return ApiResponse.success(questionList);
        }else {
            return ApiResponse.fail(404,"add fail");
        }

    }
    @PostMapping(value = "/api/question/changeQuestion",produces = "application/json;charset=UTF-8")
    public ApiResponse changeQuestion(@RequestBody List<Question> questionList){
        int paperId = 0;
        List<Option> optionList = new ArrayList<Option>();
        for (Question q:questionList) {
            if(paperId == 0){
                paperId = q.getPaper();
                if(paperService.getPaperById(paperId).getOwner()!=UserInfo.getUser().getId()){
                    return ApiResponse.fail(403,"illegal paperId");
                }
                optionList.addAll(q.getOption());
            }else {
                if(paperId != q.getPaper()){
                    return ApiResponse.fail(403,"illegal paperId");
                }
                optionList.addAll(q.getOption());
            }
        }
        if(questionService.changeQuestion(questionList)&&optionService.changeOption(optionList)){
            return ApiResponse.success("succ");
        }else {
            return ApiResponse.fail(403,"fail");
        }
    }
}
