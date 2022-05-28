package ce.mnu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ce.mnu.domain.*;
import ce.mnu.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


/**
 * 
 * @author DreStar
 * @brief 문제 관련 주소 처리
 * @details 문제와 관련된 주소에 접근하는 request를 처리한다.
 * @date 2022/05/25
 * @version 0.0.1
 *
 */

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/question/*")
public class QuestionController {
	QuestionService service;
	
	/**
	 * @brief 문제 리스트 페이지
	 * @details 문제 리스트 페이지
	 */
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {

		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		// model.addAttribute("pageMaker", new PageDTO(cri, 123));

		int total = service.getTotal(cri);

		log.info("total: " + total);

		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}
	
	@GetMapping("/write")
	public void write() {
		
	}
	
	@PostMapping("/write")
	public String write(QuestionVO question, RedirectAttributes rttr) {
		log.info("==========================");
		log.info("register: " + question);

		if (question.getAttachList() != null)
			question.getAttachList().forEach(attach -> log.info(attach));

		log.info("==========================");

		service.write(question);

		rttr.addFlashAttribute("result", question.getQno());

		return "redirect:/question/list";
	}
	
	/**
	 * @brief 문제 정보 얻기
	 * @details 문제 정보 얻기
	 */
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("qno") Long qno, @ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("question", service.get(qno));
	}
	
	/**
	 * @brief 문제 수정
	 * @details 문제 수정
	 * 
	 * @param question 문제 정보
	 * @param cri   페이지 정보
	 * @param rttr  리다이렉트
	 * @return 게시글 리스트 페이지
	 */
	@PostMapping("/modify")
	public String modify(QuestionVO question, Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + question);

		if (service.modify(question)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/question/list" + cri.getListLink();
	}
	
	/**
	 * @brief 문제 삭제
	 * @details 문제 삭제
	 * 
	 * @param qno 게시글 번호(파라미터)
	 * @param cri 페이지 정보
	 * @param rttr 리다이렉트
	 * @param writer 작성자
	 * @return 문제 리스트 페이지
	 */
	@PostMapping("/remove")
	public String remove(@RequestParam("qno") Long qno, Criteria cri, RedirectAttributes rttr, String writer) {
		log.info("remove..." + qno);

		/*
		List<AttachVO> attachList = service.getAttachList(bno);

		if (service.remove(bno)) {
			// delete Attach Files
			deleteFiles(attachList);

			rttr.addFlashAttribute("result", "success");
		}
		*/
		
		//CASCADE라 파일 다 삭제됨
		if (service.remove(qno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/question/list" + cri.getListLink();
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
	
	/**
	 * @brief 파일 정보 리스트 받기
	 * @details 파일 정보 리스트 받기
	 * 
	 * @param qno 문제 번호
	 * @return 파일 정보 리스트
	 */
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachVO>> getAttachList(Long qno) {

		log.info("getAttachList " + qno);

		return new ResponseEntity<>(service.getAttachList(qno), HttpStatus.OK);
	}
}