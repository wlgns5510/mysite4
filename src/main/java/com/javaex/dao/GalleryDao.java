package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;
	
	//화면 리스트
	public List<GalleryVo> galleryList(){
		System.out.println("GalleryDao>galleryList");
		
		List<GalleryVo> galleryList = sqlSession.selectList("gallery.gList");
		
		return galleryList;
	}
	
	//파일저장하기
	public int save(GalleryVo galleryVo) {
		System.out.println("GalleryDao>save");
		
		int count = sqlSession.insert("gallery.save", galleryVo);
		
		return count;
	}
}
