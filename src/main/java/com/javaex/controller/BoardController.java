package com.javaex.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	// 필드
	@Autowired
	private BoardService boardService;

	// 게시판 리스트+검색
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model,
					   @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
		System.out.println("BoardController >> list()");

		List<BoardVo> bList = boardService.getBoardList(keyword);
		System.out.println(bList);

		model.addAttribute("gList", bList);

		return "board/list";
	}

	// 리스트(일반)
	@RequestMapping(value = "/list2", method = { RequestMethod.GET, RequestMethod.POST })
		public String list2(Model model, 
							@RequestParam(value="crtPage", required = false, defaultValue = "1") int crtPage) {
		System.out.println("BoardController >> list2()");
		
		Map<String,Object> pMap = boardService.getBoardList2(crtPage);
		model.addAttribute("pMap", pMap);
		
		System.out.println("controller --> " + pMap);

		
		return "board/list2";
	}

	// 게시판 등록폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm(HttpSession session) {
		System.out.println("BoardController >> writeForm()");
	
			return "board/writeForm";
		
	}

	// 게시판 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController >> write()");

		int count = boardService.insert(boardVo);

		System.out.println("BoardController: " + count);

		return "redirect:/board/list";
	}

	// 게시판 삭제
	@RequestMapping(value = "/delete/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@PathVariable("no") int no) {
		System.out.println("BoardController >> delete()");

		// Dao로 삭제하기
		boardService.delete(no);

		return "redirect:/board/list";
	}

	// 게시판 읽기
	@RequestMapping(value = "/read/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(@PathVariable("no") int no, Model model) {
		System.out.println("BoardController >> read()");
		;

		BoardVo boardVo = boardService.read(no);
		model.addAttribute("boardVo", boardVo);

		return "board/read";
	}

	// 게시판 수정폼
	@RequestMapping(value = "/modifyForm/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@PathVariable("no") int no, Model model) {
		System.out.println("BoardController >> modifyForm()");

		BoardVo boardVo = boardService.read(no);
		model.addAttribute("boardVo", boardVo);

		return "board/modifyForm";
	}

	// 게시판 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController >> modify()");

		boardService.modify(boardVo);

		return "redirect:/board/list";
	}

}
