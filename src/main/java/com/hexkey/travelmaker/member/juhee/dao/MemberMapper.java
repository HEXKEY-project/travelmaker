package com.hexkey.travelmaker.member.juhee.dao;

import com.hexkey.travelmaker.member.juhee.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int insertMember(MemberDTO  member);

    int insertMemberRole();

    String selectMemberById(String memberId);
}
