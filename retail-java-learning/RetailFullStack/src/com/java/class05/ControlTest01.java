package com.java.class05;

public class ControlTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i <= 10; i++){
			if(i == 5) {
				continue;
			}
			System.out.println(i);
		}
		
		for(int i = 1; i < 10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			System.out.print(i);
		}
	}

}
