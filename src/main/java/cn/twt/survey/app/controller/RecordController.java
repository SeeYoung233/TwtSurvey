package cn.twt.survey.app.controller;

import cn.twt.survey.app.context.UserInfo;
import cn.twt.survey.app.entity.Record;
import cn.twt.survey.app.service.PaperService;
import cn.twt.survey.app.service.RecordService;
import cn.twt.survey.app.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordController {
    @Autowired
    RecordService recordService;
    @Autowired
    PaperService paperService;
    @PostMapping("/api/record/addRecord")
    public ApiResponse addRecord(@RequestBody List<Record> recordList){
        if(recordService.addRecord(recordList)){
            return ApiResponse.success("succ");
        }else {
            return ApiResponse.fail(403,"fail");
        }
    }
    @PostMapping("/api/record/getRecordByPaper")
    public ApiResponse getRecordByPaper(@RequestParam("paperId") int paperId){
        if(paperService.getPaperById(paperId).getOwner() == UserInfo.getUser().getId()){
            return ApiResponse.success(recordService.getRecordByPaper(paperId));
        }else {
            return ApiResponse.fail(403,"illegal user");
        }
    }

}
