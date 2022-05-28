package org.mnu.service;

import lombok.extern.log4j.Log4j;
import org.mnu.domain.ExamOption;
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
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper mapper;

    /**
     * @brief 문제 생성
     * @details 문제 DB에 추가한다.
     *
     * @param vo 문제
     */
    @Transactional
    @Override
    public void create(QuestionVO vo) {
        log.info("register......" + vo);

        mapper.insert(vo);
    }

    /**
     * @brief 문제 정보 얻기
     * @details qno로 문제 정보를 DB에서 받아온다.
     *
     * @param qno 문제 번호
     * @return QuestionVO 문제 정보
     */
    @Override
    public QuestionVO get(Long qno) {
        log.info("get......" + qno);

        return mapper.get(qno);
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
     * @brief 문제 리스트 받기
     * @details 문제 리스트를 DB에서 받아온다.
     *
     * @param opt 시험 옵션
     * @return List<QuestionVO> 문제 리스트
     */
    @Override
    public List<QuestionVO> getList(ExamOption opt) {
        log.info("get Member List");

        return mapper.getList(opt);
    }
}