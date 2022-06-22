package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Service
public class BoardService {

	// 필드
	@Autowired
	private BoardDao boardDao;
	// 생성자

	// 메소드 gs

	// 메소드 일반

	// 전화번호 리스트
	public List<BoardVo> getBoardList() {
		// 코드작성
		List<BoardVo> bList = boardDao.getBoardList();

		return bList;
	}

	
    // 게시판 등록
    public int insert(BoardVo boardVo) {
  
	    int count = boardDao.insert(boardVo);
	  
	    return count; 
    }
	  
	 
	 
	 

}
