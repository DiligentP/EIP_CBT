package org.mnu.domain;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionVO {

    // 문제 번호
    private Long qno;

    // 문제 제목
    private String title;

    // 문제 내용
    private String content1;
    private String content2;
    private String content3;
    private String content4;
    
    // 문제 정답
    private String answer;

    // 문제 해설
    private String comment;

    // 작성자 닉네임
    private String writer;

    // 정답률
    private Float success;

    // 문제 생성 날짜
    private Date regdate;

    // 문제 수정 날짜
    private Date updateDate;

//    // 태그
//    private String[] tag;
    
    // 문제 관련 그림
    private String filepath;

    // 파일 구분 w:필기 p:실기
    private String division;
}

