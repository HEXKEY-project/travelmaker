package com.hexkey.travelmaker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class CommunityController {

    @GetMapping("/faq/list")
    public String faqList(){ return "community/faqList"; }

    @GetMapping("/qna/list")
    public String qnaList(){return "community/qnaList";}
}
