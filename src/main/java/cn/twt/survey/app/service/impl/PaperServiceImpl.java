package cn.twt.survey.app.service.impl;

import cn.twt.survey.app.dao.PaperMapper;
import cn.twt.survey.app.entity.Paper;
import cn.twt.survey.app.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperMapper paperMapper;

    @Override
    public List<Paper> getPaperByOwner(int ownerId) {
        return paperMapper.getPaperByOwner(ownerId);
    }

    @Override
    public boolean addPaper(int owner, String title,Date create,int status, Date start,Date end) {
        return paperMapper.addPaper(owner,title,create,status,start,end);
    }

    @Override
    public Paper getPaperById(int id) {
        return paperMapper.getPaperById(id);
    }

    @Override
    public boolean changePaper(String title, Date start, Date end, Integer status, int id) {
        return paperMapper.changePaper(title,start,end,status,id);
    }
}
