package org.mnu.service;

import org.apache.ibatis.annotations.Param;
import org.mnu.domain.MemberDTO;

public interface MemberService {

    // 로그인 처리
    public MemberDTO member_login(String member_id, String member_password);
}