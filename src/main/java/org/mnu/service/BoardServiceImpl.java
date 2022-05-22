package org.mnu.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.List;

import org.mnu.domain.BoardVO;
import org.mnu.mapper.BoardMapper;
import org.springframework.stereotype.Service;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	//@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register......" + board);
		mapper.insertSelectKey(board);
	}
	
	@Override
	public BoardVO get(Long bno) {
		log.info("get......" + bno);
		return mapper.read(bno);
	}
	
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify......" + board);
		return mapper.update(board) == 1;
	}
	
	@Override
	public boolean remove(Long bno) {
		log.info("remove...." + bno);
		return mapper.delete(bno) == 1;
	}
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList..........");
		log.info("키키킥");
		return mapper.getList();
	}
}
