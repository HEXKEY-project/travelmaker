package com.hexkey.travelmaker.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class MemberController {


    @GetMapping("/login")
    public void loginPage() {}

    @GetMapping("/regist")
    public void reigstPage() {}

}
