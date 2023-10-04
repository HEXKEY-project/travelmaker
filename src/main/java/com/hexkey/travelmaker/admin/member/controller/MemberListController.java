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


    @GetMapping("/adminMemberList")
    public String getadminMemberList() {


        return "admin/adminMemberList";
    }


    @GetMapping("/adminMemberDetail")
    public String getadminMemberDetail() {

        return "admin/adminMemberDetail";
    }


}
