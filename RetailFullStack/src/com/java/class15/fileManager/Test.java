//package com.java.class15.fileManager;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Properties;
//import java.util.Scanner;
//
//public class Test {
//	private static final String DEFAULT_PROPERTIES_PATH 
//	= Paths.get(File.separator + "Users", "GAHUI", "Documents", "test", "database", "application.ini").toString();
//	private static final String ROOT_PATH
//	= Paths.get(File.separator + "Users", "GAHUI", "Documents", "test").toString();
//	private static String currentPath = ROOT_PATH;
//
//   public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
//
//      while (true) {
//         System.out.print("로그인이 필요한 프로그램입니다. [1] 로그인 [2] 회원가입 [0] 프로그램 종료 >> ");
//
//         int select = sc.nextInt();
//         sc.nextLine();
//
//         switch (select) {
//         case 1:
//            if (loginUser(sc)) {
//               fileManagement(sc);
//            } else {
//               System.out.println("사용자 계정 정보가 일치하지 않습니다. ");
//            }
//            break;
//         case 2:
//            registerUser(sc);
//            break;
//         case 0:
//            System.out.println("프로그램을 종료합니다.");
//            System.exit(0);
//         default:
//            System.out.println("다시 선택해주세요.");
//         }
//      }
//   }
//
//   // 로그인
//   public static Boolean loginUser(Scanner sc) {
//      try (BufferedReader br = new BufferedReader(new FileReader(DEFAULT_PROPERTIES_PATH));) {
//         Properties properties = new Properties();
//
//         // loading
//         properties.load(br);
//
//         System.out.print("아이디를 입력해주세요 >> ");
//         String inputUserId = sc.nextLine();
//         System.out.print("패스워드를 입력해주세요 >> ");
//         String inputUserPwd = sc.nextLine();
//
//         String totalUser = properties.getProperty("total.user");
//         int numOfUser = totalUser != null ? Integer.parseInt(totalUser) : 0; // properties에 totalUser가
//                                                               // 정의되지 않았다면 0으로 정의
//
//         for (int i = 1; i <= numOfUser; i++) {
//            String id = properties.getProperty("id" + i);
//            String pwd = properties.getProperty(id + ".pwd");
//
//            if ((id != null && inputUserId.equals(id)) && (pwd != null && inputUserPwd.equals(pwd))) {
//               System.out.println("로그인 성공");
//               return true;
//            }
//         }
//      } catch (FileNotFoundException fnfe) {
//         fnfe.printStackTrace();
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
//      return false;
//   }
//
//   // 회원가입
//   public static void registerUser(Scanner sc) {
//      try (BufferedReader br = new BufferedReader(new FileReader(DEFAULT_PROPERTIES_PATH));) {
//         Properties properties = new Properties();
//
//         // loading
//         properties.load(br);
//
//         System.out.print("아이디를 입력해주세요 >> ");
//         String inputUserId = sc.nextLine();
//         System.out.print("패스워드를 입력해주세요 >> ");
//         String inputUserPwd = sc.nextLine();
//
//         BufferedWriter bw = new BufferedWriter(new FileWriter(DEFAULT_PROPERTIES_PATH));
//
//         int totalUsers = Integer.parseInt(properties.getProperty("total.user", "0")) + 1;
//
//         properties.setProperty("total.user", String.valueOf(totalUsers));
//         String newUserIdKey = "id" + totalUsers;
//         properties.setProperty(newUserIdKey, inputUserId);
//         properties.setProperty(inputUserId + ".pwd", inputUserPwd);
//         properties.store(bw, "Add new member");
//         bw.flush();
//
//      } catch (FileNotFoundException fnfe) {
//         fnfe.printStackTrace();
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
//   }
//
//   // 파일관리
//   public static void fileManagement(Scanner sc) {
//      while (true) {
//         showFileSubDirectory();
//
//         File file = inputCommand(sc);
//      }
//   }
//
//   public static File inputCommand(Scanner sc) {
//      while (true) {
//         System.out.print(currentPath + " > ");
//         String command = sc.nextLine();
//
//         switch (command.split(" ")[0]) {
//         case "dir":
//            showFileSubDirectory();
//            break;
//         case "cd":
//            if (command.split(" ")[1].equals("..")) {
//               // 상위 디렉토리 이동
//               System.out.println("상위 디렉토리 이동");
//               currentPath = ChangeSuperDirectory(currentPath);
//
//            } else if (command.split(" ")[1].equals("\\")) {
//               // 루트 디렉토리
//               System.out.println("\\누름");
//            } else {
//               // 폴더명 디렉토리
//               System.out.println("다른거 누름");
//            }
//            break;
//         case "copy":
//            // copy 파일이름 대상경로
//            String sourceFile = command.split(" ")[1]; // 이러면 스페이스바가 껴있는 파일명은 에러가 발생
//            String targetPath = command.split(" ")[2];
//            copyFile(sourceFile, targetPath);
//            System.out.println("파일이 복사되었습니다. ");
//            break;
//         case "move":
//            // move 파일이름 대상경로 -> 원본파일삭제
//            // .txt -> copyTxtFile
//            sourceFile = command.split(" ")[1];
//            targetPath = command.split(" ")[2];
//            moveFile(sourceFile, targetPath);
//            System.out.println("파일이 이동되었습니다. ");
//            break;
//         default:
//            System.out.println("잘못된 명령어입니다.");
//         }
//      }
//   }
//   
//   // 상위경로로 이동
//   // currentPath를 마지막에서 하나 없애야함.
//   private static String ChangeSuperDirectory(String currentPath) {
//      System.out.println("현재 경로 > " + currentPath);
//      currentPath = currentPath.substring(0, currentPath.lastIndexOf("\\"));
//      System.out.println("바뀐 경로 > " + currentPath);
//      return currentPath;
//   }
//
//   // dir - 디렉토리 출력
//   public static void showFileSubDirectory() {
//      File directory = new File(currentPath);
//      File[] files = directory.listFiles();
//
//      ArrayList<Integer> subDirectories = new ArrayList<Integer>();
//      SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
//
//      System.out.println("============================================================");
//      for (int i = 0; i < files.length; i++) {
//         String attr = "";
//
//         if (files[i].isDirectory()) { // 디렉토리(폴더)가 있는지 확인
//            attr = "<DIR>";
//            subDirectories.add(i); // 디렉토리가 있다면 리스트에 추가
//         }
//         System.out.println(
//               timestamp.format(new Date(files[i].lastModified())) + "\t" + attr + "\t" + files[i].getName());
//      }
//
//      int directoryCount = subDirectories.size();
//      int fileCount = files.length - directoryCount;
//
//      System.out.println("\n" + directoryCount + "개의 디렉토리, " + fileCount + "개의 파일");
//      System.out.println("============================================================");
//   }
//
//   public static void moveFile(String sourceFile, String targetPath) {
//      copyFile(sourceFile, targetPath);
//      removeFile(sourceFile);
//   }
//
//   public static void copyFile(String sourceFile, String targetPath) {
//      String sourceFilePath = Paths.get(currentPath + File.separator + sourceFile).toString();
//      String targetFilePath = Paths.get(currentPath + File.separator + targetPath + File.separator + sourceFile)
//            .toString();
//      String extension = extensionClassification(sourceFile);
//
//      try {
//         if (extension.equals("txt")) {
//            try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath));
//                  BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePath));) {
//               String line = null;
//               while ((line = br.readLine()) != null) {
//                  bw.write(line);
//                  bw.newLine();
//                  bw.flush();
//               }
//            }
//         } else {
//            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
//                  BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFilePath));) {
//               byte buff[] = new byte[1024];
//               while (bis.available() > 0) {
//                  bis.read(buff, 0, buff.length);
//                  bos.write(buff, 0, buff.length);
//                  bos.flush();
//               }
//            }
//         }
//      } catch (FileNotFoundException fnfe) {
//         fnfe.printStackTrace();
//
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//   }
//
//   public static void removeFile(String sourcePath) {
//      String sourceFilePath = Paths.get(currentPath + File.separator + sourcePath).toString();
//      File deleteFile = new File(sourceFilePath);
//      deleteFile.delete();
//   }
//
//   // 확장자 분류하기
//   public static String extensionClassification(String absoluteFilePath) {
//      String extension = absoluteFilePath.substring(absoluteFilePath.lastIndexOf(".") + 1);
//      return extension;
//   }
//
//}