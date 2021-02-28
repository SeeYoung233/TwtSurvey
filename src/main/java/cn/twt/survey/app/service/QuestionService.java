package cn.twt.survey.app.service;

import cn.twt.survey.app.entity.Question;

import java.util.List;

public interface QuestionService {
    public List<Question> getQuestionByPaper(int paper);
    public boolean addQuestion(List<Question> questionList);
}
