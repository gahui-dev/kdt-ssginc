package com.java.class16;
import com.java.class16.test03.마늘스레드;
import com.java.class16.test03.면스레드;
import com.java.class16.test03.파스타제조스레드;

public class ThreadTest03 {

	public static void main(String[] args) {
		파스타제조스레드 제조 = new 파스타제조스레드();
		면스레드 면 = new 면스레드(제조);
		마늘스레드 마늘 = new 마늘스레드(제조);

		마늘.start();
		면.start();
		제조.start();

		//메인 스레드 마치기 싫다면
		//제조.join();
		System.out.println("메인스레드는 마치지만 파스타는 제조중일 겁니다.");
		// 예상 출력
		// 1.마늘 다 튀겼어요 (3초)
		// 2.제조스레드 왈 "마늘이 다 튀겨졌대요" (3초 )
		// 3.면을 다 삶았어요 (6초)
		// 4.제조스레드 왈 "면을 다 삶았대요" (6초 )
		// 5. 제조 시작 ~~~~ 5초후 완성
		// 쿠킹 중 5, 4, 3, 2, 1 땡!
		// "면과 마늘을 섞어서 파스타를 만들었어요"
		// 스레드 종료
	}

}