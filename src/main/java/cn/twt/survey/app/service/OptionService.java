package cn.twt.survey.app.service;

import cn.twt.survey.app.entity.Option;
import cn.twt.survey.app.entity.Question;

import java.util.List;

public interface OptionService {
    public boolean addOption(List<Option> optionList);
    public boolean changeOption(List<Option> optionList);
}