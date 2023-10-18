package com.hexkey.travelmaker.admin.dao;


import com.hexkey.travelmaker.admin.dto.MileageDTO;
import com.hexkey.travelmaker.common.mingyo.paging.SelectCriteria;
import com.hexkey.travelmaker.admin.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    /* 전체 회원수 조회*/
    int selectTotalCount(Map<String, String> searchMap);
    /* 회원목록 조회*/
    List<MemberDTO> findAllMemberList(SelectCriteria selectCriteria);

    /* 회원 삭제*/
    int deleteMember(int memberCode);

    /* 회원 상세조회 */
   MemberDTO selectMemberDetail(int memberCode);
    /* 회원 상세페이지 비밀번호 수정*/
    int adminPwUpdate(MemberDTO memberUpdate);
    
    /* 회원 상세페이지 수정 */
    int adminMemberUpdate(MemberDTO member);
    
    /* 회원 등급해제*/
    int memberGradeRemove(int memberCode);
    /* 적립금 적립/차감 */
    int insertPoint(MileageDTO mileage);
    /* 회원 적립금 업데이트(적립)*/
    int updateMemberPoint(MileageDTO mileage);
    /* 회원 적립금 업데이트(차감)*/
    int deductMemberPoint(MileageDTO mileage);
}
