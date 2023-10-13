package com.hexkey.travelmaker.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class CommunityController {

    @GetMapping("/faq/list")
    public String faqList(){ return "user/zeesang/community/faqList"; }

    @GetMapping("/qna/list")
    public String qnaList(){return "user/zeesang/community/qnaList";}
}
