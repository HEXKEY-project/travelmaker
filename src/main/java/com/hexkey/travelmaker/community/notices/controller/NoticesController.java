package com.hexkey.travelmaker.community.notices.controller;

import com.hexkey.travelmaker.community.notices.dto.NoticesDTO;
import com.hexkey.travelmaker.community.notices.service.NoticesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Controller
@RequestMapping("/community/notices")
public class NoticesController {
    private final NoticesService noticesService;


    public NoticesController(NoticesService noticesService){
        this.noticesService=noticesService;}

    @GetMapping("/list")
    public String getNoticeList(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(required = false) String searchCondition,
                                @RequestParam(required = false) String searchValue,
                                Model model) {
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> noticesListAndPaging = noticesService.selectNotices(searchMap, page);
        model.addAttribute("paging", noticesListAndPaging.get("paging"));
        model.addAttribute("noticesList",noticesListAndPaging.get("noticesList"));

        return "user/zeesang/community/notices/noticesList";


    }
    @GetMapping("/datail")
    public String getBoardDetail(@RequestParam Long no, Model model){
        NoticesDTO noticesDetail = noticesService.selectNoticesdDetail(no);
        model.addAttribute("noticesD", noticesDetail);

        return "user/zeesang/community/notices/noticesDetail";
    }

}
