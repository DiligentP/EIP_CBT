package org.mnu.mapper;

import org.apache.ibatis.annotations.Param;
import org.mnu.domain.BoardVO;
import org.mnu.domain.MemberDTO;

import java.util.List;

public interface MemberMapper {
    
    // 아이디와 패스워드가 일치한 유저 한명을 조회
    public MemberDTO getUserOne(@Param("member_id") String member_id, @Param("member_password")String member_password);
}
