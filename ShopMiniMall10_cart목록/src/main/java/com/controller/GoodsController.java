package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService gService;

	@GetMapping("/goodsRetrieve")
	@ModelAttribute("goodsRetrieve")
	public GoodsDTO goodsRetrieve(@RequestParam String gCode) {

		// GoodsDTO 요청하면 모델은 goodsdto 뷰는 요청매핑값 유추
		// @ModelAttribute 명시적 키값
		GoodsDTO dto = gService.goodsRetrieve(gCode);
		return dto;
	}

	// 장바구니 저장
	@GetMapping("/CartAddServlet")
	public String cartAdd(CartDTO cDTO, HttpSession session) {

		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		cDTO.setUserid(mDTO.getUserid());

		int n = gService.cartAdd(cDTO);

		return "goods/cartAddSuccess";
	}

	// 장바구니 목록
	@GetMapping("/CartListServlet")
	public ModelAndView cartList(CartDTO cDTO, HttpSession session) {
		
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		String userid = mDTO.getUserid();
		List<CartDTO> list = gService.cartList(userid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartList", list);
		mav.setViewName("cartList"); // /WEB-INF/views/cartList.jsp
		
		return mav;
	}
}
