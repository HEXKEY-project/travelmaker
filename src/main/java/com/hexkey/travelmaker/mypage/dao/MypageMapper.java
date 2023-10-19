package com.hexkey.travelmaker.mypage.dao;

import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {
    int updateMember(MemberInfoDTO modifyMember);

    int updateAddress(AddressDTO address);

    int deleteMember(MemberInfoDTO member);
}
