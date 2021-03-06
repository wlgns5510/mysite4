package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	//필드
	@Autowired
	UserDao userDao;
	//생성자
	//메소드gs
	//메소드일반
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("UserService.join()");
		//Dao를 통해 DB에 자료저장
		int count = userDao.userInsert(userVo);
		
		return count;
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("UserService.iogin()");
		//Dao를 통해 DB에 자료저장
		UserVo authUser = userDao.getUser(userVo);
		
		return authUser;
	}
	
	//수정할 회원 정보
	public UserVo getUserNo(int no) {
		System.out.println("UserService.getUserNo()");
		
		//Dao를 통해 DB에 자료저장
		UserVo userVo = userDao.getUserNo(no);
		
		return userVo;
	}
	
	//수정
	public int modify(UserVo userVo) {
		System.out.println("UserService.modify()");
		
		//Dao를 통해 DB에 자료저장
		int count = userDao.modify(userVo);
		
		return count;
	}
}
