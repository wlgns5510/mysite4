package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FileVo;

@Repository
public class FileDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//파일저장하기
	public int save(FileVo fileVo) {
		System.out.println("FileDao>save()");
		
		int count = sqlSession.insert("file.insert",fileVo);
		
		return count;
	}
}
