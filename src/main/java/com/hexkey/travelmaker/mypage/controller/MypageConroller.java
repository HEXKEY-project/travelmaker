package com.hexkey.travelmaker.mypage.controller;

import com.hexkey.travelmaker.common.exception.MemberModifyException;
import com.hexkey.travelmaker.common.exception.MemberRemoveException;
import com.hexkey.travelmaker.mypage.service.MypageService;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import com.hexkey.travelmaker.user.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/user")
public class MypageConroller {

    private final MypageService mypageService;
    private final MessageSourceAccessor messageSourceAccessor;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;


    public MypageConroller(MypageService mypageService, MessageSourceAccessor messageSourceAccessor, PasswordEncoder passwordEncoder, AuthenticationService authenticationService) {
        this.mypageService = mypageService;
        this.messageSourceAccessor = messageSourceAccessor;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }


    @GetMapping("/mypage")
    public String mypagePage(@AuthenticationPrincipal MemberInfoDTO member) {

        return "/user/mypage/mypage";

    }

    @GetMapping("/modify")
    public String modifyPage(@AuthenticationPrincipal MemberInfoDTO member) {
        log.info("Member info :{}", member);
        return "/user/mypage/modify";
    }

    @PostMapping("/modify")
    public String modifyPage(MemberInfoDTO modifyMember, @AuthenticationPrincipal MemberInfoDTO loginMember,
                             AddressDTO address, String zipCode, String address1, String address2,
                             RedirectAttributes rttr) throws MemberModifyException {

        address.setPostalCode(Integer.parseInt(zipCode));
        address.setDefaultAdr(address1);
        address.setOptionalAdr(address2);
        address.setMemberCode(loginMember.getMemberCode());

        modifyMember.setAddress(address);
        modifyMember.setMemberCode(loginMember.getMemberCode());


        modifyMember.setMemberPwd(passwordEncoder.encode(modifyMember.getPassword()));

        log.info("modifyMember request Member : {}", modifyMember);

        mypageService.modifyMember(modifyMember, address);

        /* 로그인 시 저장된 Authentication 객체를 변경된 정보로 교체한다. */
        SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(loginMember.getMemberId()));

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.modify"));

        return "redirect:/mypage/mypage";

    }

    private Authentication createNewAuthentication(String memberId) {

        UserDetails newPrincipal = authenticationService.loadUserByUsername(memberId);
        UsernamePasswordAuthenticationToken newAuth
                = new UsernamePasswordAuthenticationToken(newPrincipal, newPrincipal.getPassword(), newPrincipal.getAuthorities());

        return newAuth;

    }

    // 회원 탈퇴
    @GetMapping("/delete")
    public String deleteMember(@AuthenticationPrincipal MemberInfoDTO member, RedirectAttributes rttr) throws MemberRemoveException {

        log.info("login member : {}", member);

        mypageService.removeMember(member);

        SecurityContextHolder.clearContext();

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.delete"));

        return "redirect:/";

    }

    // 마이페이지 내 후기
//    @GetMapping("/reviewList")
//    public String reviewListPage(@RequestParam(defaultValue = "1") int page,
//                                 @AuthenticationPrincipal MemberInfoDTO loginMember, Model model) {
//
//        log.info("reviewList page : {}", page);
//
//        Map<String, Object> reviewListAndPaging = reviewService.selectReviewList(page, loginMember);
//        model.addAttribute("paging", reviewListAndPaging.get("paging"));
//        model.addAttribute("reviewList", reviewListAndPaging.get("reviewList"));
//
//        return "/user/review/reviewList";
//
//    }

    @GetMapping("/reviewList")
    public String reviewListPage() {

        return "/user/mypage/reviewList";

    }

}