package com.hexkey.travelmaker.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ReviewAttachDTO {

    private Long fileCode;
    private String fileType;
    private String originalName;
    private String savedName;
    private String savePath;
    private Long noticeCode;
    private Long productSeq;
    private Long reviewCode;
    private Long qnaCode;
    private String filePath;

}
