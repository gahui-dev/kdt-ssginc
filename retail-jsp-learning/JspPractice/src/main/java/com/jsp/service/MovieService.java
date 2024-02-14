package com.jsp.service;

import com.jsp.entity.MovieEntity;
import com.jsp.util.PageMaker;

import java.util.List;

import com.jsp.dao.MovieDAO;

public class MovieService {
	private static final MovieService _instance = new MovieService();
	private MovieDAO dao = MovieDAO.getInstance();

	private MovieService() {
	}

	public static MovieService getInstance() {
		return _instance;
	}

//	public List<MovieDTO> findAllMovie() {
//		return dao.selectAllMovie();
//	}

	public List<MovieEntity> findMovieByPaging(PageMaker pageMaker) {
		List<MovieEntity> movieList = dao.selectMovieByPaging(pageMaker);

		if (!(movieList.size() > 0)) {
			pageMaker.setCriteriaPageNum(1);
			movieList = dao.selectMovieByPaging(pageMaker);
		}

		int totalDataCount = movieList.get(0).getTotalDataCount();
		pageMaker.setTotalDataCount(totalDataCount);

		return movieList;
	}

}
