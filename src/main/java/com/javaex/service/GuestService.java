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
}
