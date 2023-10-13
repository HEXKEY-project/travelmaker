package com.hexkey.travelmaker.user.dao;

import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberMDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMMapper {

    String selectMemberById(String memberId);

    int insertMember(MemberMDTO member);

    int insertMemberRole();

    int insertMemberAdr(AddressDTO address);

    MemberMDTO findByMemberId(String memberId);

}
