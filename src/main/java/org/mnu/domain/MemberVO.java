package org.mnu.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
public class MemberVO {
    private int member_no;
    private String member_id;
    private String member_password;
    private String member_name;
    private String member_email;
    private String member_authority;
}