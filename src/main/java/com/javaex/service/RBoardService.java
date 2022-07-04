package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RBoardDao;
import com.javaex.vo.RBoardVo;

@Service
public class RBoardService {

	@Autowired
	private RBoardDao rBoardDao;
	
	public List<RBoardVo> getBoardList(String keyword){
		List<RBoardVo> bList = rBoardDao.getBoardList(keyword);
		
		return bList;
	}
}
