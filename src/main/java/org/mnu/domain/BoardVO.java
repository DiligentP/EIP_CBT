package org.mnu.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {
    private Long bon;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updateDate;
}
