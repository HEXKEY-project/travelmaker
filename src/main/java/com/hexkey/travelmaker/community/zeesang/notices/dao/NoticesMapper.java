package com.hexkey.travelmaker.community.zeesang.notices.dao;

import com.hexkey.travelmaker.common.zeesang.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;
import com.hexkey.travelmaker.community.zeesang.notices.dto.NoticesDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticesMapper {

    List<NoticesDTO> selectNotices(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);
}
