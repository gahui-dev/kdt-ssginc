package com.java.homework;

public class Teacher {
	public String name;
	
	public Teacher() {}
	public Teacher(String name) {
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
		System.out.println(name + " 강사님> " + message);
	}
	public void talk(String topic, String target, String message) {
		System.out.println(name + " 강사님이 " + target + "에게 " + topic + "을 한다. \n> " + message + "\n");
	}
}


