package com.java.class04;

public class ForGugudan {
	public static void main(String[] args) {
		{
			out:for(int preNum=2; preNum < 10 ;preNum++) {

				int result=0;
				for(int postNum=1; postNum < 10 ;postNum++) {

					result = preNum * postNum;

					if(preNum==3 && postNum==8) {
						System.out.print(result + "\t");
						break;
					} else if(preNum==4 && postNum==7) {
						System.out.print(result + "\t");
						break;
					} else if(preNum==5) {
						break;
					} else if(preNum==6 ) {
						if(postNum == 1){
							System.out.print(result + "\t");
						}else if(postNum < 9) {
							System.out.print("\t");
						}else {
							System.out.print(result + "\t");
							break out;
						}
					} else {
						System.out.print(result + "\t");
					}

				}
				System.out.println("\n");
			}
		}
	}
}
