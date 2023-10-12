package com.hexkey.travelmaker.member.user.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMMapper {

    String selectMemberById(String memberId);

}
