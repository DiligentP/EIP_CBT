package org.mnu.service;

import org.mnu.domain.QuestionResultVO;
import org.mnu.domain.QuestionVO;

import java.util.List;

public interface QuestionService {
    public int create(QuestionVO vo);

    public QuestionVO get(Long qno,String division);

    public int modify(QuestionVO vo);

    public int remove(Long qno);

    public List<QuestionVO> getList();
    public List<QuestionVO> getListWriter(String writer);
    public int getCount(String division);

    public int createResult(QuestionResultVO vo);

    public List<QuestionResultVO> getResultList(String id);
}