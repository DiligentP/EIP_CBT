package org.mnu.mapper;

import org.apache.ibatis.annotations.Select;
import org.mnu.domain.BoardVO;
import org.mnu.domain.Criteria;

import java.util.List;

public interface BoardMapper {
    public List<BoardVO> getList();
    
    public List<BoardVO> getListWithPaging(Criteria cri);

    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board);

    public BoardVO read(Long bno);

    int delete(Long bno);

    int update(BoardVO board);
}
