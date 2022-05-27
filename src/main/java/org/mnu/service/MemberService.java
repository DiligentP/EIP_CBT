package org.mnu.service;

import org.apache.ibatis.annotations.Param;
import org.mnu.domain.MemberVO;

public interface MemberService {

    // 로그인 처리
    public MemberVO member_login(String member_id, String member_password);

    // 회원가입 처리
    public int member_register(MemberVO vo);

    public int member_idcheck(String id);
}
