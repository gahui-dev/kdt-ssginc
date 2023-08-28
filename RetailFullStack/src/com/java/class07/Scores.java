package com.java.class07;

import java.util.Scanner;

public class Scores {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      // 01. 인원, 과목 수 입력 후 배열 생성
      int personCount = getCount(sc, "몇 명의 인원이 있나요? > ");
      int subjectCount = getCount(sc, "몇 개의 과목을 입력할래요? > ");
      
      int[][] scores = new int[personCount][subjectCount];
      // 02. 과목 배열 삽입
      Input(scores, sc);
      // 03. 배열에 들어가있는 값 출력
      Output(scores);
   }
   
   public static int getCount(Scanner sc, String message) {
      System.out.print(message);
      int count = sc.nextInt();
      return count;
   }
   // 02. 과목 배열 삽입
   public static void Input(int[][] scores, Scanner sc) {
      for(int i = 0; i < scores.length; i++) {
         for(int j = 0; j < scores[i].length; j++ ) {
            System.out.println((i + 1) + "번째 인원의 " + (j + 1)  + "번째 과목 점수를 입력해주세요");
            int score = sc.nextInt();
            scores[i][j] = score;
         }
      }
   }
   // 03. 배열에 들어가있는 값 출력
   public static void Output(int[][] scores) {
      int totalScore;
      for (int i = 0; i < scores.length; i++) {
    	  totalScore = 0;
         for(int j = 0; j < scores[i].length; j++ ) { 
            System.out.println((i + 1) + "번째 인원의 " + (j + 1) + "번째 과목 점수는 " + scores[i][j] + "점입니다."); 
            totalScore += scores[i][j];
         }
         double avgScore = (double)totalScore / scores[i].length;
         System.out.println((i + 1) + "번째 인원의 총점은 " + totalScore + "점 입니다.");
         System.out.println((i + 1) + "번째 인원의 " + scores.length + "과목의 평균은 " + avgScore + " 점 입니다. \n");
        }
   }
}