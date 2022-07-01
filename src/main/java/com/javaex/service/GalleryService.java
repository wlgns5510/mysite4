package com.javaex.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	private GalleryDao galleryDao;
	
	//화면 리스트
	public List<GalleryVo> galleryList(){
		List<GalleryVo> galleryList = galleryDao.galleryList();
		return galleryList;
	}
	
	//사진저장, 파일 정보(DB저장) 추출 저장
	public String save(MultipartFile file) {
		System.out.println("GalleryService>save()");
		
		String saveDir = "C:\\javaStudy\\upload";
		
		//파일정보(DB저장) 추출 저장
		//오리지널파일명
		String orgName = file.getOriginalFilename();
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		//파일경로(디렉토리 + 저장파일명)
		String filePath = saveDir + "\\" + saveName;
		
		//파일사이즈
		long fileSize = file.getSize();
		
		
		
		return"";
	}
}
