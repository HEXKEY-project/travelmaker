package com.hexkey.travelmaker.user.controller;

import com.hexkey.travelmaker.common.exception.member.MemberRegistException;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberMDTO;
import com.hexkey.travelmaker.user.service.MemberMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/user")
public class MemberMController {

    private final MemberMService memberMService;

    private final MessageSourceAccessor messageSourceAccessor;

    public MemberMController(MemberMService memberMService, MessageSourceAccessor messageSourceAccessor) {
        this.memberMService = memberMService;
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @GetMapping("/user/login")
    public void loginPage() {}

    @GetMapping("/user/regist")
    public void registPage() {}

//    @GetMapping("/regist")
//    public String registPage() {
//
//        return "/user/user/regist";
//
//    }

    @PostMapping("idCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberMDTO member) {

        log.info("Request Check ID : {}", member.getMemberId());

        String result = "사용 가능한 아이디입니다.";

        if (memberMService.selectMemberById(member.getMemberId())) {
            result = "이미 사용 중인 아이디입니다.";
        }

        return ResponseEntity.ok(result);

    }

    @PostMapping("/user/regist")
    public String registMember(AddressDTO address, MemberMDTO member, String zipCode, String address1, String address2,
                               RedirectAttributes rttr) throws MemberRegistException {

        address.setPostalCode(Integer.parseInt(zipCode));
        address.setDefaultAdr(address1);
        address.setOptionalAdr(address2);

        log.info("Request regist member : {}", member);

        memberMService.registMember(member);

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.regist"));

        return "redirect:/";

    };

}