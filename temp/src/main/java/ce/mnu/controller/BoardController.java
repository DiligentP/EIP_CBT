package ce.mnu.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import ce.mnu.service.*;
import ce.mnu.domain.*;

/**
 * 
 * @author DreStar
 * @brief 게시판 관련 주소 처리
 * @details 게시판에 접근하는 url request를 처리한다.
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	private BoardService service;
	
	/**
	 * @brief 게시글 목록 페이지
	 * @details /board/list로 접근시 게시글 목록 페이지를 보여준다.
	 * 
	 * @param cri 검색관련 정보
	 * @param model 모델
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
	
	/**
	 * @brief 게시글 작성 페이지
	 * @details /board/write로 접근시 게시글 작성 페이지를 보여준다.
	 */
	@GetMapping("/write")
	public void write() {

	}

	/**
	 * @brief 게시글 작성 처리 페이지
	 * @details 작성한 글을 DB에 추가하고 작성한 글을 보여준다.
	 */
	@PostMapping("/write")

	public String write(BoardVO board, RedirectAttributes rttr) {
		log.info("==========================");
		log.info("register: " + board);

		if (board.getAttachList() != null)
			board.getAttachList().forEach(attach -> log.info(attach));

		log.info("==========================");

		service.write(board);

		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list";
	}

	/**
	 * @brief 게시글 정보 얻기
	 * @details 게시글 정보 얻기
	 */
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}

	/**
	 * @brief 게시글 수정
	 * @details 게시글 수정
	 * 
	 * @param board 게시글 정보
	 * @param cri   페이지 정보
	 * @param rttr  리다이렉트
	 * @return 게시글 리스트 페이지
	 */
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/board/list" + cri.getListLink();
	}
	
	/**
	 * @brief 게시글 삭제
	 * @details 게시글 삭제
	 * 
	 * @param bno 게시글 번호(파라미터)
	 * @param cri 페이지 정보
	 * @param rttr 리다이렉트
	 * @param writer 작성자
	 * @return 게시글 리스트 페이지
	 */
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr, String writer) {
		log.info("remove..." + bno);

		List<AttachVO> attachList = service.getAttachList(bno);

		if (service.remove(bno)) {
			// delete Attach Files
			deleteFiles(attachList);

			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list" + cri.getListLink();
	}

	/**
	 * @brief 파일들 삭제
	 * @details 파일들 삭제
	 * 
	 * @param attachList 파일 정보 리스트
	 */
	private void deleteFiles(List<AttachVO> attachList) {
		if (attachList == null || attachList.size() == 0) {
			return;
		}

		log.info("delete attach files...................");
		log.info(attachList);

		attachList.forEach(attach -> {
			try {
				Path file = Paths.get(
						"C:\\upload\\" + attach.getUploadPath() + "\\" + attach.getUuid() + "_" + attach.getFileName());

				Files.deleteIfExists(file);

				if (Files.probeContentType(file).startsWith("image")) {

					Path thumbNail = Paths.get("C:\\upload\\" + attach.getUploadPath() + "\\s_" + attach.getUuid() + "_"
							+ attach.getFileName());

					Files.delete(thumbNail);
				}

			} catch (Exception e) {
				log.error("delete file error" + e.getMessage());
			} // end catch
		});// end foreachd
	}

	/**
	 * @brief 파일 정보 리스트 받기
	 * @details 파일 정보 리스트 받기
	 * 
	 * @param bno 게시글 번호
	 * @return 파일 정보 리스트
	 */
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachVO>> getAttachList(Long bno) {

		log.info("getAttachList " + bno);

		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
	}
}