package cn.twt.survey.app.service.impl;

import cn.twt.survey.app.dao.QuestionMapper;
import cn.twt.survey.app.entity.Question;
import cn.twt.survey.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public List<Question> getQuestionByPaper(int paper) {
        return questionMapper.getQuestionByPaper(paper);
    }

    @Override
    public boolean addQuestion(List<Question> questionList) {
        return questionMapper.addQuestion(questionList);
    }
}
