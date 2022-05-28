package ce.mnu.service;

import java.util.List;

import ce.mnu.domain.*;

/**
 * 
 * @author DreStar
 * @brief 댓글 처리
 * @details 댓글 처리
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

public interface ReplyService {

	public int write(ReplyVO vo);

	public ReplyVO get(Long rno);

	public int modify(ReplyVO vo);

	public int remove(Long rno);

	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);

}
