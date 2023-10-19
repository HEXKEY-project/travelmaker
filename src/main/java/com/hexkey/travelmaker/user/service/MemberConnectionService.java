package com.hexkey.travelmaker.user.service;

import com.hexkey.travelmaker.common.exception.MemberModifyException;
import com.hexkey.travelmaker.common.exception.MemberRegistException;
import com.hexkey.travelmaker.admin.dto.MemberDTO;
import com.hexkey.travelmaker.common.exception.MemberRemoveException;
import com.hexkey.travelmaker.user.dao.MemberInfoMapper;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class MemberConnectionService {

    private MemberInfoMapper memberInfoMapper;

    public MemberConnectionService(MemberInfoMapper memberInfoMapper) {
        this.memberInfoMapper = memberInfoMapper;
    }

    // 아이디 중복 확인
    public boolean selectMemberById(String memberId) {

        String result = memberInfoMapper.selectMemberById(memberId);

        return result != null;

    }

    // 회원가입
    @Transactional
    public void registMember(MemberInfoDTO member, AddressDTO address) throws MemberRegistException {

        member.setMileage(0);
        member.setGradeCode(1);
        member.setLoginType("일반");
        member.setJoinDay(new Date());
        member.setMemberStatus("Y");
        address.setDefaultYn("Y");
        address.setAddressName("");

        log.info("memberDTO : {}", member);
        log.info("addressDTO : {}", address);

        int result1 = memberInfoMapper.insertMember(member);
        int result2 = memberInfoMapper.insertMemberAdr(address);
        int result3 = memberInfoMapper.insertMemberRole();

        if (!(result1 > 0 && result2 > 0 && result3 > 0)) throw new MemberRegistException("회원가입에 실패했습니다.");

    }


    // 회원 정보 수정
    @Transactional
    public void modifyMember(MemberInfoDTO modifyMember) throws MemberModifyException {

        int result = memberInfoMapper.updateMember(modifyMember);

        if (!(result > 0)) throw new MemberModifyException("회원 정보 수정에 실패했습니다.");

    }
    public void pwdUpdate(MemberInfoDTO dto) {
    }

//    public int pwdCheck(MemberInfoDTO dto) {
//        return memberInfoMapper.pwdCheck(dto);
//    }


    public void removeMember(MemberInfoDTO member) throws MemberRemoveException {

        int result = memberInfoMapper.deleteMember(member);

        if (!(result > 0)) {
            throw new MemberRemoveException("회원 탈퇴에 실패했습니다.");
        }

    }


}