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
 * @brief 회원 처리
 * @details 회원 DB 처리
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

@Service
@Log4j
public class MemberServiceImpl implements MemberService {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;

	/**
	 * @brief 회원가입
 	 * @details 회원을 DB에 추가한다.
 	 * 
 	 * @param MemberVO vo 회원 정보
 	 * @return int 
	 */
	@Transactional
	@Override
	public void register(MemberVO vo) {
		log.info("register......" + vo);

		mapper.insert(vo);
	}

	/**
	 * @brief 회원 정보 얻기
 	 * @details id로 회원 정보를 DB에서 받아온다.
 	 * 
 	 * @param userid 유저ID
 	 * @return ReplyVO 댓글 정보
	 */
	@Override
	public MemberVO get(String userid) {
		log.info("get......" + userid);

		return mapper.read(userid);
	}

	/**
	 * @brief 회원 수정
 	 * @details 사용자가 입력한 정보로 기존의 회원 정보를 수정한다.
 	 * 
 	 * @param vo 회원 정보
 	 * @return int
	 */
	@Override
	public int modify(MemberVO vo) {
		log.info("modify......" + vo);

		return mapper.update(vo);
	}

	/**
	 * @brief 회원 탈퇴
 	 * @details id로 회원을 탈퇴한다.
 	 * 
 	 * @param userid 아이디
 	 * @return int
	 */
	@Transactional
	@Override
	public int remove(String userid) {
		log.info("remove...." + userid);

		return mapper.delete(userid);
	}

	/**
	 * @brief 회원 리스트 받기
 	 * @details 회원 리스트를 DB에서 받아온다.
 	 * 
 	 * @return List<MemberVO> 회원 리스트
	 */
	@Override
	public List<MemberVO> getList() {
		log.info("get Member List");

		return mapper.getList();
	}
}
