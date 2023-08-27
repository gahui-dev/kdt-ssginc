package com.java.class06;

public class Car {
	public static final int DIRECTION_GO = 0;
	public static final int DIRECTION_BACK = 1;
	public static final int DIRECTION_LEFT = 2;
	public static final int DIRECTION_RIGHT = 3;
	
	int speed = 0;
	int direction = 0;
	
	public void setSpeed(int speedNum) {
		//this.speed = speed;
		speed += speedNum;
		if(speedNum > 0) {
			System.out.printf("%d 만큼 속도를 높였다.\n", speedNum);			
		} else if (speedNum < 0) {
			System.out.printf("%d 만큼 속도를 줄였다.\n", speedNum);						
		}
	}
	
	public void setDirection(int directionNum) {
		direction = directionNum;
		String strDirection = getStringDirection(direction);
		System.out.printf("%s 방향으로 전환했다. \n", strDirection);
	}
	
	public String getStringDirection(int direction) {
		String setDirection = "";
		switch(direction) {
		case DIRECTION_GO: setDirection = "앞쪽"; break;
		case DIRECTION_BACK: setDirection = "뒤쪽"; break;
		case DIRECTION_LEFT: setDirection = "왼쪽"; break;
		case DIRECTION_RIGHT: setDirection = "오른쪽"; break;
		}
		return setDirection;
	}
	public void display() {
		
		// direction 방향으로 속도 speed로 가고 있다.
		System.out.printf("%s 방향으로 속도 %d로 가고 있다\n", getStringDirection(direction), speed);
	}
}
