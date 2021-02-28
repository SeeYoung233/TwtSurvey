package cn.twt.survey.app.service.impl;

import cn.twt.survey.app.dao.OptionMapper;
import cn.twt.survey.app.entity.Option;
import cn.twt.survey.app.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    OptionMapper optionMapper;
    @Override
    public boolean addOption(List<Option> optionList) {
        return optionMapper.addOption(optionList);
    }
}
