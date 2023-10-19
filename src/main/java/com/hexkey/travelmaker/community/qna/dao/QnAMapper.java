package com.hexkey.travelmaker.community.qna.dao;

import com.hexkey.travelmaker.common.zeesang.paging.SelectCriteria;
import com.hexkey.travelmaker.community.notices.dto.NoticesDTO;
import com.hexkey.travelmaker.community.qna.dto.QnADTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QnAMapper {
    int selectTotalCount(Map<String, String> searchMap);

    List<QnADTO> selectQnA(SelectCriteria selectCriteria);

    QnADTO selectQnADetail(Long no);
}
