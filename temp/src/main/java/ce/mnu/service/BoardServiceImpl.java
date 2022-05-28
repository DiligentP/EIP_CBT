package ce.mnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ce.mnu.domain.*;
import ce.mnu.mapper.*;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * 
 * @author DreStar
 * @brief 게시판 처리
 * @details 게시판 DB 처리
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

@Log4j
@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private AttachMapper attachMapper;

	/**
	 * @brief 게시글 작성 처리
	 * @details 게시글 정보를 받아서 DB에 추가한다.
	 * 파일이 있다면 파일도 DB에 추가한다.
	 */
	@Transactional
	@Override
	public void write(BoardVO board) {
		log.info("write......" + board);

		mapper.insertSelectKey(board);

		if (board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}

		//파일 개수만큼 DB에 추가
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			attach.setBoardName("Board");
			attachMapper.insert(attach);
		});
	}

	/**
	 * @brief 게시글 정보 받기
	 * @details 게시글 정보를 DB에서 받아온다.
	 * 
	 * @return BoardVO
	 */
	@Override
	public BoardVO get(Long bno) {

		log.info("get......" + bno);

		return mapper.read(bno);

	}

	/**
	 * @brief 게시글 수정
	 * @details 게시글 정보를 받고 기존의 정보를 수정한다.
	 * 
	 * @return boolean
	 * 성공시 true / 실패시 false
	 */
	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify......" + board);

		//파일 삭제함
		attachMapper.deleteAll("Board", board.getBno());

		boolean modifyResult = mapper.update(board) == 1;
		
		//파일이 있으면 파일 처리
		if (modifyResult && board.getAttachList() != null && board.getAttachList().size() > 0) {
			board.getAttachList().forEach(attach -> {

				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}

		return modifyResult;
	}

	/**
	 * @brief 게시글 삭제
	 * @details 게시글 번호로 DB의 게시글을 삭제한다.
	 * 
	 * @return boolean
	 * 성공시 true / 실패시 false
	 */
	@Transactional
	@Override
	public boolean remove(Long bno) {
		log.info("remove...." + bno);

		attachMapper.deleteAll("Board", bno);

		return mapper.delete(bno) == 1;
	}

	/**
	 * @brief 게시글 리스트
	 * @details 게시글 리스트를 DB에서 받아온다.
	 * 
	 * @param cri 페이지 정보
	 * @return List<BoardVO>
	 * 게시글의 정보 리스트
	 */
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with criteria: " + cri);

		return mapper.getListWithPaging(cri);
	}

	/**
	 * @brief 총 게시글 개수
	 * @details 총 게시글 개수를 DB에서 받아온다.
	 * 
	 * @param cri 페이지 정보
	 * @return int
	 * 총 게시글 개수
	 */
	@Override
	public int getTotal(Criteria cri) {

		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	/**
	 * @brief 게시글에 있는 파일 리스트 받기
	 * @details 게시글에 있는 파일 리스트 받기
	 * 
	 * @param Long bno 게시글 번호
	 * @return List<BoardAttachVO>
	 * 파일 리스트
	 */
	@Override
	public List<AttachVO> getAttachList(Long bno) {

		log.info("get Attach list by bno" + bno);

		return attachMapper.findByBno("Board", bno);
	}
}
