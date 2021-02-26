package cn.twt.survey.app.service;

import cn.twt.survey.app.entity.Paper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface PaperService {
    public List<Paper> getPaperByOwner(int ownerId);
    public boolean addPaper(int owner, String title,Date create,int status, Date start,Date end);
    public Paper getPaperById(int id);
    public boolean changePaper(String title,Date start,Date end,Integer status,int id);
}
