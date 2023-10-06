package com.hexkey.travelmaker.member.mingyo.service;

import com.hexkey.travelmaker.member.mingyo.dao.MemberMapper;
import com.hexkey.travelmaker.common.paging.Pagenation;
import com.hexkey.travelmaker.common.paging.SelectCriteria;
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