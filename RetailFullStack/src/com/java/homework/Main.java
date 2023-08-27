package com.java.homework;

import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Teacher teacher = new Teacher("사민");
		
		Student student01 = new Student("가희");
		Student student02 = new Student("명진");
		Student student03 = new Student("찬웅");
		
		Room studyRoom = new Room("강의실");
		Room meetingRoom = new Room("회의실");
				
		// 사민, 가희, 명진, 찬웅 강의실로 이동
		teacher.move(studyRoom);
		student01.move(studyRoom);
		student02.move(studyRoom);
		student03.move(studyRoom);
		studyRoom.showState();
		
		teacher.talk("수업을 시작합니다. 오늘은 객체지향에 대해서 배워보겠습니다!\n");
		
		student03.talk("질문", teacher.name, "클래스가 뭔가요?");
		teacher.talk("답변", student03.name, "객체를 생성하는 설계도입니다");
		
		teacher.talk("과제를 냈습니다. 회의실로 이동해 과제를 풀어주세요!");
		
		student01.move(meetingRoom, studyRoom);
		student02.move(meetingRoom, studyRoom);
		student03.move(meetingRoom, studyRoom);
		
		studyRoom.showState();
		meetingRoom.showState();
		
		student01.talk("역할 분담을 해봅시다(0: 플로우차트 그리기, 1: 코딩, 2: 테스트)");
		
		while(true)
	      {
	         int i_student01_result = doAssignment(student01);
	         int i_student02_result = doAssignment(student02);
	         int i_student03_result = doAssignment(student03);

	         if(i_student01_result == i_student02_result || i_student01_result == i_student03_result || i_student02_result == i_student03_result)
	         {
	            System.out.println("같은 역할을 분담했습니다. 서로 다른 역할을 선택하세요.");
	            continue;
	         }
	         else
	         {
	            System.out.println("역할이 잘 분담되었습니다.");
	            break;
	         }      
	      }
		
		student02.checkResult(student01.name, student02.name, student03.name);
		
		student01.move(studyRoom, meetingRoom);
		student02.move(studyRoom, meetingRoom);
		student03.move(studyRoom, meetingRoom);
		
		student01.talk("과제 제출합니다");
		
		teacher.talk("모두 수고하셨습니다. 수업을 마칩니다");
		
		student01.move(studyRoom, studyRoom);
		student02.move(studyRoom, studyRoom);
		student03.move(studyRoom, studyRoom);
		teacher.move(studyRoom, studyRoom);
		
		studyRoom.showState();
	}
	
	public static int doAssignment(Student student) {
	      // (0: 플로우차트 그리기, 1: 코딩, 2: 테스트");
	      System.out.printf(student.name + "역할 선택> ");
	      while(true) {
	    	 Scanner sc = new Scanner(System.in);
	         int part = sc.nextInt();
	         if (part == 0) {
	            System.out.println(student.name + "은(는) 플로우차트 그립니다.");
	            return part;
	         }
	         else if (part == 1) {
	            System.out.println(student.name + "은(는) 코딩을 합니다.");
	            return part;
	         }
	         else if (part == 2) {
	            System.out.println(student.name + "은(는) 테스트를 합니다.");
	            return part;
	         }
	         else {
	            System.out.println("다시 입력해주세요");
	         }
	      } 
	   }
}
