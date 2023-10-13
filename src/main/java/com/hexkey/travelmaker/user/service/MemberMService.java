package com.hexkey.travelmaker.user.service;

import com.hexkey.travelmaker.common.exception.member.MemberRegistException;
import com.hexkey.travelmaker.user.dao.MemberMMapper;
import com.hexkey.travelmaker.user.dto.MemberMDTO;
import org.springframework.stereotype.Service;

@Service
public class MemberMService {

    private MemberMMapper memberMMapper;

    public MemberMService(MemberMMapper memberMMapper) {
        this.memberMMapper = memberMMapper;
    }

    public boolean selectMemberById(String memberId) {

        String result = memberMMapper.selectMemberById(memberId);

        return result != null;

    }

    public void registMember(MemberMDTO member) throws MemberRegistException {

        int result1 = memberMMapper.insertMember(member);
        int result2 = memberMMapper.insertMeberRole();

        if (!(result1 > 0 && result2 > 0)) throw new MemberRegistException("회원가입에 실패했습니다.");

    }
}