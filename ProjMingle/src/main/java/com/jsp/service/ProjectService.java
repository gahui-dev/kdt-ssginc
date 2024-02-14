package com.jsp.service;

import java.util.ArrayList;

import com.jsp.dao.ProjectDAO;
import com.jsp.dto.ProjectDTO;

public class ProjectService {
	private static final ProjectService _instance = new ProjectService();
	public static ProjectService getInstance() {
		return _instance;
	}
	
	private ProjectDAO dao = ProjectDAO.getInstance();
	
	public ArrayList<ProjectDTO> selectProject(String name) {
		ArrayList<ProjectDTO> projectList = dao.selectProject(name);
		
		if(projectList != null) {
			// System.out.println("프로젝트 조회 성공");
			return projectList;
		} else {
			System.out.println("프로젝트 조회 실패");
			return null;
		}		
	}
	
	public boolean createProject(ProjectDTO projectDto) {		
		if(dao.createProject(projectDto) == 1) {
			System.out.println("프로젝트 생성 성공");
			return true;
		} else {
			System.out.println("프로젝트 생성 실패");
			return false;
		}		
	}
}
