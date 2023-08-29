package com.java.class07;

public class People {
	String name;
	int[] scores;
	
	public People() {
		this.name = "";
		scores = new int[0];
	}
	
	public People(String name, int subjectCount) {
		this.name = name;
		scores = new int[subjectCount];
	}
	
	public String getName() {
		return this.name;
	}
	
	//public void setName() {
	//	this.name = name;
	//}
	
	public int[] getScores() {
		return this.scores;
	}
	
	public void setScores(int subjectCount, int score) {
		scores[subjectCount] = score;
	}
}

