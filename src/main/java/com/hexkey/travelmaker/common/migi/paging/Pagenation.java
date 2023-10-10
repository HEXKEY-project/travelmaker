package com.hexkey.travelmaker.common.migi.paging;

import java.util.HashMap;
import java.util.Map;

public class Pagenation {

    public static SelectCriteria getSelectCriteria(int page, int totalCount, int limit, int buttonAmount, Map<String, String> searchMap){

        /* 총 페이지 수 */
        int maxPage = (int) Math.ceil((double) totalCount / limit);

        /* 페이징 바 시작 */
        int startPage = (int) (Math.ceil((double) page/buttonAmount) - 1) * buttonAmount + 1;

        /* 페이징 바 끝 */
        int endPage = startPage + buttonAmount -1;

        /* maxPage < endPage ==> endPage == maxPage */
        if (maxPage < endPage) endPage = maxPage;

        /* 마지막 페이지는 0이 될 수 없다. 상품이 존재하지 않으면 max, end 페이지는 0이 된다. */
        if (maxPage == 0 && endPage == 0) {
            maxPage = startPage;
            endPage = startPage;
        }

        /* 조회 시작 행과 마지막 행 계산 */
        int startRow = (page - 1) * limit + 1;
        int endRow = startRow + limit - 1;


        return new SelectCriteria(page, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow, searchMap.get("searchCondition"), searchMap.get("searchValue"));
    }

    public static SelectCriteria getSelectCriteria(int page, int totalCount, int limit, int buttonAmount) {

        return getSelectCriteria(page, totalCount, limit, buttonAmount, new HashMap<>());
    }
}
