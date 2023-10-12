package com.hexkey.travelmaker.member.user.service;

import com.hexkey.travelmaker.member.user.dao.MemberMMapper;
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

}