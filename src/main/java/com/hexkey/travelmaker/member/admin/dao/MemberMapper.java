package com.hexkey.travelmaker.member.admin.dao;


import com.hexkey.travelmaker.common.mingyo.paging.SelectCriteria;
import com.hexkey.travelmaker.member.admin.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    /* 전체 회원수 조회*/
    int selectTotalCount(Map<String, String> searchMap);
    /* 회원목록 조회*/
    List<MemberDTO> findAllMemberList(SelectCriteria selectCriteria);
}
