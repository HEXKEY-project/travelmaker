package com.hexkey.travelmaker;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final com.hexkey.travelmaker.MemberMapper memberMapper;

    public MemberService(com.hexkey.travelmaker.MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Transactional
    public void registMemebr(com.hexkey.travelmaker.MemberDTO member) throws com.hexkey.travelmaker.MemberRegistException {

        int result1 = memberMapper.insertMember(member);
        int result2 = memberMapper.insertMemberRole();

        if (!(result1 > 0 && result2 > 0)) throw new com.hexkey.travelmaker.MemberRegistException("회원 가입에 실패했습니다.");

    }

    public boolean selectMemberById(String memberId) {

        String result = memberMapper.selectMemberById(memberId);

        return  result != null;

    }
}
