package org.mnu.service;

import java.util.List;

import org.mnu.domain.Criteria;
import org.mnu.domain.ReplyPageDTO;
import org.mnu.domain.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO vo);

	public ReplyVO get(Long rno);

	public int modify(ReplyVO vo);

	public int remove(Long rno);
	
	public List<ReplyVO> getList(Long bno);

	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);

}
