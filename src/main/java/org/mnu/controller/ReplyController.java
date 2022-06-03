package org.mnu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.mnu.domain.BoardVO;
import org.mnu.domain.Criteria;
import org.mnu.domain.PageDTO;
import org.mnu.domain.ReplyPageDTO;
import org.mnu.domain.ReplyVO;
import org.mnu.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/reply")
@Controller
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;
	
	
//	@PostMapping("/listRegister")
//	public String register(BoardVO board, RedirectAttributes rttr) {
//		log.info("listRegister: " + board);
//		service.register(board);
//		rttr.addFlashAttribute("result", board.getBno());
//		return "redirect:/board/list";
//	}

	
	@PostMapping("/new")
	public String create(Model model, ReplyVO vo, @ModelAttribute("cri") Criteria cri) {
		service.register(vo);

		return "redirect:/board/get?bno=" + vo.getBno()
		+ "&pageNum=" + cri.getPageNum()
		+ "&amount=" + cri.getAmount();
	}
	
	@PostMapping("/modify")
	public String modify(Model model, ReplyVO vo, @ModelAttribute("cri") Criteria cri) {
		service.modify(vo);
		
		return "redirect:/board/get?bno=" + vo.getBno()
		+ "&pageNum=" + cri.getPageNum()
		+ "&amount=" + cri.getAmount();
	}
	
	@PostMapping("/remove")
	public String remove(Model model, ReplyVO vo, @ModelAttribute("cri") Criteria cri) {
		service.remove(vo.getRno());
		
		return "redirect:/board/get?bno=" + vo.getBno()
		+ "&pageNum=" + cri.getPageNum()
		+ "&amount=" + cri.getAmount();
	}
	
	
//	@GetMapping("/list")
//	public String list(Model model, @RequestParam("bno") Long bno) {
//		model.addAttribute("lists", service.getList(bno));
//		
//		return "/board/get?bno=" + bno;
//	}
	
//	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
//	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
//
//		log.info("ReplyVO: " + vo);
//
//		int insertCount = service.register(vo);
//
//		log.info("Reply INSERT COUNT: " + insertCount);
//
//		return insertCount == 1  
//				?  new ResponseEntity<>("success", HttpStatus.OK)
//				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}

//	@GetMapping(value = "/{rno}", 
//			produces = { MediaType.APPLICATION_XML_VALUE, 
//					     MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
//
//		log.info("get: " + rno);
//
//		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
//	}
//
//	@RequestMapping(method = { RequestMethod.PUT,
//			RequestMethod.PATCH }, value = "/{rno}", consumes = "application/json", produces = {
//					MediaType.TEXT_PLAIN_VALUE })
//	public ResponseEntity<String> modify(
//			 @RequestBody ReplyVO vo, 
//			 @PathVariable("rno") Long rno) {
//
//		vo.setRno(rno);
//
//		log.info("rno: " + rno);
//		log.info("modify: " + vo);
//
//		return service.modify(vo) == 1 
//				? new ResponseEntity<>("success", HttpStatus.OK)
//				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//
//	}
//
//	@DeleteMapping(value = "/{rno}", produces = { MediaType.TEXT_PLAIN_VALUE })
//	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
//
//		log.info("remove: " + rno);
//
//		return service.remove(rno) == 1 
//				? new ResponseEntity<>("success", HttpStatus.OK)
//				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//
//	}
//
//	
////	@GetMapping(value = "/pages/{bno}/{page}", produces = {
////	 MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
////	 public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {
////		log.info("getList................."); Criteria cri = new Criteria(page,10);
////		log.info(cri);
////		return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK); 
////	 }
//	
//
//	@GetMapping(value = "/pages/{bno}/{page}", 
//			produces = { MediaType.APPLICATION_XML_VALUE,
//			MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {
//		Criteria cri = new Criteria(page, 10);
//		log.info("get Reply List bno: " + bno);
//		log.info("cri:" + cri);
//		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
//	}

}

