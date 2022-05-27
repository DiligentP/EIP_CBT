package org.mnu.domain;

import lombok.Data;

@Data
public class MemberVO {
    private int member_no;
    private String member_id;
    private String member_password;
    private String member_name;
    private String member_email;
}