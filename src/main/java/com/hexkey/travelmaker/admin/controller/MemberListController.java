package com.hexkey.travelmaker.admin.controller;

import com.hexkey.travelmaker.admin.dto.MemberDTO;
import com.hexkey.travelmaker.admin.dto.MileageDTO;
import com.hexkey.travelmaker.admin.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/admin")
public class MemberListController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    public MemberListController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }
    /* 회원목록 */
    @GetMapping("/adminMemberList")
    public String getadminMemberList(@RequestParam(defaultValue = "1") int page
            , @RequestParam(required = false) String searchValueId
            , @RequestParam(required = false)String memberGradeList
            , @RequestParam(required = false)String searchDate
            , Model model) {

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchValueId", searchValueId);
        searchMap.put("memberGradeList", memberGradeList);
        searchMap.put("searchDate", searchDate);


        Map<String, Object> memberListAndPaging = memberService.findAllMemberList(page,searchMap);
        //log.info("memberListAndPaging {}", memberListAndPaging);
        model.addAttribute("paging",memberListAndPaging.get("paging"));
        model.addAttribute("memberList",memberListAndPaging.get("memberList"));

        return "admin/adminMemberList";
    }

    /* 회원 삭제*/
    @PostMapping("/deleteMember")
    @ResponseBody
    public Map<String, Object> deleteMember(@RequestParam(value = "rowCheck[]") List<String> chArr){
     //   log.info("chArr : {}", chArr);
        Map<String, Object> result = new HashMap<>();

        if (chArr != null) {
            for (String i : chArr) {
                int memberNum = Integer.parseInt(i);
                memberService.deleteMember(memberNum);
            }
            result.put("result", "success");
        }

        return result;
    }
    /* 회원등급 해제*/
    @PostMapping("/memberGradeRemove")
    @ResponseBody
    public Map<String, Object> memberGradeRemove(@RequestParam(value = "rowCheck[]") List<String> chArr){
        log.info("chArr : {}", chArr);
        Map<String, Object> result = new HashMap<>();

        if (chArr != null) {
            for (String i : chArr) {
                int memberNum = Integer.parseInt(i);
                memberService.memberGradeRemove(memberNum);
            }
            result.put("result", "success");
        }

        return  result;
    }


    /* 회원 상세페이지 */
    @GetMapping("/adminMemberDetail")
    public String getadminMemberDetail(@RequestParam int memberCode,Model model) {

     MemberDTO member =   memberService.selectMemberDetail(memberCode);
     model.addAttribute("memberList",member);

     return "admin/adminMemberDetail";
    }

    /* 회원정보 수정*/
    @PostMapping("/adminMemberUpdate")
    public ResponseEntity<String> adminMemberUpdate(@RequestBody(required = false) MemberDTO member,String zipCode, String address1, String address2){
        log.info("member {}",member);

        String address = zipCode + "$" + address1 + "$" + address2;
        member.setAddress(address);
        memberService.adminMemberUpdate(member);

        String result = "회원정보 수정완료입니다.";

        return ResponseEntity.ok(result);
    }

    /* 회원 비밀번호 변경페이지*/
    @GetMapping("/adminPwUpdate")
    public String adminPwUpdateView(@RequestParam int memberCode,Model model){

        MemberDTO member =   memberService.selectMemberDetail(memberCode);
        model.addAttribute("member",member);

        return "admin/adminPwUpdate";
    }


    /* 회원 비밀번호 변경  */
    @PostMapping("/adminPwUpdate")
    public ResponseEntity<String> adminPwUpdate(@RequestBody MemberDTO member){

        log.info("memberCode {}", member.getMemberCode());
        log.info("memberPwd {}",member.getMemberPwd());
        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

        memberService.adminPwUpdate(member);
        log.info("memberPwd {}",member.getMemberPwd());

        String result = "비밀번호 변경완료입니다.";

        return ResponseEntity.ok(result);
    }

    /* 회원 적립금페이지*/
    @GetMapping("/adminPointDetail")
    public String adminPointDetailView(@RequestParam int memberCode,Model model){

        MemberDTO member = memberService.selectMemberDetail(memberCode);
        model.addAttribute("member",member);
        return "admin/adminPointDetail";
    }
    /* 회원 적립금*/
    @PostMapping("/adminPointDetail")
    public ResponseEntity<String> adminPointDetail(@RequestBody MileageDTO mileage){
        memberService.insertPoint(mileage);

        String mileageType = mileage.getMileageType();

        if(mileageType.equals("Y")){
            memberService.updateMemberPoint(mileage);
            String result = "적립됐습니다";
            return ResponseEntity.ok(result);
        }else {
            memberService.deductMemberPoint(mileage);
            String result = "차감됐습니다";
            return ResponseEntity.ok(result);
        }
    }

}
