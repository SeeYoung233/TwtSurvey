package cn.twt.survey.app.entity;

import java.util.Date;


public class Paper {
    private int id;
    private int owner;
    private String title;
    private int status;
    private Date create;
    private Date start;
    private Date end;

    public int getId() {
        return id;
    }

    public int getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public Date getCreate() {
        return create;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
