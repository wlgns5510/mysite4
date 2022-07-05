package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> getBoardList2(int crtPage){
		
		//페이지당 글갯수(10개)
		int listCnt = 10;
		
		//현재페이지
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);	//다른값 넣으면 1로 변환
		
		//시작 글번호
		int startRnum = (crtPage-1)*listCnt + 1;
		
		//끝 글번호
		int endRnum = (startRnum + listCnt) - 1;

		List<BoardVo> boardList = boardDao.getBoardList2(startRnum, endRnum);
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		//페이징 계산
		//전체글갯수
		int totalCnt = boardDao.selectTotalCnt();
		
		//페이지당 버튼 갯수
		int pageBtnCount = 5;
						
		//마지막 버튼 번호
		int endPageBtnNo = (int)Math.ceil(crtPage / (double)pageBtnCount) * pageBtnCount;
		
		//시작 버튼 번호
		int startPageBtnNo = (endPageBtnNo-pageBtnCount) + 1;;
		
		//다음 화살표 유무
		boolean next = false;
		if((listCnt*endPageBtnNo) < totalCnt) {
			next = true;
		}else {
			endPageBtnNo = (int)Math.ceil(totalCnt/(double)listCnt);
		}
		
		//이전 화살표 유무
		boolean prev = false;
		if(startPageBtnNo != 1) {
			prev = true;
		}
		
		//리스트 페이징 정보 묶기
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardList", boardList);
		pMap.put("prev", prev);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("next", next);
		
		return pMap;
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
