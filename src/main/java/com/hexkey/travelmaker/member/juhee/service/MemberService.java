package com.hexkey.travelmaker.member.juhee.service;

import com.hexkey.travelmaker.common.MemberRegistException;
import com.hexkey.travelmaker.member.juhee.dao.MemberMapper;
import com.hexkey.travelmaker.member.juhee.dto.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Transactional
    public void registMemebr(MemberDTO member) throws MemberRegistException {

        int result1 = memberMapper.insertMember(member);
        int result2 = memberMapper.insertMemberRole();

        if (!(result1 > 0 && result2 > 0)) throw new MemberRegistException("회원 가입에 실패했습니다.");

    }

    public boolean selectMemberById(String memberId) {

        String result = memberMapper.selectMemberById(memberId);

        return  result != null;

    }
}
