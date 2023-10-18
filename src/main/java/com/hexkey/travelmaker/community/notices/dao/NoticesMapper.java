package com.hexkey.travelmaker.community.notices.dao;

import com.hexkey.travelmaker.common.zeesang.paging.SelectCriteria;
import com.hexkey.travelmaker.community.notices.dto.NoticesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticesMapper {

    List<NoticesDTO> selectNotices(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);

    NoticesDTO selectNoticesDetail(Long no);

    void insertNotices(NoticesDTO notices);

    int deleteNotices( List<Integer> code);

    void updateNotices(NoticesDTO notices);

    void aaa(Long no);
}
