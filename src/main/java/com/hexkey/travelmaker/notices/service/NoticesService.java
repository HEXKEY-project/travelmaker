package com.hexkey.travelmaker.notices.service;

import com.hexkey.travelmaker.common.paging.Pagenation;
import com.hexkey.travelmaker.common.paging.SelectCriteria;
import com.hexkey.travelmaker.notices.dao.NoticesMapper;
import com.hexkey.travelmaker.notices.dto.NoticesDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NoticesService {
    private final NoticesMapper noticesMapper;
    public NoticesService(NoticesMapper noticesMapper){
        this.noticesMapper=noticesMapper;}

    public Map<String, Object> selectNoticesLiset(Map<String, String> searchMap, int page) {
        int totalCount = noticesMapper.selectTotalCount(searchMap);

        int limit = 10;
        int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

        List<NoticesDTO> noticesList = noticesMapper.selectNoticesList(selectCriteria);

        Map<String, Object> noticesListAndPaging = new HashMap<>();
        noticesListAndPaging.put("paging", selectCriteria);
        noticesListAndPaging.put("boardList", noticesList);

        return noticesListAndPaging;
    }
}
