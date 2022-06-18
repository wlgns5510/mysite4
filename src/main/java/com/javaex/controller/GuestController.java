package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestController {
	// 필드
	@Autowired
	private GuestService guestService;
	// 생성자
	// 메소드gs
	// 메소드일반

	// 게시판폼
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("GuestController >> addList()");

		// Service를 통해서 getGuestList(주소)를 가져온다
		List<GuestbookVo> guestList = guestService.getGuestList();

		// ds 데이터보내기 --> request attribute에 넣는다
		model.addAttribute("guestList", guestList);

		return "guestbook/addList";
	}

	// 등록
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestController>add()");

		// 파라미터 꺼내기 + Vo로 묶기를 DS해서 메소드의 파라미터로 보내준다

		// dao로 저장하기
		guestService.GuestbookInsert(guestbookVo);

		// 리다이렉트
		return "redirect:addList";
	}

	// 게시판 삭제품
	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {
		System.out.println("GuestController >> deleteForm()");

		return "guestbook/deleteForm";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {
		System.out.println("GuestController >> delete()");

		// vo에 no,password담기
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);

		// Dao로 처리하기(삭제)
		guestService.GuestbookDelete(vo);

		return "redirect:/addList";
	}
}
