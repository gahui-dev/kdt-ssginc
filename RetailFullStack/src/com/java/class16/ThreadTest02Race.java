package com.java.class16;

import com.java.class16.test02.Horse;
import com.java.class16.test02.Tiger;

public class ThreadTest02Race {
	public static void main(String[] args) {
		Runnable tigerRun = new Tiger();
		Runnable horseRun = new Horse();

		Thread tigerThread = new Thread(tigerRun);
		tigerThread.setPriority(Thread.MAX_PRIORITY);

		Thread horseThread = new Thread(horseRun);
		horseThread.setPriority(Thread.MIN_PRIORITY);

		System.out.println("3초 후에 시작합니다");

		for(int i = 0; i < 3; i++) {
			try {
				System.out.println((3 - i) + "초");
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}		

		System.out.println("레이스 스타트");
		tigerThread.start();
		horseThread.start();
		try {
			tigerThread.join();
			// horseThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		System.out.println("5초 후에 종료합니다.");
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(5 - i + "초");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// tigerThread.interrupt();
		// horseThread.interrupt();

		((Tiger)tigerRun).stopThread();
		((Horse)horseRun).stopThread();
		
		System.out.println("메인 스레드를 종료합니다");


	}
}
