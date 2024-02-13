package com.java.class07;

public class Sum {
	static int total;
	static int endNum = 100;
	
	static {
		for(int i = 0; i <= endNum; i++) {
			total += i;
		}
	}
}
