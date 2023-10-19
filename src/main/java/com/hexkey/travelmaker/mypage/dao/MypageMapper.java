package com.hexkey.travelmaker.mypage.dao;

import com.hexkey.travelmaker.admin.dto.MemberDTO;
import com.hexkey.travelmaker.common.mingyo.paging.SelectCriteria;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {


    int updateMember(MemberInfoDTO modifyMember);

    int updateAddress(AddressDTO address);

    int deleteMember(MemberInfoDTO member);
}
