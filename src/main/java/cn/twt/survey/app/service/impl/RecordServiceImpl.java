package cn.twt.survey.app.service.impl;

import cn.twt.survey.app.dao.RecordMapper;
import cn.twt.survey.app.entity.Record;
import cn.twt.survey.app.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;
    @Override
    public boolean addRecord(List<Record> recordList) {
        return recordMapper.addRecord(recordList);
    }

    @Override
    public List<Record> getRecordByPaper(int paperId) {
        return recordMapper.getRecordByPaper(paperId);
    }
}
