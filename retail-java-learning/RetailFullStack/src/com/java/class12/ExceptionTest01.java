package com.java.class12;

public class ExceptionTest01 {
	public static void main(String[] args) {
		// Exception 런타임에 발생하는 예외 처리
		// Object
		//   |
		// Throwable
		//   |				  |
		// Exception		Error
		//   |
		// RuntimeException
		//   |
		// ArithmeticException : 산술 처리시 발생
		
		Exception ex = new Exception();
		System.out.println(ex.toString());
		
		Throwable tr = ex;
		System.out.println(tr);
		ex = (Exception)tr;
		
//		try {
//			Error er = (Error)tr;
//			System.out.println(10 / 0);
//		} catch(ClassCastException ae) {
//			ae.printStackTrace();
//		} catch(Exception e) {
//			ex.printStackTrack();
//		}finally {
//			System.out.println("finally 여기1");
//		}
		
		
		// 예외 잡아 처리하기 - try ~ catch
		try {
			Exception[] exArr = new Exception[10];
			System.out.println(exArr[10]);
		} catch(Exception e) {
			System.out.println("빨간 글씨 싫어 " + e.getMessage());
		} 
		
		// 예외 떠넘기기 - throws
		try {
			Exception[] exArr = new Exception[10];
			Exception tmp = getExArrByIndex(exArr, 10);
			System.out.println("접근1");
		} catch(Exception e) {
			System.out.println("빨간 글씨 싫어 " + e.getMessage());
		} 
		System.out.println("접근2");
	}
	
	public static Exception getExArrByIndex(Exception[] exArr, int index)
			throws ArrayIndexOutOfBoundsException {
		return exArr[-10];
	}
}
