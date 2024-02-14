package com.jsp.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jsp.entity.MovieEntity;
import com.jsp.util.PageMaker;

class MovieDaoTest {
	private MovieDAO dao = MovieDAO.getInstance();
	
	@Test
	void testSelectMovieByPaging() {
		// movieList = dao.selectMovieByPaging(pageMaker);
		int pageNum = 8;
		List<MovieEntity> movieList = testLookUpMovieList(pageNum);
		
		pageNum = 12;
		movieList = testLookUpMovieList(pageNum);
		
		pageNum = 32;
		movieList = testLookUpMovieList(pageNum);
		
		pageNum = 34;
		movieList = testLookUpMovieList(pageNum);
		
		assertNotEquals(movieList, null);	
	}
		
	private List<MovieEntity> testLookUpMovieList(int pageNum) {
		PageMaker pageMaker = PageMaker.getPageMaker(pageNum);
		List<MovieEntity> movieList = dao.selectMovieByPaging(pageMaker); // totalDataCount
		int totalDataCount = movieList.get(0).getTotalDataCount();
		pageMaker.setTotalDataCount(totalDataCount);
		System.out.println(movieList);
		PageMaker.printPageNation(pageMaker);
		
		return movieList;
	}
}
