package ce.mnu.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author DreStar
 * @brief 문제 VO
 * @details 정보전달을 위한 문제VO
 * @date 2022/05/25
 * @version 0.0.1
 *
 */

@Data
public class QuestionVO {

	private Long qno;
	private String title;
	private String content;
	private String correct;
	private String commentary;
	private String writer;
	private Integer total;
	private Integer successer;
	private Date regDate;
	private Date updateDate;

	private String questionTag;
	
	private List<AttachVO> attachList;
}
