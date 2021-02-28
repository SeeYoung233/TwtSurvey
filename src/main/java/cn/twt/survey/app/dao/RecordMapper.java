package cn.twt.survey.app.dao;

import cn.twt.survey.app.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface RecordMapper {
    boolean addRecord(List<Record> recordList);
    List<Record> getRecordByPaper(int paperId);
}
