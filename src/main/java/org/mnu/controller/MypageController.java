package org.mnu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mnu.domain.QuestionVO;
import org.mnu.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    /*** @brief 마이페이지 문제관리 페이지 */
    @GetMapping("/mypageQuestion")
    public String mypageQuestion(Model model,@RequestParam String id) {
        List<QuestionVO> qvo = service.getListWriter(id);
        model.addAttribute("Question",qvo);
        return "mypage/mypageQuestion";
    }

    /*** @brief 마이페이지 정보수정 페이지 */
    @GetMapping("/mypageModify")
    public String mypageModify() {
        return "mypage/mypageModify";
    }

    /*** @brief 마이페이지 시험결과 페이지 */
    @GetMapping("/mypageResult")
    public String mypageResult() {
        return "mypage/mypageResult";
    }

    /*** @brief 나의 문제 리스트 상세 페이지 */
    @GetMapping("/questionListDetail")
    public String detail(Model model,@RequestParam Long qno){
        QuestionVO vo = service.get(qno,"w");
        model.addAttribute("vo",vo);
        return "mypage/mypageQuestionDetail";
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
}
