package cn.twt.survey.app.dao;

import cn.twt.survey.app.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {
    public List<Question> getQuestionByPaper(int paper);
    public boolean addQuestion(List<Question> questionList);
    public boolean changeQuestion(List<Question> questionList);
}
