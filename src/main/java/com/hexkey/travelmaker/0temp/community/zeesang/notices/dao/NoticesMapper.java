package com.hexkey.travelmaker;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticesMapper {

    List<NoticesDTO> selectNotices(SelectCriteria selectCriteria);

    int selectTotalCount(Map<String, String> searchMap);
}
