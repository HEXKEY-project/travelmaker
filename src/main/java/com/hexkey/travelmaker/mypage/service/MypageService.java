package com.hexkey.travelmaker.mypage.service;

import com.hexkey.travelmaker.admin.dto.MemberDTO;
import com.hexkey.travelmaker.common.exception.MemberModifyException;
import com.hexkey.travelmaker.common.exception.MemberRemoveException;
import com.hexkey.travelmaker.common.mingyo.paging.Pagenation;
import com.hexkey.travelmaker.common.mingyo.paging.SelectCriteria;
import com.hexkey.travelmaker.mypage.dao.MypageMapper;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import com.hexkey.travelmaker.user.dto.AddressDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class MypageService {

    private MypageMapper mypageMapper;
    // 생성자 의존성 주입
    public MypageService(MypageMapper mypageMapper) { this.mypageMapper = mypageMapper; }

//    public static Map<String, Object> selectReviewList(int page, MemberDTO loginMember) {
//        /* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
//        int totalCount = MypageMapper.selectTotalCount(loginMember);
//        log.info("boardList totalCount : {}", totalCount);
//
//        /* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
//        int limit = 7;                                          // 한 페이지에 보여줄 게시물(컨텐츠)의 수
//        int buttonAmount = 7;                                   // 한 번에 보여질 페이징 버튼의 수
//        SelectCriteria selectCriteria = Pagination.getSelectCriteria(page, limit, buttonAmount);
//        log.info("boardList selectCriteria : {}", selectCriteria);
//
//        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
//        List<ReviewDTO> reviewList = MypageMapper.selectReviewList(selectCriteria, loginMember);
//        log.info("reviewList : {}", reviewList);
//
//        Map<String, Object> reviewListAndPaging = new HashMap<>();
//        reviewListAndPaging.put("paging", selectCriteria);
//        reviewListAndPaging.put("reviewList", reviewList);
//
//        return reviewListAndPaging;
//
//    }
    // 회원 정보 수정
    @Transactional
    public void modifyMember(MemberInfoDTO modifyMember, AddressDTO address) throws MemberModifyException {

        int result1 = mypageMapper.updateMember(modifyMember);
        int result2 = mypageMapper.updateAddress(address);

        if (!(result1 > 0 && result2 > 0)) throw new MemberModifyException("회원 정보 수정에 실패했습니다.");

    }

    // 회원 탈퇴
    @Transactional
    public void removeMember(MemberInfoDTO member) throws MemberRemoveException {

        int result = mypageMapper.deleteMember(member);

        if (!(result > 0)) {
            throw new MemberRemoveException("회원 탈퇴에 실패했습니다.");
        }

    }

    // 전체 후기 조회
//    public Map<String, Object> selectReviewList(int page, MemberInfoDTO loginMember) {
//
//        int totalCount = reviewMapper.selectTotalCount(loginMember);
//        log.info("boardList totalCount : {}", totalCount);
//
//        int limit = 10;
//        int total = 19;
//        int buttonAmount = 7;
//        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, limit, total, buttonAmount);
//        log.info("boardList selectCriteria : {}", selectCriteria);
//
//
//        List<ReviewDTO> reviewList = reviewMapper.selectReviewList(selectCriteria);
//        log.info("reviewList : {}", reviewList);
//
//        Map<String, Object> reviewListAndPaging = new HashMap<>();
//        reviewListAndPaging.put("paging", selectCriteria);
//        reviewListAndPaging.put("reviewList", reviewList);
//
//        return reviewListAndPaging;
//
//    }

}