package org.mnu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mnu.domain.MemberVO;
import org.mnu.domain.QuestionVO;
import org.mnu.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/question/*")
public class QuestionController {

    private final QuestionService service;
    /**
     * @brief 문제 리스트 페이지
     * @details 문제 리스트 페이지
     */
    @GetMapping("/list")
    public String list(RedirectAttributes rttr, @RequestParam String id) {
        List<QuestionVO> qvo = service.getListWriter(id);

        rttr.addFlashAttribute("Question",qvo);

        return "redirect:/question/mypageQuestion";
    }

    /**
     * @brief 문제 수정 페이지
     * @details 문제의 정보를 수정할 수 있는 페이지를 보여준다.
     */
    @GetMapping("/modify")
    public void modify() {

    }

    /**
     * @brief 문제 수정 처리 페이지
     * @details 입력한 정보를 DB에 반영하여 정보를 수정한다.
     */
    @PostMapping("/modify")
    public String modify(RedirectAttributes rttr) {
        return "redirect:/question/list";
    }

    /**
     * @brief 문제 삭제 처리 페이지
     * @details 문제를 삭제하고 문제 리스트 페이지로 리다이렉트한다.
     */
    @GetMapping("/remove")
    public String remove(RedirectAttributes rttr) {
        return "redirect:/question/list";
    }

    /**
     * @brief 시험 시작 설정 페이지
     * @details 시험에 필요한 문제를 선택하는 페이지
     */
    @GetMapping("/exam/config")
    public void examConfig() {

    }

    /**
     * @brief 시험 페이지
     * @details 문제를 골라서 시험을 보는 페이지
     */
    @GetMapping("/exam/progress")
    public void examProgress() {

    }

    /**
     * @brief 채점 처리
     * @details 채점 처리
     */
    @PostMapping("/exam/grading")
    public void examGrading() {

    }

    /**
     * @brief 시험 결과 페이지
     * @details 시험 결과 페이지
     */
    @GetMapping("/exam/result")
    public void examResult() {

    }
}
