package com.hexkey.travelmaker.admin.service;

import com.hexkey.travelmaker.admin.dao.MemberMapper;
import com.hexkey.travelmaker.admin.dto.MemberDTO;
import com.hexkey.travelmaker.admin.dto.MileageDTO;
import com.hexkey.travelmaker.common.mingyo.paging.Pagenation;
import com.hexkey.travelmaker.common.mingyo.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    /**
     * 리스트 페이징
     * @param page
     * @param searchMap
     * @return
     */
    public Map<String, Object> findAllMemberList(int page, Map<String, String> searchMap) {
        int totalCount = memberMapper.selectTotalCount(searchMap);
      //  log.info("memberListTotalCount :{}",totalCount);

        int limit = 10;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
      //  log.info("memberList selectCriteria : {}", selectCriteria);

        List<MemberDTO> memberList =  memberMapper.findAllMemberList(selectCriteria);
        log.info("memberList :{}%n",memberList);

//        for(MemberDTO member : memberList) {
//
//            String phone = member.getPhone();
//            if (phone != null) {
//                phone = phone.replaceAll(Pattern.quote("-"), "");
//                if (phone.length() == 11) {
//                    // 010-1234-1234
//                    phone = phone.substring(0, 3) + "-" + phone.substring(3, 7) + "-" + phone.substring(7);
//                }
//            }
//            member.setPhone(phone);
//        }

        Map<String, Object> memberListAndPaging = new HashMap<>();
        memberListAndPaging.put("paging", selectCriteria);
        memberListAndPaging.put("memberList", memberList);

        return memberListAndPaging;
    }


    
    public void deleteMember(int memberCode) {

        memberMapper.deleteMember(memberCode);
     //   log.info("memberDelete {}", memberNum);


    }

    public MemberDTO selectMemberDetail(int memberCode) {

       MemberDTO result =  memberMapper.selectMemberDetail(memberCode);
       log.info("teststsg {}", result);

       return result;
    }

    /* 패스워드 변경*/
    public void adminPwUpdate(MemberDTO memberUpdate) {

       int result =  memberMapper.adminPwUpdate(memberUpdate);

        if(!(result > 0)){
            log.info("resultError :{}", result);
        }
    }

    public void adminMemberUpdate(MemberDTO member) {

    int result =   memberMapper.adminMemberUpdate(member);
        log.info("result :{}", result);
        if((result > 0)){
            log.info("성공! :{}", result);
        }

    }

    public void memberGradeRemove(int memberCode) {

        memberMapper.memberGradeRemove(memberCode);
    }

    public void insertPoint(MileageDTO mileage) {

      int result = memberMapper.insertPoint(mileage);

      if (result > 0){
          log.info("적립금 성공 {}", result);
      }
    }

    public void updateMemberPoint(MileageDTO memberCode) {

        int result =  memberMapper.updateMemberPoint(memberCode);
        if (result > 0){
            log.info("적립금 적립 {}", result);
        }
    }

    public void deductMemberPoint(MileageDTO mileage) {

              int result = memberMapper.deductMemberPoint(mileage);
              if (result > 0){
                log.info("적립금 차감 {}", result);
              }
    }
}
