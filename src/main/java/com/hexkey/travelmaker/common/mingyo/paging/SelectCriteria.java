package com.hexkey.travelmaker.common.mingyo.paging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@AllArgsConstructor
public class SelectCriteria {

    private int page;  //현재 페이지
    private int totalCount; //요청하고자하는 총 게시글 갯수
    private int limit;   //한페이지에 보여줄 제한 게시글 갯수
    private int buttonAmount; //한번에 보여줄 페이징 버튼의 수
    private int maxPage; //마지막 끝 페이지
    private int startPage; //첫번째 페이지
    private int endPage; // 마지막 페이지
    private int startRow; //조회가 시작해야하는 행의 수
    private int endRow; //조회가 마지막이라는 행의수
    private String memberGradeList; //조회의 종류
    private String searchValueId; //조회 아이디
    private String searchDate; //조회의 날짜

}
