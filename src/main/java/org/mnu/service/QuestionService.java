package org.mnu.service;

import org.mnu.domain.ExamOption;
import org.mnu.domain.QuestionVO;

import java.util.List;

public interface QuestionService {
    public void create(QuestionVO vo);

    public QuestionVO get(Long qno);

    public int modify(QuestionVO vo);

    public int remove(Long qno);

    public List<QuestionVO> getList(ExamOption opt);
}