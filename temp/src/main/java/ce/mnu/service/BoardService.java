package ce.mnu.service;

import java.util.List;

import ce.mnu.domain.*;

/**
 * 
 * @author DreStar
 * @brief 게시판 처리
 * @details 게시판 처리
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

public interface BoardService {

	public void write(BoardVO board);

	public BoardVO get(Long bno);

	public boolean modify(BoardVO board);

	public boolean remove(Long bno);

	public List<BoardVO> getList(Criteria cri);

	//추가
	public int getTotal(Criteria cri);
	
	public List<AttachVO> getAttachList(Long bno);
	
	//spublic void removeAttach(Long bno);

}
