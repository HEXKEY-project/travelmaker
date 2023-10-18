package com.hexkey.travelmaker.community.notices.controller;

import com.hexkey.travelmaker.community.notices.dto.CategoryDTO;
import com.hexkey.travelmaker.community.notices.dto.NoticesDTO;
import com.hexkey.travelmaker.community.notices.service.AdminNoticesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/regist")
    public String noticesWrite(){

        return "admin/community/notices/write";
    }

    @PostMapping("/regist")
    public String registNotices(NoticesDTO notices)  {
        adminNoticesService.registNotices(notices);

        return "redirect:/admin/notices/list?page=1";
    }

    @GetMapping("/detail")
    public String noticesDetail(@RequestParam Long no, Model model){
        NoticesDTO notices = adminNoticesService.noticeDetail(no);
        model.addAttribute("notices", notices);
        log.info("notices get: {}", notices);
        return "admin/community/notices/detail";
    }


    @PostMapping("/detail")
    public String updateNotices(@RequestParam Long no, NoticesDTO notices, Model model) {
        notices.setCode(no);
        notices.setTitle(notices.getTitle());
        notices.setBody(notices.getBody());
        notices.setCategoryCode(notices.getCategoryCode());
        model.addAttribute("notices", notices);

        log.info("notices post : {}", notices);

        adminNoticesService.updateNotices(notices);
        return "admin/community/notices/detail";
    }

    @PostMapping("/delete")
    public ResponseEntity<Integer> deleteNotices(@RequestBody List<Integer> code) {
        adminNoticesService.deleteNotices(code);
        return ResponseEntity.ok(1);
    }


}
