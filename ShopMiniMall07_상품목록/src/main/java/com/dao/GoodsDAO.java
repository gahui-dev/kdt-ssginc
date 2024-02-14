package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.GoodsDTO;

@Repository
public class GoodsDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<GoodsDTO> goodsList(String gCategory) {
		return session.selectList("GoodsMapper.goodsList", gCategory);
	}
}
