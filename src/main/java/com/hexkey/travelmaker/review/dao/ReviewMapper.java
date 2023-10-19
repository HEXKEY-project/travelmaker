package com.hexkey.travelmaker.review.dao;

import com.hexkey.travelmaker.common.mingyo.paging.SelectCriteria;
import com.hexkey.travelmaker.review.dto.ReviewAttachDTO;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {


    void insertReview(ReviewDTO review);

    void insertReviewAttachImage(ReviewAttachDTO reviewAttachImage);

    int selectTotalCount(MemberInfoDTO loginMember);

    List<ReviewDTO> selectReviewList(SelectCriteria selectCriteria);
}
