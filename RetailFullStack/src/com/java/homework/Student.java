package com.java.homework;
import java.util.Scanner;

public class Student {
	Scanner sc = new Scanner(System.in);
	public String name;

	public Student() {}
	public Student(String name) {
		this.name = name;
	}

	public void move(Room room) {
		room.inRoom(this);
	}
	
	public void move(Room enterRoom, Room leaveRoom) {
		leaveRoom.outRoom(this);
		if(enterRoom != leaveRoom) {			
			enterRoom.inRoom(this);
		}
	}
	
	public void talk(String message) {
		System.out.println(name + "> " + message);
	} 

	public void talk(String topic, String target, String message) {
		System.out.println(name + "이 " + target + "에게 " + topic + "을 한다.\n" + name + " > " + message);
	}

	public void checkResult(String student1, String student2, String student3) {
		System.out.printf("%s, %s, %s이(가) 결과를 확인하고 있습니다.\n", student1, student2, student3);
		System.out.print("결과가 잘 나왔으면 1, 아니면 0을 입력해주세요");
		while(true) {
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("설계도처럼 작동하고 있어.");
				break;
			}else if (input == 0) {
				System.err.println("오류 발생!");
				System.out.println("코드를 다시 봐야겠어.");
				System.out.printf("%s, %s, %s이(가) 결과를 확인하고 있습니다.\n", student1, student2, student3);
			}else {
				System.out.println("정상 작동(1)과 에러(0)중 입력해주세요");
			}
		}
	}
}



