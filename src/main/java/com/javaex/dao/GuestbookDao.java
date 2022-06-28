package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	// 필드
	@Autowired
	private SqlSession sqlSession;
	// 생성자
	// 메소드 gs
	// 메소드 일반

	// 전체 불러오기 메소드
	public List<GuestbookVo> getList() {
		System.out.println("guestbookDao >> getList");

		List<GuestbookVo> guestList = sqlSession.selectList("guestbook.selectList");

		return guestList;
	}

	// 방명록 등록
	public int guestInsert(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao>>guestInsert");

		int count = sqlSession.insert("guestbook.guestInsert", guestbookVo);
		return count;
	}

	// 방명록 삭제
	public int guestDelete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao>>guestDelete");

		int count = sqlSession.delete("guestbook.guestDelete", guestbookVo);
		return count;
	}
	
	//방명록 등록(ajax)
	public int insertGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao>>insertGuest");
		
		int count = sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
		return count;
	}
	
	//방명록 저장후 등록한 데이터 가져오기
	public GuestbookVo getGuest(int no) {
		System.out.println("GuestbookDao>>getGuest");
		
		GuestbookVo gVo = sqlSession.selectOne("guestbook.getGuest", no);
						
		return gVo;
	}
}
