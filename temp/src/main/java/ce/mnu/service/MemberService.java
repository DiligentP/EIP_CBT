package ce.mnu.service;

import java.util.List;

import ce.mnu.domain.*;

/**
 * 
 * @author DreStar
 * @brief 회원 처리
 * @details 회원 처리
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

public interface MemberService {
	public void register(MemberVO vo);

	public MemberVO get(String userid);

	public int modify(MemberVO vo);

	public int remove(String userid);

	public List<MemberVO> getList();
}
