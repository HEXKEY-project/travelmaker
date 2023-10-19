package com.hexkey.travelmaker.community.qna.dto;

import com.hexkey.travelmaker.product.regist.dto.FileDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.user.dto.MemberInfoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class QnADTO {
    private long code;
    private String title;
    private String body;
    private String lockYN;
    private Date registeredDate;
    private ProductDTO productSeq;
    private MemberInfoDTO member;
    private Date modifiedDate;
    private Date deleteDate;
    private String statusYN;
    private long refQnACode;
    private int qnaType;
    private FileDTO fileList;
}
