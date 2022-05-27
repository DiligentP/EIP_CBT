package org.mnu.service;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.annotations.Param;
import org.mnu.domain.MemberVO;
import org.mnu.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Log4j
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper mapper;

    @Override
    public MemberVO member_login(String member_id, String member_password){

        return mapper.getUserOne(member_id, member_password);
    }

    @Override
    public int member_register(MemberVO vo){

        int result = mapper.insertUserOne(vo);

        return result;
    }

    @Override
    public int member_idcheck(String id){
        int result = mapper.selectUserId(id);

        return result;
    }
}
