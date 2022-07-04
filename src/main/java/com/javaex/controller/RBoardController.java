package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.RBoardService;
import com.javaex.vo.RBoardVo;

@Controller
@RequestMapping(value = "/rBoard")
public class RBoardController {
	
	@Autowired
	private RBoardService rBoardService;

	//게시판 리스트 + 검색
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model,
					   @RequestParam(value="keyword", required=false, defaultValue="")String keyword) {
		System.out.println("RBoardController>list");
		
		List<RBoardVo> bList = rBoardService.getBoardList(keyword);
		System.out.println("controller -->" + bList);
		
		model.addAttribute("gList", bList);
		
		return "rBoard/list";
	}
}
