package ce.mnu.service;

import java.util.List;

import ce.mnu.domain.*;

/**
 * 
 * @author DreStar
 * @brief 문제 처리
 * @details 문제 처리
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

public interface QuestionService {
	public void write(QuestionVO vo);

	public QuestionVO get(Long qno);

	public boolean modify(QuestionVO vo);

	public boolean remove(Long qno);

	public List<QuestionVO> getList(Criteria cri);
	
	//public List<QuestionVO> getList(ExamOption opt);
	
	public int getTotal(Criteria cri);
	
	public List<AttachVO> getAttachList(Long bno);
}
