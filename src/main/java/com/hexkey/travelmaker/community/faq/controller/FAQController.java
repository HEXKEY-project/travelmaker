package com.hexkey.travelmaker.community.faq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/community/FAQ")
public class FAQController {
    @GetMapping("/list")
    public String getFAQList(){
        return "user/zeesang/community/faq/faqList";
    }
}
