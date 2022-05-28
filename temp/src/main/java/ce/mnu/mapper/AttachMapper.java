package ce.mnu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ce.mnu.domain.*;

public interface AttachMapper {

	public void insert(AttachVO vo);

	public void delete(@Param("boardName") String boardName, @Param("uuid") String uuid);

	public List<AttachVO> findByBno(@Param("boardName") String boardName, @Param("bno") Long bno);

	public void deleteAll(@Param("boardName") String boardName, @Param("bno") Long bno);

	public List<AttachVO> getOldFiles();

}