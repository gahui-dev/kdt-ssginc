package com.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dto.UploadDTO;

@Controller
public class TestController {
	@GetMapping("/uploadForm")
	public String home() {
		return "uploadForm";
	}
	
	@PostMapping("/upload")
	public String upload(UploadDTO dto, Model m) {
		System.out.println(dto);
		
		String theText =dto.getTheText();
		CommonsMultipartFile theFile = dto.getTheFile();
		
		System.out.println("theText >>>>>" + theText);
		System.out.println("theFile >>>>>" + theFile);
		
		String contentType = theFile.getContentType();
		String name = theFile.getName();
		FileItem fileItem = theFile.getFileItem();
		String originalFileName = theFile.getOriginalFilename();
		long size = theFile.getSize();
		
		System.out.println("contentType >>>>>>> " + contentType);
		System.out.println("name >>>>>>> " + name);
		System.out.println("fileItem >>>>>>> " + fileItem);
		System.out.println("originalFileName >>>>>>> " + originalFileName);
		System.out.println("size >>>>>>> " + size);
		
		// 업로드 된 파일을 서버의 물리적인 디렉터리에 저
		// /Users/leegahee/upload
		File f = new File("/Users/leegahee/Documents/upload/" + originalFileName);
		
		// theFile =====> f 쓰기
		try {
			theFile.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		m.addAttribute("contentType", contentType);
		m.addAttribute("originalFilename", originalFileName);
		m.addAttribute("size", size);
		
		return "uploadInfo";
	}
	
	@GetMapping("/uploadInfo")
	public String uploadInfo() {
		return "uploadInfo";
	}
}
