package cn.twt.survey.app.controller;

import cn.twt.survey.app.entity.Question;
import cn.twt.survey.app.service.QuestionService;
import cn.twt.survey.app.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/api/question/getQuestionByPaper")
    public ApiResponse getQuestionByPaper(@RequestParam("paperId") int paper){
        List<Question> questionList = questionService.getQuestionByPaper(paper);
        if(questionList != null){
            return ApiResponse.success(questionList);
        }else {
            return ApiResponse.fail(404,null);
        }
    }
}
