package com.hexkey.travelmaker.member.user.controller;

import com.hexkey.travelmaker.member.user.dto.MemberMDTO;
import com.hexkey.travelmaker.member.user.service.MemberMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/user")
public class MemberMController {

    private MemberMService memberMService;

    public MemberMController(MemberMService memberMService) {
        this.memberMService = memberMService;
    }

    @GetMapping("/user/login")
    public void loginPage() {}

    @GetMapping("/user/regist")
    public void registPage() {}

    @PostMapping("idCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberMDTO member) {

        log.info("Request Check ID : {}", member.getMemberId());

        String result = "사용 가능한 아이디입니다.";

        if (memberMService.selectMemberById(member.getMemberId())) {
            result = "이미 사용 중인 아이디입니다.";
        }

        return ResponseEntity.ok(result);

    }

}