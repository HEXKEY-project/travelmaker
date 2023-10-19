package com.hexkey.travelmaker.community.qna.controller;

import com.hexkey.travelmaker.community.notices.dto.NoticesDTO;
import com.hexkey.travelmaker.community.notices.service.NoticesService;
import com.hexkey.travelmaker.community.qna.dto.QnADTO;
import com.hexkey.travelmaker.community.qna.service.QNAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/community/QnA")
public class QnAController {

    private final QNAService qnaService;

    @Autowired
    public QnAController(QNAService qnaService) {
        this.qnaService = qnaService;
    }

    @GetMapping("/list")
    public String getQnAList(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(required = false) String searchCondition,
                             @RequestParam(required = false) String searchValue,
                             Model model){
            Map<String, String> searchMap = new HashMap<>();
            searchMap.put("searchCondition", searchCondition);
            searchMap.put("searchValue", searchValue);

            Map<String, Object> qnaListAndPaging = qnaService.selectQnA(searchMap, page);
            model.addAttribute("paging", qnaListAndPaging.get("paging"));
            model.addAttribute("qnaList", qnaListAndPaging.get("qnaList"));

        return "user/zeesang/community/qna/qnaList";
    }

    @GetMapping("/datail")
    public String getQnADetail(@RequestParam Long no, Model model){

        QnADTO qnADetail = qnaService.selectQnADetail(no);
        model.addAttribute("qnaDetail", qnADetail);

        return "user/zeesang/community/qna/qnaList";
    }
}
