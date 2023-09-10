package com.java.class13.mapping;

public interface Map<K, V> {
	public V put(K key, V value);
	public V get(K key);
}
