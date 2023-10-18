package com.hexkey.travelmaker.member.admin.controller;

import com.hexkey.travelmaker.member.admin.service.MemberService;
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
@RequestMapping("/admin")
public class MemberListController {

    private final MemberService memberService;

    public MemberListController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/adminMemberList")
    public String getadminMemberList(@RequestParam(defaultValue = "1") int page
            , @RequestParam(required = false) String searchValueId
            , @RequestParam(required = false)String memberGradeList
            , @RequestParam(required = false)String searchDate
            , Model model) {

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValueId", searchValueId);
        searchMap.put("memberGradeList", memberGradeList);
        searchMap.put("searchDate", searchDate);

        Map<String, Object> memberListAndPaging = memberService.findAllMemberList(page,searchMap);
        log.info("memberListAndPaging {}", memberListAndPaging);
        model.addAttribute("paging",memberListAndPaging.get("paging"));
        model.addAttribute("memberList",memberListAndPaging.get("memberList"));

        return "admin/adminMemberList";
    }


    @GetMapping("/adminMemberDetail")
    public String getadminMemberDetail() {

        return "admin/adminMemberDetail";
    }


}
