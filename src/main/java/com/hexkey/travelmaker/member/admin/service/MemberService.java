package com.hexkey.travelmaker.member.admin.service;

import com.hexkey.travelmaker.common.mingyo.paging.Pagenation;
import com.hexkey.travelmaker.common.mingyo.paging.SelectCriteria;
import com.hexkey.travelmaker.member.admin.dao.MemberMapper;
import com.hexkey.travelmaker.member.admin.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    public Map<String, Object> findAllMemberList(int page, Map<String, String> searchMap) {
        int totalCount = memberMapper.selectTotalCount(searchMap);
        log.info("memberListTotalCount :{}",totalCount);

        int limit = 10;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
        log.info("memberList selectCriteria : {}", selectCriteria);

        List<MemberDTO> memberList =  memberMapper.findAllMemberList(selectCriteria);
        log.info("memberList :{}%n",memberList);

        Map<String, Object> memberListAndPaging = new HashMap<>();
        memberListAndPaging.put("paging", selectCriteria);
        memberListAndPaging.put("memberList", memberList);

        return memberListAndPaging;
    }
}
