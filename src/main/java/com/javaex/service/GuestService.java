package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestService {
	// 필드
	@Autowired
	private GuestbookDao guestbookDao;
	// 생성자
	// 메소드 gs
	// 메소드 일반

	// 방명록 리스트
	public List<GuestbookVo> getGuestList() {
		List<GuestbookVo> guestList = guestbookDao.getList();
		return guestList;
	}

	// 방명록 등록
	public int GuestbookInsert(GuestbookVo guestbookVo) {

		int count = guestbookDao.guestInsert(guestbookVo);

		return count;
	}

	// 방명록 삭제
	public int GuestbookDelete(GuestbookVo guestbookVo) {

		int count = guestbookDao.guestDelete(guestbookVo);

		return count;
	}
	
	//방명록 저장(ajax)
	public GuestbookVo addGuest(GuestbookVo guestbookVo) {
		
		int count = guestbookDao.insertGuest(guestbookVo);
		
		int no =guestbookVo.getNo();
		
		//방금저장한 1개의 데이터를 가져온다.		
		GuestbookVo gVo = guestbookDao.getGuest(no);
		
		return gVo;
	}
	
	//방명록 삭제(ajax)
	public String removeGuest(GuestbookVo guestbookVo) {
		
		String state;
		
		int count = guestbookDao.guestDelete(guestbookVo);
		
		if(count>0) {
			state = "succeess";
		}else{
			state = "fail";
		}
		
		return state;
	}
}
