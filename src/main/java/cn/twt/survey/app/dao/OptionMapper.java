package cn.twt.survey.app.dao;


import cn.twt.survey.app.entity.Option;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OptionMapper {
    public boolean addOption(List<Option> optionList);
}
