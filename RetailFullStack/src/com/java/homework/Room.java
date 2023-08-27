package com.java.homework;

public class Room {
	public String roomName;
	public int memberCount;
	
	public Room() {}
	public Room(String name) {
		this.roomName = name;
		this.memberCount = 0;
	}
	
	public void inRoom(Student student) {
		memberCount++;
		System.out.println(student.name + "이 " + roomName + "에 들어왔습니다.");
	}
	public void outRoom(Student student) {
		if(memberCount > 0) {
			memberCount--;
		}
		System.out.println(student.name + "이 " + roomName + "에서 나갔습니다. " + memberCount + "명이 남아있습니다");
	}
	
	public void inRoom(Teacher teacher) {
		memberCount++;
		System.out.println(teacher.name + "이 " + roomName + "에 들어왔습니다.");
	}
	public void outRoom(Teacher teacher) {
		if(memberCount > 0) {
			memberCount--;
		}
		System.out.println(teacher.name + "이 " + roomName + "에서 나갔습니다. " + memberCount + "명이 남아있습니다");
	}
	
	public void showState() {
		System.out.println("======================================");
    	System.out.println("방 이름: " + roomName);
        System.out.println("현재 인원 수: " + memberCount);
        System.out.println("======================================");
	}
}




