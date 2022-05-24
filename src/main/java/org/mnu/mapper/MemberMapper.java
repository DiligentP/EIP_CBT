package org.mnu.mapper;

import org.apache.ibatis.annotations.Param;
import org.mnu.domain.BoardVO;
import org.mnu.domain.MemberDTO;

import java.util.List;

public interface MemberMapper {
    
    // 아이디와 패스워드가 일치한 유저 한명을 데이터베이스에서 조회
    public MemberDTO getUserOne(@Param("member_id") String member_id, @Param("member_password")String member_password);

    // 새로운 유저 한명의 데이터를 데이터베이스에 생성
    public boolean insertUserOne(MemberDTO dto);
}
