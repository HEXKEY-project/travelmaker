package com.hexkey.travelmaker.community.notices.controller;

import com.hexkey.travelmaker.community.notices.service.AdminNoticesService;
import com.hexkey.travelmaker.community.notices.service.NoticesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("admin/notices")
public class AdminNoticesController {

    private final AdminNoticesService adminNoticesService;
    public AdminNoticesController(AdminNoticesService adminNoticesService){
        this.adminNoticesService=adminNoticesService;}

    @GetMapping("/list")
    public String noticesList(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(required = false) String searchCondition,
                          @RequestParam(required = false) String searchValue,
                          Model model){

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> noticesListAndPaging = adminNoticesService.selectAdminNotices(searchMap, page);
        model.addAttribute("paging", noticesListAndPaging.get("paging"));
        model.addAttribute("noticesList",noticesListAndPaging.get("noticesList"));


        return "admin/community/notices/list"; }

    @GetMapping("/write")
    public String noticesWrite(){
        return "admin/community/notices/write";
    }
}
