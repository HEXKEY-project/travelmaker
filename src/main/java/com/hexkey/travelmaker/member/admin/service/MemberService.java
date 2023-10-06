package com.hexkey.travelmaker.member.admin.service;

import com.hexkey.travelmaker.member.admin.dao.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }



}
