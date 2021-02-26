package cn.twt.survey.app.controller;

import cn.twt.survey.app.context.UserInfo;
import cn.twt.survey.app.entity.Paper;
import cn.twt.survey.app.service.PaperService;
import cn.twt.survey.app.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class PaperController {
    @Autowired
    PaperService paperService;
    @GetMapping("/api/paper/getMyPaper")
    public ApiResponse getMyPaper(){
        int userId = UserInfo.getUser().getId();
        List<Paper> papers = paperService.getPaperByOwner(userId);
        return ApiResponse.success(papers);
    }
    @PostMapping("/api/paper/addPaper")
    public ApiResponse addPaper(@RequestParam("title") String title,
                                @RequestParam("start") long start,
                                @RequestParam("end") long end){
        int userId = UserInfo.getUser().getId();
        Date now= new Date();
        Date startDate = new Date(start);
        Date endDate = new Date(end);

        if (paperService.addPaper(userId,title,now,1,startDate,endDate)){
            return ApiResponse.success("success");
        }else {
            return ApiResponse.fail(403,"fail");
        }
    }
    @PostMapping("/api/paper/changePaper")
    public ApiResponse changePaper(@RequestParam(value = "title",required = false) String title,
                                   @RequestParam(value = "start",required = false) Long start,
                                   @RequestParam(value = "end",required = false) Long end,
                                   @RequestParam(value = "status",required = false)Integer status,
                                   @RequestParam("id") int id){
        int userId = UserInfo.getUser().getId();
        Paper paper = paperService.getPaperById(id);
        if(paper.getOwner() == userId){
            if(title==null&&start==null&&end==null&&status==null) return ApiResponse.success("unchange");
            Date startDate;
            Date endDate;
            if(start == null){startDate = null;}else {startDate = new Date(start);};
            if(end == null){endDate = null;}else {endDate = new Date(end);};
            if(paperService.changePaper(title,startDate,endDate,status,id)){
                return ApiResponse.success("success");
            }else {
                return ApiResponse.fail(403,"change fail");
            }

        }else {
            return ApiResponse.fail(403,"illegal user");
        }
    }
    @PostMapping("/api/paper/deletePaper")
    public ApiResponse deletePaper(@RequestParam("id")int id){
        int userId = UserInfo.getUser().getId();
        if(paperService.getPaperById(id).getOwner()==id){
            if(paperService.changePaper(null,null,null,0,id)){
                return ApiResponse.success("Delete Success");
            }else {
                return ApiResponse.fail(403,"Delete fail");
            }
        }else {
            return ApiResponse.fail(403,"illegal user");
        }
    }
    @PostMapping("api/paper/getPaper")
    public ApiResponse getPaperById(int id){
        Paper paper = paperService.getPaperById(id);
        if(paper != null){
            return ApiResponse.success(paper);
        }else
            return ApiResponse.fail(403,"illegal id");
    }

}
