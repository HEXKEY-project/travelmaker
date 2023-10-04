package com.hexkey.travelmaker.admin.member.controller;


import com.hexkey.travelmaker.admin.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Slf4j
@Controller
@RequestMapping("/admin")
public class MemberListController {

    private final MemberService memberService;

    public MemberListController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/adminMemberList")
    public String getadminMemberList(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(required = false) String searchCondition,
                                     @RequestParam(required = false) String searchValue,
                                        Model model) {

        log.info("adminMemberList: {}", page);
        log.info("adminMemberList searchCondition : {}", searchCondition);
        log.info("adminMemberList searchValue : {}", searchValue);

        Map<String,String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

         Map<String, Objects> memberListAndPaging =  memberService.selectMemberList(searchMap,page);



        return "admin/adminMemberList";
    }


    @GetMapping("/adminMemberDetail")
    public String getadminMemberDetail() {

        return "admin/adminMemberDetail";
    }


}
