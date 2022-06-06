package org.mnu.mapper;

import org.apache.ibatis.annotations.Select;
import org.mnu.domain.QuestionResultVO;
import org.mnu.domain.QuestionVO;

import java.util.List;

public interface QuestionMapper {
    public QuestionVO get(Long qno);

    public void insert(QuestionVO user);

    public int delete(Long qno);

    public int update(QuestionVO user);

    public List<QuestionVO> getList();

    public List<QuestionVO> getListWriter(String writer);

    public int getCount();

    public List<QuestionResultVO> getResultList();
}
