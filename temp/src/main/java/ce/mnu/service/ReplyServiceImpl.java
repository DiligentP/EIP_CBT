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
 * @brief 댓글 처리
 * @details 댓글 DB 처리
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	// @Override
	// public int register(ReplyVO vo) {
	//
	// log.info("register......" + vo);
	//
	// return mapper.insert(vo);
	//
	// }

	/**
	 * @brief 댓글 작성
 	 * @details 작성한 댓글 정보를 받아와서 DB에 추가한다.
 	 * 
 	 * @param ReplyVO vo 댓글 정보
 	 * @return int 댓글 번호
	 */
	@Transactional
	@Override
	public int write(ReplyVO vo) {
		log.info("register......" + vo);

		boardMapper.updateReplyCnt(vo.getBno(), 1);

		return mapper.insert(vo);
	}

	/**
	 * @brief 댓글 정보 얻기
 	 * @details 댓글 번호로 댓글 정보를 DB에서 받아온다.
 	 * 
 	 * @param Long rno 댓글 번호
 	 * @return ReplyVO 댓글 정보
	 */
	@Override
	public ReplyVO get(Long rno) {
		log.info("get......" + rno);

		return mapper.read(rno);
	}

	/**
	 * @brief 댓글 수정
 	 * @details 사용자가 입력한 댓글로 기존의 댓글을 수정한다.
 	 * 
 	 * @param ReplyVO 댓글 정보
 	 * @return int 댓글 번호
	 */
	@Override
	public int modify(ReplyVO vo) {
		log.info("modify......" + vo);

		return mapper.update(vo);
	}

	/**
	 * @brief 댓글 삭제
 	 * @details 댓글 번호로 댓글을 삭제한다. 댓글 개수를 1개 줄인다.
 	 * 
 	 * @param Long rno 댓글 번호
 	 * @return int 댓글 번호
	 */
	@Transactional
	@Override
	public int remove(Long rno) {
		log.info("remove...." + rno);

		ReplyVO vo = mapper.read(rno);

		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);
	}

	/**
	 * @brief 댓글 리스트 받기
 	 * @details 댓글 리스트를 DB에서 받아온다.
 	 * 
 	 * @param Criteria cri 페이지 정보
 	 * @param Long bno 게시글 번호
 	 * @return List<ReplyVO> 댓글 리스트
	 */
	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("get Reply List of a Board " + bno);

		return mapper.getListWithPaging(cri, bno);
	}

	/**
	 * @brief 댓글 리스트 + 총 댓글 수 받기
 	 * @details 댓글 리스트와 총 댓글 수를 DB에서 받아온다.
 	 * 
 	 * @param Criteria cri 페이지 정보
 	 * @param Long bno 게시글 번호
 	 * @return ReplyPageDTO 댓글 리스트와 총 댓글 수
	 */
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}
}
