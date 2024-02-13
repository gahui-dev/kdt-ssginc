package com.java.class13.generic;

import com.java.class13.mapping.*;
import com.java.class13.mapping.Impl.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		java.util.List<String> list = new java.util.ArrayList<>();
		
		List<String> listGeneric = new ArrayList<>();
		listGeneric.add("안녕");
		listGeneric.add("자바야");
		
		System.out.println(listGeneric);
		System.out.println(listGeneric.get(0));
		System.out.println(listGeneric.get(1));
		try {
			System.out.println(listGeneric.get(2));
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(listGeneric.get(1));
	} 
}
