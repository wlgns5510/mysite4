package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository // Autowired에 연결
public class BoardDao {

	@Autowired
	private SqlSession sqlSession; // 미리 여러개를 연결해놈

	// 리스트
	public List<BoardVo> getBoardList() {
		System.out.println("BoardDao>>getBoardList");

		List<BoardVo> bList = sqlSession.selectList("board.selectList");
		System.out.println(bList);

		return bList;
	}

	// 등록
	public int insert(BoardVo boardVo) {
		System.out.println("BoardDao>>BoardInsert");

		int count = sqlSession.insert("board.insert", boardVo);

		return count;
	}

	

}