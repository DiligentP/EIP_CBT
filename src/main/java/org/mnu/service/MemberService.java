package org.mnu.service;

import org.apache.ibatis.annotations.Param;
import org.mnu.domain.MemberDTO;

public interface MemberService {

    // 로그인 처리
    public MemberDTO member_login(String member_id, String member_password);

    // 회원가입 처리
    public int member_register(MemberDTO dto);

    public int member_idcheck(String id);
}
