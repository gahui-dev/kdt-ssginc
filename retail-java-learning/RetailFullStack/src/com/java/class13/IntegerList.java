package com.java.class13;

public class IntegerList {
	int[] array;

	public int get(int index) {
		int result = 0;
		if( array == null || index >= array.length || index < 0 ) {
			result = -1; // 8
		}else {
			result = array[index];
		}
		return result;
	}

	public boolean add(int value) {
		if(this.array == null) {
			this.array = new int[1];
			this.array[0] = value;
		}else {
			// 개발자 코드
			int size = array.length;
			int[] tmp = array;
			array = new int[size+1];

			// 옮겨주기 array.copy
			for(int i=0; i < tmp.length ; i++) {
				array[i] = tmp[i];
			}
			array[size] = value;
		}
		return true;
	}

	@Override
	public String toString() {
		String result = "";
		for(int i=0; i < this.array.length ; i++) {
			if(i==0) {
				result = "[" + this.array[i];
			}else if( i == this.array.length-1 ) {
				result += ", "+this.array[i] + "]";
			}else {
				result += ", " + this.array[i];
			}
		}

		return result;
	}
}
