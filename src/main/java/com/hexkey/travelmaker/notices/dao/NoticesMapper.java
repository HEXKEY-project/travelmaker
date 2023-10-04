package com.hexkey.travelmaker.notices.dao;

import com.hexkey.travelmaker.common.paging.SelectCriteria;
import com.hexkey.travelmaker.notices.dto.NoticesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticesMapper {
    int selectTotalCount(Map<String, String> searchMap);

    List<NoticesDTO> selectNoticesList(SelectCriteria selectCriteria);
}
