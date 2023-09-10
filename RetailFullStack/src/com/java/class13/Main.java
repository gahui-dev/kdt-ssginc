package com.java.class13;

import com.java.class13.mapping.Map;
import com.java.class13.mapping.Impl.HashMap;

public class Main {
	public static void main(String[] args) {
		java.util.Map<Integer, String> mapper = new java.util.HashMap<>();
		
		System.out.println("1. " + mapper);
		mapper.put(1, "차키");
		System.out.println("2. " + mapper);
		System.out.println("3. " + mapper.put(2, "현관키"));
		System.out.println("4. " + mapper.put(1, "창고키"));
		System.out.println("5. " + mapper.get(1));
		System.out.println("6. " + mapper.get(4));
		System.out.println("7. " + mapper);
				
		System.out.println("----------------------");
		
		// 1. get 구현
		// 2. 실제 Hashmap 처럼 출력하기
		
		Map<Integer, String> map = new HashMap<>();
		
		System.out.println("1. " + map);
		map.put(1, "차키");
		System.out.println("2. " + map);
		System.out.println("3. " + map.put(2, "현관키"));
		System.out.println("4. " + map.put(1, "창고키"));
		System.out.println("5. " + map.get(1));
		System.out.println("5. " + map.get(1));
		System.out.println("5. " + map.get(1));
		System.out.println("6. " + map.get(4));
		System.out.println("7. " + map);
	}
}
