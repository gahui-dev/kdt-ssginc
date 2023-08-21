package com.java.class02;

public class CastTest {

	public static void main(String[] args) {
		// double(8) > float(4) 
		// long(8) > int(4) > short, char(2) > byte(1)
		
		byte bNum = (byte)5;
		
		// 작은 범위 => 큰 범위
		char cNum = (char)bNum;
		short sNum = bNum;
		int iNum = bNum;
		long lNum = iNum;
		float fNum = lNum;
		double dNum = fNum;
		
		// 큰 범위 => 작은 범위
		fNum = (float)dNum;
		lNum = (long)fNum;
		iNum = (int)lNum;
		sNum = (short)iNum;
		bNum = (byte)sNum;
		
		sNum = 385; // 385 = 129 + 256
		bNum = (byte)sNum;
		System.out.println(bNum);
		
		
		// 큰 범위에서 작은 범위로는 왜 안들어갈까?
		// 큰 범위로 공간을 만들어놨는데 작은 범위
		
		int x =1, y =2;
		char c1 = 'a';
		final int ONE = 1;
		System.out.println((int)c1 + ONE);
		System.out.println(x++);
		System.out.println(++x + y--);
		System.out.println(++x / 3 + x * ++y);
	}

}
