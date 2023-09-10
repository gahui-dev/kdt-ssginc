package com.java.class16;

import com.java.class16.test02.RunnableC;

public class ThreadTest02 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());

		Runnable runnableB = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("12 line - " + Thread.currentThread().getName());
			}
		};
		Thread threadB = new Thread(runnableB);
		threadB.setName("threadB");
		//threadB.start();
		
		Runnable runnableC = new RunnableC();
		Thread threadC = new Thread(runnableC);
		threadC.start();
		threadB.start();

		
		System.out.println("19 line - " + Thread.currentThread().getName());
	}
}