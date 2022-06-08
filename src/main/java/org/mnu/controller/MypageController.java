package org.mnu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mnu.domain.MemberVO;
import org.mnu.domain.QuestionVO;
import org.mnu.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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
     * @brief 문제 수정 처리 페이지
     * @details 입력한 정보를 DB에 반영하여 정보를 수정한다.
     */
    @PostMapping("/questionModify")
    public String modify(@RequestParam Long qno, @RequestParam String title, @RequestParam String content1, @RequestParam String content2,
                         @RequestParam String content3, @RequestParam String content4, @RequestParam String answer, @RequestParam String comment,
                         @RequestParam String sessionId) {
        QuestionVO vo = service.get(qno,"w");
        vo.setTitle(title);
        vo.setContent1(content1);
        vo.setContent2(content2);
        vo.setContent3(content3);
        vo.setContent4(content4);
        vo.setAnswer(answer);
        vo.setComment(comment);

        log.info("--------------------------------------------------");
        log.info(vo);
        log.info("--------------------------------------------------");

        int result = service.modify(vo);

        //session.getAttribute("login_info");

        if(result == 1){
            return "redirect:/mypage/mypageQuestion?id="+sessionId;
        }

        return "/Error";
    }
}
