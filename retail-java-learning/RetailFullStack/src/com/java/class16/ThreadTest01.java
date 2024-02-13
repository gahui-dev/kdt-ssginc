package com.java.class16;

import com.java.class16.test01.ThreadA;

public class ThreadTest01 {

	public static void main(String[] args) {
		// RUNNABLE - 실행 준비 상태
		// TIME WATING - 대기
		// TERMINATED - 종료
		
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);

		Thread threadA = new ThreadA();
		System.out.println("threadA 생성 상태값 - " + threadA.getState());
		threadA.start();
		System.out.println("threadA start() 상태값 - " + threadA.getState());
		System.out.println("메인 스레드");

		try {
			for(int i = 0; true; i++) {
				System.out.println("메인 스레드 실행 - " + i);
				System.out.println(threadA.getState());
				Thread.sleep(500);		
				
				if(threadA.getState() == Thread.State.TERMINATED) {
					//threadA.getState().TERMINATED
					System.out.println("스레드 A 종료 확인");
					System.out.println("state - " + threadA.getState());
					System.out.println("종료 준비 중... 0.5초 후 종료");
					Thread.sleep(500);
					break;
				}
			}	
		} catch(InterruptedException e) {
			// e.printStackTrace();
			System.out.println("메인스레드 - 인터럽트 발생");
			System.out.println(e.getMessage());
		}
		System.out.println("메인 스레드 종료합니다");

	}

}
