package ce.mnu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import ce.mnu.domain.*;

public interface BoardMapper {

	public List<BoardVO> getList();

	public List<BoardVO> getListWithPaging(Criteria cri);

	public void insert(BoardVO board);

	public Integer insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO board);

	public int getTotalCount(Criteria cri);

	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	public List<AttachVO> findByBno(String boardName, Long bno);

}
 