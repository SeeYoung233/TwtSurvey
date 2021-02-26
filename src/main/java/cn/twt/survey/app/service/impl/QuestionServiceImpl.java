package cn.twt.survey.app.service.impl;

import cn.twt.survey.app.entity.Question;
import cn.twt.survey.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionService questionService;

    @Override
    public List<Question> getQuestionByPaper(int paper) {
        return questionService.getQuestionByPaper(paper);
    }
}
