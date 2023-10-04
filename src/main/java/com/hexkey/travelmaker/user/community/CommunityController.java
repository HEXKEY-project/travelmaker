package com.hexkey.travelmaker.user.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class CommunityController {

    @GetMapping("/list")
    public String noticesList(){ return "community/notices/noticesList"; }

    @GetMapping("/faqList")
    public String faqList(){ return "community/faqList"; }

    @GetMapping("/qnaList")
    public String qnaList(){return "community/qnaList";}
}
