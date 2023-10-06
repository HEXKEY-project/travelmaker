package com.hexkey.travelmaker.member.admin.controller;


import com.hexkey.travelmaker.member.admin.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/admin")
public class MemberListController {

    private final MemberService memberService;

    public MemberListController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/adminMemberList")
    public String getadminMemberList() {


        return "admin/adminMemberList";
    }


    @GetMapping("/adminMemberDetail")
    public String getadminMemberDetail() {

        return "admin/adminMemberDetail";
    }


}
