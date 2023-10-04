package com.hexkey.travelmaker.notices.controller;

import com.hexkey.travelmaker.notices.service.NoticesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/notices")
public class NoticesController {
    private final NoticesService noticesService;
    public NoticesController(NoticesService noticesService){
        this.noticesService=noticesService;}

    @GetMapping("/list")
    public String getNoticesList(@RequestParam(defaultValue = "1")int page,
                                 @RequestParam(required = false) String searchCondition,
                                 @RequestParam(required = false) String searchValue,
                                 Model model){
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> noticesLisetAndPaging = noticesService.selectNoticesLiset(searchMap, page);
        model.addAttribute("paging", noticesLisetAndPaging.get("paging"));
        model.addAttribute("noticesList", noticesLisetAndPaging.get("noticesList"));

        return "notices/noticesList";
    }

}
