package com.hexkey.travelmaker;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberRoleDTO {

    private int memberNo;
    private int authorityCode;
    // 권한 코드 별로 가지는 권한
    private com.hexkey.travelmaker.AuthorityDTO authority;

}
