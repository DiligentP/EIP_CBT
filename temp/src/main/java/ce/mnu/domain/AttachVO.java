package ce.mnu.domain;

import lombok.Data;

/**
 * 
 * @author DreStar
 * @brief 게시글 파일 VO
 * @details 게시글에 추가되는 파일들의 정보
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

@Data
public class AttachVO {

  private String uuid;
  private String uploadPath;
  private String fileName;
  private boolean fileType;
  
  private String boardName;
  private Long bno;
  
}
