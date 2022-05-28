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
 * @brief 문제 처리
 * @details 문제 DB 처리
 * @date 2022/05/25
 * @version 0.0.1
 *
 */

@Service
@Log4j
public class QuestionServiceImpl implements QuestionService {
	@Setter(onMethod_ = @Autowired)
	private QuestionMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private AttachMapper attachMapper;

	/**
	 * @brief 문제 작성
 	 * @details 문제 DB에 추가한다.
 	 * 
 	 * @param vo 문제
	 */
	@Transactional
	@Override
	public void write(QuestionVO vo) {
		log.info("write......" + vo);

		mapper.insertSelectKey(vo);

		if (vo.getAttachList() == null || vo.getAttachList().size() <= 0) {
			return;
		}

		//파일 개수만큼 DB에 추가
		vo.getAttachList().forEach(attach -> {
			attach.setBno(vo.getQno());
			attach.setBoardName("Question");
			attachMapper.insert(attach);
		});
	}

	/**
	 * @brief 문제 정보 얻기
 	 * @details qno로 문제 정보를 DB에서 받아온다.
 	 * 
 	 * @param qno 문제 번호
 	 * @return QuestionVO 문제 정보
	 */
	@Override
	public QuestionVO get(Long qno) {
		log.info("get......" + qno);

		return mapper.get(qno);
	}

	/**
	 * @brief 문제 수정
 	 * @details 사용자가 입력한 정보로 기존의 문제 정보를 수정한다.
 	 * 
 	 * @param vo 회원 정보
 	 * @return int
	 */
	@Override
	public boolean modify(QuestionVO vo) {
		log.info("modify......" + vo);

		//파일 삭제함
		attachMapper.deleteAll("Question", vo.getQno());

		boolean modifyResult = mapper.update(vo) == 1;
		
		//파일이 있으면 파일 처리
		if (modifyResult && vo.getAttachList() != null && vo.getAttachList().size() > 0) {
			vo.getAttachList().forEach(attach -> {

				attach.setBno(vo.getQno());
				attach.setBoardName("Question");
				attachMapper.insert(attach);
			});
		}

		return modifyResult;
	}

	/**
	 * @brief 문제 삭제
 	 * @details qno로 문제를 삭제한다.
 	 * 
 	 * @param qno 문제 번호
 	 * @return int
	 */
	@Transactional
	@Override
	public boolean remove(Long qno) {
		log.info("remove...." + qno);

		attachMapper.deleteAll("Question", qno);

		return mapper.delete(qno) == 1;
	}

	/**
	 * @brief 문제 리스트 받기
 	 * @details 문제 리스트를 DB에서 받아온다.
 	 * 
 	 * @param opt 시험 옵션
 	 * @return List<QuestionVO> 문제 리스트
	 */
	@Override
	public List<QuestionVO> getList(Criteria cri) {
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
	 * @param Long qno 게시글 번호
	 * @return List<AttachVO>
	 * 파일 리스트
	 */
	@Override
	public List<AttachVO> getAttachList(Long qno) {
		log.info("get Attach list by qno" + qno);

		return attachMapper.findByBno("Question", qno);
	}
	
}
