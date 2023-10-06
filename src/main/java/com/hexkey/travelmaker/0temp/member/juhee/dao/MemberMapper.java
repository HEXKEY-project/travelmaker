package com.hexkey.travelmaker;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int insertMember(com.hexkey.travelmaker.MemberDTO member);

    int insertMemberRole();

    String selectMemberById(String memberId);
}
