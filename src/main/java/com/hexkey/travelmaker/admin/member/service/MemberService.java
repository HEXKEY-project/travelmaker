package com.hexkey.travelmaker.admin.member.service;

import com.hexkey.travelmaker.admin.member.dao.MemberMapper;
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

    public Map<String, Objects> selectMemberList(Map<String, String> searchMap, int page) {

        /* 전체 회원수 확인(검색어가 있는 경우 포함) */
        int totalCount = memberMapper.selectTotalCount(searchMap);
        log.info("boardList totalCount : {}", totalCount);


        return  null;
    }
}
