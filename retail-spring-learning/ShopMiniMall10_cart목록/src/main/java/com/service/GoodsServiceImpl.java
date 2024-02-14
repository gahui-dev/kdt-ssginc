package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.CartDTO;
import com.dto.GoodsDTO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDAO dao;
	
	@Override
	public List<GoodsDTO> goodsList(String gCategory) {
		return dao.goodsList(gCategory);
	}

	@Override
	public GoodsDTO goodsRetrieve(String gCode) {
		return dao.goodsRetrieve(gCode);
	}

	@Override
	public int cartAdd(CartDTO dto) {
		return dao.cartAdd(dto);
	}

	@Override
	public List<CartDTO> cartList(String userid) {
		return dao.cartList(userid);
	}

}
