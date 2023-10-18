package com.hexkey.travelmaker.user.controller;

import com.hexkey.travelmaker.common.exception.MemberRegistException;
import com.hexkey.travelmaker.member.admin.dto.MemberDTO;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberMDTO;
import com.hexkey.travelmaker.user.service.AuthenticationService;
import com.hexkey.travelmaker.user.service.MemberMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> checkDuplication(@RequestBody MemberMDTO member) {

        log.info("Request Check ID : {}", member.getMemberId());

        String result = "사용 가능한 아이디입니다.";

        if (memberMService.selectMemberById(member.getMemberId())) {
            result = "이미 사용 중인 아이디입니다.";
        }

        return ResponseEntity.ok(result);

    }

    @PostMapping("/regist")
    public String registMember(AddressDTO address, MemberMDTO member, String zipCode, String address1, String address2,
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

//    /* 비밀번호 찾기 결과 */
//    @PostMapping("/findPwd")
//    public String findPwdCheck(Model model, @RequestParam String memberName,
//                               @RequestParam String memberId, MemberDTO dto){
//
//        try{
//            dto.setMemberId(memberId);
//            dto.setMemberName(memberName);
//            int search = memberMService.pwdCheck(dto);
//
//            if(search == 0){
//                model.addAttribute("message", "입력 정보가 잘못되었습니다. 다시 입력해주세요.");
//            }
//
//            char[] charSet = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
//                    'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
//
//            String tempPwd="";
//            int idx = 0;
//            for (int i = 0; i < 10; i++) {
//                idx = (int) (charSet.length * Math.random());
//                tempPwd += charSet[idx];
//            }
//
//            dto.setMemberPwd(tempPwd);
//            memberMService.pwdUpdate(dto);
//            model.addAttribute("tempPwd", tempPwd);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            model.addAttribute("message", "오류가 발생했습니다.");
//        }
//        return "member/find_pwd_result";
//    }

    @GetMapping("/user/mypage")
    public void mypagePage() {}



}