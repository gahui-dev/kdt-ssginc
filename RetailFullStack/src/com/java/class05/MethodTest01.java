package com.java.class05;

public class MethodTest01 {

	public static void main(String[] args) {
		// 메서드
		//System.out.println(Thread.currentThread().getName());
		System.out.println("호출");
		sum();
		int x = 140;
		System.out.println(x);
		System.out.println(sum(3, 5));
		int result = sum(3, 50);
		System.out.println(result);
		System.out.println("호출하고 돌아옴");
	}
	public static void sum() {
		System.out.println("안녕");
	}
	
	public static int sum(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a+b);
		return a+b;
	}
	
	public static void sum(int a, int b, int c) {
		System.out.printf("%d + %d = %d\n", a, b, a+b);
	}
}