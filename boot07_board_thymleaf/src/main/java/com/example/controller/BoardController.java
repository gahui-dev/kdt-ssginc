package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.BoardDTO;
import com.example.dto.PageDTO;
import com.example.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("/list")
	public String list(Model m, @RequestParam(required = false, defaultValue = "1") int curPage) {
		PageDTO pageDTO = service.findAll(curPage);
		m.addAttribute("pageDTO", pageDTO);
		return "list"; // /WEB-INF/views/list.jsp
	}

	@GetMapping("/write")
	public String writeForm() {
		return "write";
	}
	
	@PostMapping("/write")
	public String writeForm(BoardDTO dto) {
		int n = service.write(dto);
		return "redirect:list";
	}
	
	@GetMapping("/retrieve") // /WEB-INF/views/retrieve.jsp 제작해야 한다.
	@ModelAttribute("board")
	public BoardDTO retrieve(@RequestParam int num) {
		BoardDTO dto = service.retrieve(num);
		return dto;
	}
	
	@PostMapping("/update")
	public String update(BoardDTO dto) {
		int n = service.update(dto);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int num) {
		System.out.println("delete >> " + num);
		int n = service.delete(num);
		return "redirect:list";
	
	}
	
}
