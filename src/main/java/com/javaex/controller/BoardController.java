package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.service.UserService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	// 필드
	@Autowired
	private BoardService boardService;

	// 생성자

	// 메소드 gs

	// 메소드 일반

	// 게시판 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("BoardController >> list()");

		// Service를 통해서 gList(주소)를 가져온다
		List<BoardVo> bList = boardService.getBoardList();
		System.out.println(bList);

		// ds 데이터보내기 --> request attribute에 넣는다
		model.addAttribute("gList", bList);

		return "board/list";
	}

	//게시판 등록폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm(HttpSession session) {
		System.out.println("BoardController >> writeForm()");
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
				if(authUser != null) {	//로그인o
					session.setAttribute("authUser", authUser);
					 return "board/writeForm";
				}
				else {	//로그인x
					return "user/loginForm";		 
				}
		
		
	}
	
	//게시판 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
		public String write(@ModelAttribute BoardVo boardVo) {
			System.out.println("BoardController >> write()");
												
			int count = boardService.insert(boardVo);
			
			System.out.println("BoardController: " + count);
			
			return "redirect:/board/list";
		}
	
	
}
