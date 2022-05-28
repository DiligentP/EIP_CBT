package ce.mnu.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author DreStar
 * @brief 게시글 VO
 * @details 정보전달을 위한 게시글VO
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

@Data
public class BoardVO {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;

	private int replyCnt;

	private List<AttachVO> attachList;
}
