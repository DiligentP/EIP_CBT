package ce.mnu.mapper;

import java.util.List;

import ce.mnu.domain.*;

public interface MemberMapper {
	public MemberVO read(String userid);
	
	public void insert(MemberVO user);
	
	public int delete(String userid);

	public int update(MemberVO user);
	
	public List<MemberVO> getList();
}
