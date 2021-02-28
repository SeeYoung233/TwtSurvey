package cn.twt.survey.app.service;

import cn.twt.survey.app.entity.Record;

import java.util.List;

public interface RecordService {
    boolean addRecord(List<Record> recordList);
    List<Record> getRecordByPaper(int paperId);
}
