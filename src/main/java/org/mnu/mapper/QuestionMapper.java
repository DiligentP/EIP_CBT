package org.mnu.mapper;

import org.mnu.domain.QuestionVO;
import org.mnu.domain.ExamOption;

import java.util.List;

public interface QuestionMapper {
    public QuestionVO get(Long qno);

    public void insert(QuestionVO user);

    public int delete(Long qno);

    public int update(QuestionVO user);

    public List<QuestionVO> getList(ExamOption opt);
}
