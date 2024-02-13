package com.java.class12.demo;

public class TryCatch2Demo {

	public static void main(String[] args) {
		int dividend = 10;
		
		try {
			int divisor = Integer.parseInt(args[0]);
			System.out.println(dividend / divisor);
		} catch (ArrayIndexOutOfBoundsException e) {
			// 배열의 범위를 벗어난 인덱스를 사용할 때 발생
			System.out.println("원소가 존재하지 않습니다.");
		} catch (NumberFormatException e) {
			// main() 메서드의 인수를 숫자로 바꿀 수 없을 때 발생
			System.out.println("숫자가 아닙니다.");
		} catch (ArithmeticException e) {
			// main() 메서드의 인수가 0일 때 나눌 수 없으므로 발생
			System.out.println("0으로 나눌 수 없습니다.");
		} finally {
			// 항상 실행, 선택 사항
			System.out.println("항상 실행됩니다.");
		}
		
		System.out.println("종료");
		 
	}

}
