package com.hexkey.travelmaker.admin.service;

import com.hexkey.travelmaker.admin.dao.MemberMapper;
import com.hexkey.travelmaker.common.paging.Pagenation;
import com.hexkey.travelmaker.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;


@Slf4j
@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }



}
