package org.mnu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mnu.domain.QuestionVO;
import org.mnu.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {

    private final QuestionService service;

    @GetMapping("/")
    public String mypageIndex() {
        return "mypage/mypage";
    }
    /**
     * @brief 마이페이지 문제 관리
     */
    @GetMapping("/mypageQuestion")
    public String mypageQuestion() {
        return "mypage/mypageQuestion";
    }
    @GetMapping("/mypageModify")
    public String mypageModify() {
        return "mypage/mypageModify";
    }
    @GetMapping("/mypageResult")
    public String mypageResult() {
        return "mypage/mypageResult";
    }

    /**
     * @brief 나의 문제 리스트 페이지
     */
    @GetMapping("/questionList")
    public String list(RedirectAttributes rttr, @RequestParam String id) {
        List<QuestionVO> qvo = service.getListWriter(id);

        rttr.addFlashAttribute("Question",qvo);

        return "redirect:/mypage/mypageQuestion";
    }

    /**
     * @brief 나의 문제 리스트 상세 페이지
     */
    @GetMapping("/questionListDetail")
    public String detail(@RequestParam Long qno){
        log.info("-------------------------------");
        log.info("qno : " + qno);
        log.info("-------------------------------");
        return "mypage/mypageQuestionDetail";
    }
}
