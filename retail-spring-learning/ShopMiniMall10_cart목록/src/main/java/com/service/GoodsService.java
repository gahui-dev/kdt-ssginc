package com.service;

import java.util.List;

import com.dto.CartDTO;
import com.dto.GoodsDTO;

public interface GoodsService {
	public List<GoodsDTO> goodsList(String gCategory);
	public GoodsDTO goodsRetrieve(String gCode);
	public int cartAdd(CartDTO dto);
	public List<CartDTO> cartList(String userid);
}
