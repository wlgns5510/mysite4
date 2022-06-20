package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Repository
public class UserService {

	//필드
	@Autowired
	UserDao userDao;
	//생성자
	//메소드gs
	//메소드일반
	public void join(UserVo userVo) {
		System.out.println("UserService.join()");
		//Dao를 통해 DB에 자료저장
		userDao.userInsert(userVo);
	}
}
