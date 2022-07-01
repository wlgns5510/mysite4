package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	//화면 리스트
	@RequestMapping(value="/gallery/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GalleryController>list");
		
		List<GalleryVo> galleryList = galleryService.galleryList();
		
		model.addAttribute("galleryList", galleryList);
		
		return "gallery/list";
	}
	
	//사진 등록
	@RequestMapping(value="/gallery/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("content") String content, Model model) {
		System.out.println("GalleryController>upload");
		System.out.println(file.getOriginalFilename());
		
		
		String saveName = GalleryService.save(file);
		
		GalleryVo galleryVo = new GalleryVo();
		galleryVo.setContent(content);
		galleryVo.setSaveName(saveName);
		
		model.addAttribute("galleryVo", galleryVo);
		
		return "gallery/list";
	}
	
}
