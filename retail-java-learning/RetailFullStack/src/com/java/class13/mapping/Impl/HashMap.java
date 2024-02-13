package com.java.class13.mapping.Impl;

import java.util.ArrayList;

import com.java.class13.mapping.Map;

public class HashMap<K, V> implements Map<K, V> {
	ArrayList<Pair<K, V>> arrayList;

	public HashMap() {
		arrayList = new ArrayList<>();
	}

	@Override
	public V put(K key, V value) {
		// specific key가 최초 사용? 아니면 사용한적 있나?
		// return null : key가 최초 사용할 때
		// return Object : key 가 이미 사용되었을 때 value 리턴
		
		for(Pair<K, V> pair : arrayList) {
			if(pair.getKey().equals(key)) {
				V tmp = pair.getValue();
				pair.setValue(value);
				return tmp;
			}
		}

		Pair<K, V> pair = new Pair<>();
		pair.setKey(key);
		pair.setValue(value);
		this.arrayList.add(pair);

		return null;
	}

	@Override
	public V get(K key) {
		for(Pair<K, V> pair : arrayList) {
			if(pair.getKey().equals(key)) {
				return pair.getValue();
			}
		}

		return null;
	}

	
//	public String toString() {
//		StringBuffer sb = new StringBuffer(arrayList.toString());
//		sb.replace(0, 1, "{");
//		sb.replace(sb.length() - 1, sb.length(), "}");
//		return sb.toString();
//	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		
		for(Pair<K, V> pair : arrayList) {
			//str += pair.getKey() + "=" + pair.getValue() + ", ";
			//sb.append(pair.getKey()).append("=").append(pair.getValue()).append(", ");
			sb.append(pair.toString()).append(", ");
		}
		
		if(sb.length() > 1) {
			//sb = sb.substring(0, sb.length() - 2);
			sb.delete(sb.length() - 2, sb.length());
		}
		
		sb.append("}");
		return sb.toString();
	}

	private class Pair<K, V> {
		private K key;
		private V value;

		public K getKey() {
			return this.key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return this.value;
		}

		public void setValue(V value) {
			this.value = value;
		}
		
		public String toString() {
			return key + "=" + value;
		}
	}	
}
