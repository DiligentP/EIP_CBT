package ce.mnu.domain;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author DreStar
 * @brief 댓글 VO
 * @details 정보전달을 위한 댓글 VO
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

@Data
public class ReplyVO {

  private Long rno;
  private Long bno;

  private String reply;
  private String replyer;
  private Date replyDate;
  private Date updateDate;

}
