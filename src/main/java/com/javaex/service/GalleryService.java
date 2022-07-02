package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

	// 화면 리스트
	public List<GalleryVo> galleryList() {
		List<GalleryVo> galleryList = galleryDao.galleryList();
		return galleryList;
	}

	// 사진저장, 파일 정보(DB저장) 추출 저장
	public String save(MultipartFile file, String content) {
		System.out.println("GalleryService>save()");

		String saveDir = "C:\\javaStudy\\upload";

		// 파일정보(DB저장) 추출 저장
		// 오리지널파일명
		String orgName = file.getOriginalFilename();

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));

		// 저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

		// 파일경로(디렉토리 + 저장파일명)
		String filePath = saveDir + "\\" + saveName;

		// 파일사이즈
		long fileSize = file.getSize();

		GalleryVo galleryVo = new GalleryVo();
		galleryVo.setContent(content);
		galleryVo.setOrgName(orgName);
		galleryVo.setSaveName(saveName);
		galleryVo.setFilePath(filePath);
		galleryVo.setFileSize(fileSize);
		
		// DB에 저장
		galleryDao.save(galleryVo);
		// HD에 저장
		try {
			byte[] fileData = file.getBytes(); // ex)1010011식으로 담아서 줌(byte형식으로)

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveName;

	}
}
