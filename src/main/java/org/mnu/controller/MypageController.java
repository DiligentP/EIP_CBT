package org.mnu.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {

    /**
     * @brief 마이페이지 문제 관리
     */
    @GetMapping("/mypageQuestion")
    public String mypageQuestion() {
        return "mypageQuestion";
    }
    @GetMapping("/mypageModify")
    public String mypageModify() {
        return "mypageModify";
    }
    @GetMapping("/mypageResult")
    public String mypageResult() {
        return "mypageResult";
    }
}
