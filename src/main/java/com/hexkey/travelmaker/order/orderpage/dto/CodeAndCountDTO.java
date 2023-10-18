package com.hexkey.travelmaker.order.orderpage.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter @Getter @ToString @NoArgsConstructor
public class CodeAndCountDTO {

    private int optionCode;
    private int count;
    private List<CodeAndCountDTO> codeAndCountList;

}
