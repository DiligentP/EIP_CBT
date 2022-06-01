package org.mnu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mnu.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface MemberMapper {
    
    // 아이디와 패스워드가 일치한 유저 한명을 데이터베이스에서 조회
    public MemberVO getUserOne(@Param("member_id") String member_id, @Param("member_password")String member_password);

    // 새로운 유저 한명의 데이터를 데이터베이스에 생성
    public int insertUserOne(MemberVO vo);

    // 중복된 유저의 아이디가 있는지 조회
    public int selectUserId(@Param("id")String id);
}
