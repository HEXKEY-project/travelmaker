package com.hexkey.travelmaker.member.juhee.service;

import com.hexkey.travelmaker.common.MemberRegistException;
import com.hexkey.travelmaker.member.juhee.dao.MemberMainMapper;
import com.hexkey.travelmaker.member.juhee.dto.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class
MemberMainService {
    private final MemberMainMapper memberMainMapper;
    public MemberMainService(MemberMainMapper memberMainMapper)  {this.memberMainMapper = memberMainMapper;    }

     @Transactional
    public void registMemebr(MemberDTO member) throws MemberRegistException {
        int result1 = memberMainMapper.insertMember(member);
        int result2 = memberMainMapper.insertMemberRole();
        if (!(result1 > 0 && result2 > 0)) throw new MemberRegistException("회원가입에 실패했습니다.");
    }

    public boolean selectMemberById
            (String memberId) {
        String result = memberMainMapper.selectMemberById (memberId);
        return  result != null;
    }


}

