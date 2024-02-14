package com.exception;

// extends Exception 하면 예외처리 가능하다.
public class DuplicatedDeptnoException extends Exception {

	// source에서 상위클래스 생성자 만들기
	public DuplicatedDeptnoException(String message) {
		super(message);
	}

}
