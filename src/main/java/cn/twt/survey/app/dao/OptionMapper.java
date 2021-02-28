package cn.twt.survey.app.dao;


import cn.twt.survey.app.entity.Option;
import cn.twt.survey.app.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OptionMapper {
    public boolean addOption(List<Option> optionList);
    public boolean changeOption(List<Option> optionList);
}
