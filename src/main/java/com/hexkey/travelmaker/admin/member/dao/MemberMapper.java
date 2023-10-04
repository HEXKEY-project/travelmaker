package com.hexkey.travelmaker.admin.member.dao;


import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {

    int selectTotalCount(Map<String, String> searchMap);

}
