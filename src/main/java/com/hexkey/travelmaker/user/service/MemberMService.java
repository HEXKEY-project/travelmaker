package com.hexkey.travelmaker.user.service;

import com.hexkey.travelmaker.common.exception.MemberModifyException;
import com.hexkey.travelmaker.common.exception.MemberRegistException;
import com.hexkey.travelmaker.member.admin.dto.MemberDTO;
import com.hexkey.travelmaker.user.dao.MemberMMapper;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberMDTO;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class MemberMService {

    private MemberMMapper memberMMapper;

    public MemberMService(MemberMMapper memberMMapper) {
        this.memberMMapper = memberMMapper;
    }

    // 아이디 중복 확인
    public boolean selectMemberById(String memberId) {

        String result = memberMMapper.selectMemberById(memberId);

        return result != null;

    }

    // 회원가입
    @Transactional
    public void registMember(MemberMDTO member, AddressDTO address) throws MemberRegistException {

        member.setMileage(0);
        member.setGradeCode(1);
        member.setLoginType("일반");
        member.setJoinDay(new Date());
        member.setMemberStatus("Y");
        address.setDefaultYn("Y");
        address.setAddressName("");

        log.info("memberDTO : {}", member);
        log.info("addressDTO : {}", address);

        int result1 = memberMMapper.insertMember(member);
        int result2 = memberMMapper.insertMemberAdr(address);
        int result3 = memberMMapper.insertMemberRole();

        if (!(result1 > 0 && result2 > 0 && result3 > 0)) throw new MemberRegistException("회원가입에 실패했습니다.");

    }


    // 회원 정보 수정
    @Transactional
    public void modifyMember(MemberMDTO modifyMember) throws MemberModifyException {

        int result = memberMMapper.updateMember(modifyMember);

        if (!(result > 0)) throw new MemberModifyException("회원 정보 수정에 실패했습니다.");

    }
    public void pwdUpdate(MemberDTO dto) {
    }

    public int pwdCheck(MemberDTO dto) {
        return memberMMapper.pwdCheck(dto);
    }

//     아이디 찾기
//    public String findId(String memberName, String phone, String email) {
//
//        return memberMMapper.findId(memberName, phone, email);
//
//    }
//
//    // 비밀번호 찾기
//    public String int findPwd(MemberDTO dto) {
//
//    }

}