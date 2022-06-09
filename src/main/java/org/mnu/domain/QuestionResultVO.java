package org.mnu.domain;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionResultVO {

    // 결과 번호
    private Long no;

    // 유저 이이디
    private String member_id;

    // 정답 갯수
    private int answer;

    // 총 푼 문제
    private int count;

    // 테스트 날짜
    private Date testdate;
}
