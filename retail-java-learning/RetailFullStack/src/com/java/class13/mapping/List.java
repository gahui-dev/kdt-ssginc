package com.java.class13.mapping;

public interface List <E> extends Iterable<E>{
	public boolean add(E element);
	public E get(int index) throws IndexOutOfBoundsException;
	public int size();
}
