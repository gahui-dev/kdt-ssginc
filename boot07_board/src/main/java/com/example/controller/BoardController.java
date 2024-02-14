package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.BoardDTO;
import com.example.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("/list")
	public String list(Model m) {

		List<BoardDTO> list = service.findAll();
		m.addAttribute("list", list);

		return "list";
	}

	@GetMapping("/write")
	public String writeForm() {
		return "write";
	}

	@PostMapping("/write")
	public String write(BoardDTO dto) {
		int n = service.write(dto);
		System.out.println(">>>>>>>>>>>" + n);

		return "redirect:list";
	}

	@GetMapping("/retrieve")
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
	public String writeForm(@RequestParam int num) {
		System.out.println("delete >> " + num);
		return "redirect:list";
	}
}
