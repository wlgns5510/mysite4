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
		
	/*
	 * // 등록 public int BoardInsert(BoardVo boardVo) {
	 * System.out.println("BoardDao>>BoardInsert");
	 * 
	 * int count = sqlSession.insert("phonebook.personInsert", personVo);
	 * 
	 * return count; }
	 * 
	 * // 수정 public int personUpdate(PersonVo personVo) {
	 * System.out.println("PhoneDao>>personInsert");
	 * 
	 * int count = sqlSession.update("phonebook.personUpdate", personVo);
	 * 
	 * return count; }
	 * 
	 * // 삭제 public int personDelete(int personId) {
	 * System.out.println("PhoneDao>>personInsert");
	 * 
	 * int count = sqlSession.delete("phonebook.personDelete", personId); return
	 * count; }
	 * 
	 * // 한사람 가져오기 public PersonVo getPerson(int personId) {
	 * System.out.println("PhoneDao>>getPerson");
	 * 
	 * return sqlSession.selectOne("phonebook.getPerson", personId);
	 * 
	 * }
	 */
	

	

}