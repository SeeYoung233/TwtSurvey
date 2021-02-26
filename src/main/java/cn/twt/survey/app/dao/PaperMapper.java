package cn.twt.survey.app.dao;

import cn.twt.survey.app.entity.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper

public interface PaperMapper {
    public List<Paper> getPaperByOwner(int ownerId);
    public boolean addPaper(int owner, String title,Date create,int status, Date start,Date end);
    public Paper getPaperById(int id);
    public boolean changePaper(@Param("title") String title, Date start, Date end, Integer status, int id);
    }
