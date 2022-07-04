package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RBoardVo;

@Repository
public class RBoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	//리스트+검색
	public List<RBoardVo> getBoardList(String keyword){
		System.out.println("RBoardDao>getBoardList");
		
		List<RBoardVo> bList = sqlSession.selectList("rBoard.selectbList", keyword);
		System.out.println("Dao --> " + bList);
		
		
		return bList;
	}
}
