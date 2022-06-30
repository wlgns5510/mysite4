package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.FileDao;
import com.javaex.vo.FileVo;

@Service
public class FlieService {
	@Autowired
	private FileDao fileDao;

	//파일저장, 파일 정보(DB저장) 추출 저장
	public String save(MultipartFile file) {
		System.out.println("FlieService>save()");
		
		String saveDir = "C:\\javaStudy\\upload";
		
		//파일 정보(DB저장) 추출 저장
		//오리지널파일명
		String orgName = file.getOriginalFilename();
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf(".")); //확장자를 알아낼 수 있다. ex) .img찾아냄
		
		//저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName; //랜덤숫자 + 현재시간 *겹치지 않는다
				
		//파일경로(디렉토리+저장파일명)
		String filePath = saveDir + "\\" + saveName;
		
		//파일사이즈
		long fileSize = file.getSize();
		
		
		FileVo fileVo = new FileVo(orgName, saveName, filePath, fileSize);
		System.out.println(fileVo);
		
		//DB에 저장
		fileDao.save(fileVo);
		
		//HD에 저장
		try {
			byte[] fileData = file.getBytes();	//ex)1010011식으로 담아서 줌(byte형식으로)
			
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
