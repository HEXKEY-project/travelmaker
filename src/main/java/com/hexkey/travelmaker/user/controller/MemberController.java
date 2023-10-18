package com.hexkey.travelmaker.user.controller;

import com.hexkey.travelmaker.common.exception.MemberRegistException;
import com.hexkey.travelmaker.member.admin.dto.MemberDTO;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import com.hexkey.travelmaker.user.service.AuthenticationService;
import com.hexkey.travelmaker.user.service.MemberMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Slf4j
@Controller
@RequestMapping("/user")
public class MemberController {

    private final MemberMService memberMService;
    private final MessageSourceAccessor messageSourceAccessor;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;

    public MemberController(MemberMService memberMService, MessageSourceAccessor messageSourceAccessor, PasswordEncoder passwordEncoder, AuthenticationService authenticationService) {
        this.memberMService = memberMService;
        this.messageSourceAccessor = messageSourceAccessor;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/user/login")
    public void loginPage() {}

    @PostMapping("/user/loginfail")
    public String loginFailed(RedirectAttributes rttr) {

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("error.login"));
        return "redirect:/user/user/login";

    }

    @GetMapping("/user/regist")
    public void registPage() {}

//    @GetMapping("/regist")
//    public String registPage() {
//
//        return "/user/user/regist";
//
//    }

    @PostMapping("idCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberInfoDTO member) {

        log.info("Request Check ID : {}", member.getMemberId());

        String result = "사용 가능한 아이디입니다.";

        if (memberMService.selectMemberById(member.getMemberId())) {
            result = "이미 사용 중인 아이디입니다.";
        }

        return ResponseEntity.ok(result);

    }

    @PostMapping("/regist")
    public String registMember(AddressDTO address, MemberInfoDTO member, String zipCode, String address1, String address2,
                               RedirectAttributes rttr) throws MemberRegistException {

        address.setPostalCode(Integer.parseInt(zipCode));
        address.setDefaultAdr(address1);
        address.setOptionalAdr(address2);
        member.setMemberPwd(passwordEncoder.encode(member.getPassword()));

        log.info("Request regist member : {}", member);

        memberMService.registMember(member, address);

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.regist"));

        return "redirect:/";

    };

    @GetMapping("/user/findId")
    public void findIdPage() {}

    @GetMapping("user/foundId")
    public void foundIdPage() {}

    @GetMapping("user/findPwd")
    public void findPwdPage() {}

    @GetMapping("user/foundPwd")
    public void foundPwdPage() {}

    @GetMapping("/user/mypage")
    public void mypagePage(@AuthenticationPrincipal MemberInfoDTO member) {}

    @GetMapping("/user/modify")
    public void modifyPage(@AuthenticationPrincipal MemberInfoDTO member) {
        log.info("Member info :{}", member);
    }


//    public void modifyPage(MemberInfoDTO modifyMember, @AuthenticationPrincipal MemberInfoDTO loginMember,
//                           AddressDTO address, String zipCode, String defaultAdr, String optionalAdr,
//                           RedirectAttributes rttr) {
//
//        address.setZipCode(zipCode);
//        modifyMember.setDefaultAdr(defaultAdr);
//        modifyMember.setOptionAdr(optionalAdr);
//        modifyMember.setMemberCode(loginMember.getMemberCode());
//
//        log.info("modifyMember request Member : {}", modifyMember);
//
//        memberMService.modifyMember(modifyMember);
//
//        /* 로그인 시 저장 된 Authentication 객체를 변경 된 정보로 교체한다. */
//        SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(loginMember.getMemberId()));
//
//        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.modify"));
//
//        return "redirect:/user/user/mypage";
//
//
//    }

    private Authentication createNewAuthentication(String memberId) {
        return null;
    }

}