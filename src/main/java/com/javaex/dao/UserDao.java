package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	//필드
	@Autowired
	private SqlSession sqlSession;
	//생성자
	//메소드gs
	//메소드일반
	
	//회원정보 저장(회원가입)
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao.userInsert()");
		
		int count = sqlSession.insert("user.insert", userVo);
		
		return count;
	}
	
	//회원정보 가져오기(로그인)
	public UserVo getUser(UserVo userVo) {
		System.out.println("UserDao.getUser()");
		
		UserVo authUser = sqlSession.selectOne("user.getUser", userVo); //id,password로 정보가져오기

		
		return authUser;
	}
	
	//no로 회원정보 가져오기(수정)
	public UserVo getUserNo(int no) {
		System.out.println("UserDao.getUserNo()");
		
		UserVo userVo = sqlSession.selectOne("user.getUserNo", no); //no로 모든 정보 가져오기

		
		return userVo;
	}
	//회원정보 수정하기
	public int modify(UserVo userVo) {
		System.out.println("UserDao.modify()");
		
		int count = sqlSession.update("user.modify", userVo);
		
		return count;
	}
		
	
}
