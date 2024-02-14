package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.GoodsDTO;

@Repository
public class GoodsDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	public List<GoodsDTO> goodsList(String gCategory) {
		return session.selectList("GoodsMapper.goodsList", gCategory);
	}
	
	public GoodsDTO goodsRetrieve(String gCode) {
		return session.selectOne("GoodsMapper.goodsRetrieve", gCode);
	}
	
	public int cartAdd(CartDTO dto) { 
		return session.insert("CartMapper.cartAdd", dto);
	}
	
	public List<CartDTO> cartList(String userid) {
		return session.selectList("CartMapper.cartList", userid);
	}
}
