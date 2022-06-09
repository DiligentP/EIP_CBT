package org.mnu.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mnu.domain.QuestionResultVO;
import org.mnu.domain.QuestionVO;
import org.mnu.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author DreStar
 * @brief 문제 처리
 * @details 문제 DB 처리
 * @date 2022/05/25
 * @version 0.0.1
 *
 */

@Service
@Log4j
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionMapper mapper;

    /**
     * @brief 문제 생성
     * @details 문제 DB에 추가한다.
     *
     * @param vo 문제
     */
    @Transactional
    @Override
    public int create(QuestionVO vo) {
        log.info("register......" + vo);

        return mapper.insert(vo);
    }

    /**
     * @brief 문제 정보 얻기
     * @details qno로 문제 정보를 DB에서 받아온다.
     *
     * @param qno 문제 번호
     * @return QuestionVO 문제 정보
     */
    @Override
    public QuestionVO get(Long qno, String division) {
        log.info("get......" + qno);

        return mapper.get(qno,division);
    }

    /**
     * @brief 문제 수정
     * @details 사용자가 입력한 정보로 기존의 문제 정보를 수정한다.
     *
     * @param vo 회원 정보
     * @return int
     */
    @Override
    public int modify(QuestionVO vo) {
        log.info("modify......" + vo);

        return mapper.update(vo);
    }

    /**
     * @brief 문제 삭제
     * @details qno로 문제를 삭제한다.
     *
     * @param qno 문제 번호
     * @return int
     */
    @Transactional
    @Override
    public int remove(Long qno) {
        log.info("remove...." + qno);

        return mapper.delete(qno);
    }

    /**
     * @details 문제 리스트를 DB에서 받아온다.
     */
    @Override
    public List<QuestionVO> getList() {
        return mapper.getList();
    }

    /**
     * @details 해당 계정의 문제 리스트를 DB에서 받아온다.
     */
    public List<QuestionVO> getListWriter(String writer){
        return mapper.getListWriter(writer);
    }

    /**
     * @details 문제의 총 갯수를 받아온다.
     */
    public int getCount(String division){
        return mapper.getCount(division);
    }

    public int createResult(QuestionResultVO vo){
        return mapper.insertResult(vo);
    }

    public List<QuestionResultVO> getResultList(String id){
        return mapper.getResultList(id);
    }
}