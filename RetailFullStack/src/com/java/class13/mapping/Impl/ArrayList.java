package com.java.class13.mapping.Impl;

import java.util.Iterator;

import com.java.class13.mapping.List;

public class ArrayList<E> implements List<E>, Iterator<E>{
	private E[] array;
	
	@Override
	public boolean add(E element) {
		if(this.array == null) {
			this.array = (E[])new Object[1];
			this.array[0] = element;
		}else {
			// 개발자 코드
			int size = array.length;
			E[] tmp = array;
			array = (E[])new Object[size+1];

			// 옮겨주기 array.copy
			for(int i=0; i < tmp.length ; i++) {
				array[i] = tmp[i];
			}
			array[size] = element;
		}
		return true;
	}

	@Override
	public E get(int index) {
		E element = null;
		if( array == null || index >= array.length || index < 0 ) {
			throw new IndexOutOfBoundsException();
		}else {
			element = array[index];
		}
		return element;
	}

	@Override
	public int size() {
		int length = 0;
		if(this.array != null) {
			length = array.length;
		}
		return length;
	}
	
	private int index_iterator = 0;
	@Override
	public Iterator<E> iterator() {
		System.out.println(hasNext());
		return this;
	}

	@Override
	public boolean hasNext() {
		System.out.println(hasNext());
		boolean flag = false;
		
		if(this.array == null) {
			flag = false;
		} else if(this.array.length > index_iterator) {
			flag = true;
		} else {
			initializing4Index_iterator();
			flag = false;
		}
		
		return flag;
	}
	
	@Override
	public E next() {
//		int index = index_iterator;
//		index_iterator++;
//		return this.array[index];
		return this.array[index_iterator++];
		
	}

	private void initializing4Index_iterator() {
		index_iterator = 0;
	}
}
