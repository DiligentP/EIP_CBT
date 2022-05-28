package ce.mnu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ce.mnu.domain.*;

public interface QuestionMapper {
	public QuestionVO get(Long qno);
	
	public ExamResultVO getResultVO(Long qno);
	
	public Integer insertSelectKey(QuestionVO vo);
	
	public void insert(QuestionVO vo);
	
	public int delete(Long qno);

	public int update(QuestionVO vo);
	
	public List<QuestionVO> getListWithOption(ExamOption opt);
	
	public List<QuestionVO> getList();
	
	public int getTotalCount(Criteria cri);
	
	public List<QuestionVO> getListWithPaging(Criteria cri);
	
	public int increasePeople(ExamResultVO vo);
}
