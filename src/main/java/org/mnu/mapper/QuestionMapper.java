package org.mnu.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mnu.domain.QuestionResultVO;
import org.mnu.domain.QuestionVO;

import java.util.List;

public interface QuestionMapper {
    public QuestionVO get(@Param("qno")Long qno, @Param("division")String division);

    public int insert(QuestionVO user);

    public int delete(Long qno);

    public int update(QuestionVO user);

    public List<QuestionVO> getList();

    public List<QuestionVO> getListWriter(String writer);
    
    
    // division : 문제 종류 w=필기 p=실기
    public int getCount(String division);


    public List<QuestionResultVO> getResultList(String id);

    public int insertResult(QuestionResultVO vo);
}
