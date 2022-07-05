package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	// 필드
	@Autowired
	private BoardDao boardDao;
	// 생성자

	// 메소드 gs

	// 메소드 일반

	// 게시판 리스트+검색
	public List<BoardVo> getBoardList(String keyword) {
		// 코드작성
		List<BoardVo> bList = boardDao.getBoardList(keyword);

		return bList;
	}
	
	//리스트(일반)
	public List<BoardVo> getBoardList2(int crtPage){
		
		//페이지당 글갯수(10개)
		int listCnt = 10;
		
		//시작 글번호
		int startRnum = (crtPage-1)*listCnt + 1;
		
		//끝 글번호
		int endRnum = (startRnum + listCnt) - 1;

		List<BoardVo> boardList = boardDao.getBoardList2(startRnum, endRnum);
		
		return boardList;
	}

	
    // 게시판 등록
    public int insert(BoardVo boardVo) {
  
	    int count = boardDao.insert(boardVo);
	  
	    return count; 
    }
	  
	//게시판 삭제
    public int delete(int no) {
    	
    	int count = boardDao.delete(no);
    	
    	return count;
    }
    
    //게시판 읽기
    public BoardVo read(int no) {
    	
    	
    	return boardDao.read(no);
    }
    
    //게시판 수정
    public int modify(BoardVo boardVo) {
    	
    	int count = boardDao.modify(boardVo);
    	
    	return count;
    }   
 
}
