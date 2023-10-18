package com.hexkey.travelmaker.user.dao;

import com.hexkey.travelmaker.member.admin.dto.MemberDTO;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberInfoMapper {

    String selectMemberById(String memberId);

    int insertMember(MemberInfoDTO member);

    int insertMemberRole();

    int insertMemberAdr(AddressDTO address);

    MemberInfoDTO findByMemberId(String memberId);

    String findId(String memberName, String phone);

    int pwdCheck(MemberDTO dto);

    int updateMember(MemberInfoDTO modifyMember);
}
