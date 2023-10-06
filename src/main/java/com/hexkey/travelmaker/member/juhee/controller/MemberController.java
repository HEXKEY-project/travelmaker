package com.hexkey.travelmaker.member.juhee.controller;

import com.hexkey.travelmaker.common.MemberRegistException;
import com.hexkey.travelmaker.member.juhee.service.MemberMainService;
import com.hexkey.travelmaker.member.juhee.dto.AddressDTO;
import lombok.extern.slf4j.Slf4j;
import com.hexkey.travelmaker.member.juhee.dto.MemberDTO;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberMainService memberMainService;
    private final PasswordEncoder passwordEncoder;
    private final MessageSourceAccessor messageSourceAccessor;

    public MemberController(MemberMainService memberMainService, PasswordEncoder passwordEncoder, MessageSourceAccessor messageSourceAccessor) {
        this.memberMainService = memberMainService;
        this.passwordEncoder = passwordEncoder;
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @GetMapping("/login")
    public void loginPage() {}

    @GetMapping("/regist")
    public void reigstPage() {}

    // 아이디 중복 체크
    @PostMapping("/idDupCheck")
    public ResponseEntity<String>  checkDuplication(@RequestBody MemberDTO member) {

        log.info("Request Check ID : {}", member.getMemberId());
        String result = "사용 가능한 아이디입니다.";

        if (memberMainService.selectMemberById(member.getMemberId())) {
            result = "이미 사용 중인 아이디입니다.";
        }

        return ResponseEntity.ok(result);

    }

    // 회원가입
    @PostMapping("/regist")
    public String registMember (AddressDTO address, MemberDTO member, String zipCode, String address1, String address2,
                               RedirectAttributes rttr) throws MemberRegistException  {

        address.setPostalCode(Integer.parseInt(zipCode));
        address.setDefaultAdr(address1);
        address.setOptionAdr(address2);

        member.setMemberPwd(passwordEncoder.encode(member.getPassword()));

        log.info("Request regist member : {}", member);

        memberMainService.registMemebr(member);

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.regist"));

        return "redirect:/";

    }

}
