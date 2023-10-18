package com.hexkey.travelmaker.community.notices.service;

import com.hexkey.travelmaker.common.zeesang.paging.Pagenation;
import com.hexkey.travelmaker.common.zeesang.paging.SelectCriteria;
import com.hexkey.travelmaker.community.notices.dao.NoticesMapper;
import com.hexkey.travelmaker.community.notices.dto.NoticesDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class NoticesService {
    private final NoticesMapper noticesMapper;
    @Autowired
    public NoticesService(NoticesMapper noticesMapper){
        this.noticesMapper=noticesMapper;}

    public Map<String, Object> selectNotices(Map<String, String> searchMap, int page) {
        /* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
        int totalCount = noticesMapper.selectTotalCount(searchMap);
        log.info("boardList totalCount : {}", totalCount);

        /* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
        int limit = 8;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
        log.info("boardList selectCriteria : {}", selectCriteria);

        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
        List<NoticesDTO> noticesList = noticesMapper.selectNotices(selectCriteria);
        log.info("noticesList : {}", noticesList);

        Map<String, Object> noticesListAndPaging = new HashMap<>();
        noticesListAndPaging.put("paging", selectCriteria);
        noticesListAndPaging.put("noticesList", noticesList);

        return noticesListAndPaging;
    }

    public NoticesDTO selectNoticesdDetail(Long no) {
        return noticesMapper.selectNoticesDetail(no);
    }
}
