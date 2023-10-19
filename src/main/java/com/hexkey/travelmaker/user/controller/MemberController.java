package com.hexkey.travelmaker.user.controller;

import com.hexkey.travelmaker.common.exception.MemberRegistException;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import com.hexkey.travelmaker.user.service.AuthenticationService;
import com.hexkey.travelmaker.user.service.MemberConnectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/user")
public class MemberController {

    private final MemberConnectionService memberConnectionService;
    private final MessageSourceAccessor messageSourceAccessor;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;

    public MemberController(MemberConnectionService memberConnectionService, MessageSourceAccessor messageSourceAccessor, PasswordEncoder passwordEncoder, AuthenticationService authenticationService) {
        this.memberConnectionService = memberConnectionService;
        this.messageSourceAccessor = messageSourceAccessor;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String loginPage() {

        return "/user/user/login";

    }

    @PostMapping("/user/loginfail")
    public String loginFailed(RedirectAttributes rttr) {

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("error.login"));
        return "redirect:/user/login";

    }

    @GetMapping("/regist")
    public String registPage() {

        return "/user/user/regist";

    }

    @PostMapping("idCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberInfoDTO member) {

        log.info("Request Check ID : {}", member.getMemberId());

        String result = "사용 가능한 아이디입니다.";

        if (memberConnectionService.selectMemberById(member.getMemberId())) {
            result = "이미 사용 중인 아이디입니다.";
        }

        return ResponseEntity.ok(result);

    }

    @PostMapping("/regist")
    public String registMember(AddressDTO address, MemberInfoDTO member, String zipCode, String address1, String address2,
                               @RequestParam(defaultValue = "N") String smsYn, @RequestParam(defaultValue = "N") String emailYn,
                               RedirectAttributes rttr) throws MemberRegistException {

        address.setPostalCode(Integer.parseInt(zipCode));
        address.setDefaultAdr(address1);
        address.setOptionalAdr(address2);
        member.setMemberPwd(passwordEncoder.encode(member.getPassword()));
        member.setSmsYn(smsYn);
        member.setEmailYn(emailYn);

        log.info("Request regist member : {}", member);
        log.info("Request regist address : {}", address);

        memberConnectionService.registMember(member, address);

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.regist"));

        log.info("member info : {}", member);
        log.info("address info : {}", address);
        return "redirect:/";

    };

    @GetMapping("/findId")
    public String findIdPage() {

        return "/user/user/findId";

    }

    @GetMapping("/findPwd")
    public String findPwdPage() {

        return "/user/user/findPwd";

    }

}