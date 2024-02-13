package com.java.class14.fileManager;

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class TotalTest {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      /* 0. 지정된 디렉터리 리스트 출력 */

      String mainDirectory = "E:\\Users";
      System.out.println("==지정된 디텍터리의 파일 보기==");
      showFileSubDirectory(mainDirectory);

      /* 파일 명 입력 받기 */
      System.out.println("==변경할 파일 입력하기==");
      File file = inputFileName(mainDirectory, sc);

      /* 확장자 분류 */
      String absoluteFilePath = file.getAbsolutePath();
      System.out.println(absoluteFilePath);
      String extension = absoluteFilePath.substring(absoluteFilePath.lastIndexOf(".") + 1);

      switch (extension) {
      case "txt":
         System.out.println("버퍼리더라이터 실행");
         Object directoryPath;
         BufferedReadWriter(mainDirectory, absoluteFilePath, extension, sc);
         // 하위 폴더의 파일을 변경하는 것을 만들지 못함 -> 소스페스말고 디렉토리 페스를 이용
         break;
      case "mp4":
      case "jpg":
      case "png":
         System.out.println("버퍼스트림 실행");
         BufferedStream(mainDirectory, absoluteFilePath, extension, sc);

         break;
      default:
         System.out.println("기능을 수행할 수 없는 확장자입니다.");

      }
   }

   public static void showFileSubDirectory(String directoryPath) {
      File directory = new File(directoryPath);
      File files[] = directory.listFiles();

      for (File f : files) {
         if (f.isDirectory()) {
            System.out.println("\t**하위 폴더**");
            showFileSubDirectory(f.getPath());
         } else {
            String fileName = f.toString();
            fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
            System.out.println("파일 명 : " + fileName);

         }
      }
   }

   public static File inputFileName(String mainDirectory, Scanner sc) {
      while (true) {
         System.out.print("파일 명을 입력하세요 >>");
         String inputFileName = sc.nextLine();
         File file = new File(mainDirectory + "\\" + inputFileName);
         System.out.println("=> 입력하신 파일 경로 : " + file);

         if (file.exists()) {
            
            return file;
         } else {
            System.out.println("잘못 입력하셨습니다.");
         }
      }
   }

   public static void BufferedReadWriter(String mainDirectory, String sourcePath, String extension, Scanner sc) {

      int selectFunction = 1;

      while (true) {
         System.out.println("==기능 선택==");
         System.out.println("1. 복사");
         System.out.println("2. 이동");
         System.out.println("3. 출력");
         System.out.println("==============");
         System.out.print("입력 >> ");
         selectFunction = Integer.parseInt(sc.nextLine());
         if (selectFunction == 1 || selectFunction == 2 || selectFunction == 3) {
            break;
         } else {
            System.out.println("잘못 입력하셨습니다.");
         }
      }

      switch (selectFunction) {
      case 1:
         copyAndPaste4TextFile(mainDirectory, sourcePath, extension, sc);
         break;
      case 2:
         cutAndPaste4TextFile(mainDirectory, sourcePath, extension, sc);
         break;
      case 3:
         PrintConsole4TextFile(mainDirectory, sourcePath, extension, sc);
         break;
      }

      /* 복사붙여넣기 */
   }

   public static boolean copyAndPaste4TextFile(String mainDirectory, String sourcePath, String extension, Scanner sc) {
      String targetPath = null;
      String targetFileName = null;

      /* 파일명 입력 */

      while (true) {
         System.out.print("붙여넣기할 파일명을 입력해주세요>>");
         targetFileName = sc.nextLine();
         String targetExtension = targetFileName.substring(targetFileName.lastIndexOf(".") + 1);
         if (targetExtension.equals(extension)) {
            break;
         } else {
            System.out.println("해당 파일의 확장자 : " + extension + ", 입력한 파일의 확장자 : " + targetExtension);
            System.out.println("확장자가 잘못되었습니다.");
         }
      }
      System.out.println("=> 파일명 : " + targetFileName);

      /* 폴더 설정 */
      System.out.println("해당 폴더에 붙여넣겠습니까? [1. 예/ 2. 아니오]");
      System.out.print("입력 >>");

      int pasteThisDirectory = Integer.parseInt(sc.nextLine());
      if (pasteThisDirectory == 1) {
         targetPath = mainDirectory;
         System.out.println("=> 절대주소 : " + targetPath);
      } else if (pasteThisDirectory == 2) {
         System.out.print("붙여넣기할 디렉터리(절대주소)를 입력해주세요>>");
         targetPath = sc.nextLine();
         System.out.println("=> 절대주소 : " + targetPath);
      } else {
         System.out.println("잘못 입력하셨습니다.");
         return false;
      }

      File file = new File(targetPath);
      if (file.mkdir()) {
         System.out.println("폴더를 새로 생성하였습니다.");
      }

      /* 생성부분 */
      try (BufferedReader br = new BufferedReader(new FileReader(sourcePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath + File.separator + targetFileName));) {
         System.out.println("복사를 시작합니다");
         String line = null;
         while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
         }

         System.out.println("붙여넣기를 완료했습니다");
         System.out.println("=> 파일 절대 주소 : " + targetPath + File.separator + targetFileName);
      } catch (FileNotFoundException fnfe) {
         fnfe.printStackTrace();

      } catch (Exception e) {
         e.printStackTrace();
      }
      return true;
   }

   public static boolean cutAndPaste4TextFile(String mainDirectory, String sourcePath, String extension, Scanner sc) {

      String targetPath = null;
      String targetFileName = null;

      /* 파일명 입력 */

      while (true) {
         System.out.print("잘라넣기할 파일명을 입력해주세요>>");
         targetFileName = sc.nextLine();
         String targetExtension = targetFileName.substring(targetFileName.lastIndexOf(".") + 1);
         if (targetExtension.equals(extension)) {
            break;
         } else {
            System.out.println("해당 파일의 확장자 : " + extension + ", 입력한 파일의 확장자 : " + targetExtension);
            System.out.println("확장자가 잘못되었습니다.");
         }
      }

      System.out.println("=> 파일명 : " + targetFileName);
      System.out.print("잘라넣기할 디렉터리(절대주소)를 입력해주세요>>");
      targetPath = sc.nextLine();
      System.out.println("=> 절대주소 : " + targetPath);

      File file = new File(targetPath);

      if (file.mkdir()) {
         System.out.println("폴더를 새로 생성하였습니다.");
      }

      /* 생성부분 */
      try (BufferedReader br = new BufferedReader(new FileReader(sourcePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath + File.separator + targetFileName));) {
         System.out.println("복사를 시작합니다");
         String line = null;
         while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
         }

         System.out.println("붙여넣기를 완료했습니다");
         System.out.println("=> 파일 절대 주소 : " + targetPath + File.separator + targetFileName);
      } catch (FileNotFoundException fnfe) {
         fnfe.printStackTrace();

      } catch (Exception e) {
         e.printStackTrace();
      }

      /* 삭제 */
      File deleteFile = new File(sourcePath);
      deleteFile.delete();

      return true;
   }

   public static boolean PrintConsole4TextFile(String mainDirectory, String sourcePath, String extension, Scanner sc) {

      /* 생성부분 */
      try (BufferedReader br = new BufferedReader(new FileReader(sourcePath));) {
         System.out.println("스캔을 시작합니다");
         String line = null;
         while ((line = br.readLine()) != null) {
            System.out.println(line);
         }

         System.out.println("출력을 완료했습니다");
      } catch (FileNotFoundException fnfe) {
         fnfe.printStackTrace();

      } catch (Exception e) {
         e.printStackTrace();
      }
      return true;
   }

   public static void BufferedStream(String mainDirectory, String sourcePath, String extension, Scanner sc) {

      int selectFunction = 1;

      while (true) {
         System.out.println("====기능 선택====");
         System.out.println("1. 복사");
         System.out.println("2. 이동");
         System.out.println("==============");
         System.out.print("입력 >> ");
         selectFunction = Integer.parseInt(sc.nextLine());
         if (selectFunction == 1 || selectFunction == 2) {
            break;
         } else {
            System.out.println("잘못 입력하셨습니다.");
         }
      }

      switch (selectFunction) {
      case 1:
         copyAndPaste4ImageFile(mainDirectory, sourcePath, extension, sc);
         break;
      case 2:
         cutAndPaste4ImageFile(mainDirectory, sourcePath, extension, sc);
         break;
      }

      /* 복사붙여넣기 */
   }

   public static boolean copyAndPaste4ImageFile(String mainDirectory, String sourcePath, String extension,
         Scanner sc) {
      String targetPath = null;
      String targetFileName = null;

      /* 파일명 입력 */

      while (true) {
         System.out.print("붙여넣기할 파일명을 입력해주세요>>");
         targetFileName = sc.nextLine();
         String targetExtension = targetFileName.substring(targetFileName.lastIndexOf(".") + 1);
         if (targetExtension.equals(extension)) {
            break;
         } else {
            System.out.println("해당 파일의 확장자 : " + extension + ", 입력한 파일의 확장자 : " + targetExtension);
            System.out.println("확장자가 잘못되었습니다.");
         }
      }
      System.out.println("=> 파일명 : " + targetFileName);

      /* 폴더 설정 */
      System.out.println("해당 폴더에 붙여넣겠습니까? [1. 예/ 2. 아니오]");
      System.out.print("입력 >>");

      int pasteThisDirectory = Integer.parseInt(sc.nextLine());
      if (pasteThisDirectory == 1) {
         targetPath = mainDirectory;
         System.out.println("=> 절대주소 : " + targetPath);
      } else if (pasteThisDirectory == 2) {
         System.out.print("붙여넣기할 디렉터리(절대주소)를 입력해주세요>>");
         targetPath = sc.nextLine();
         System.out.println("=> 절대주소 : " + targetPath);
      } else {

         System.out.println("잘못 입력하셨습니다.");
         return false;
      }

      File file = new File(targetPath);
      if (file.mkdir()) {
         System.out.println("폴더를 새로 생성하였습니다.");
      }

      /* 생성부분 */
      try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
            BufferedOutputStream bos = new BufferedOutputStream(
                  new FileOutputStream(targetPath + File.separator + targetFileName));

      ) {
         System.out.println("복사를 시작합니다");
         byte buff[] = new byte[1024];
         while (bis.available() > 0) {
            bis.read(buff, 0, buff.length);
            bos.write(buff, 0, buff.length);
            bos.flush();
         }

         System.out.println("붙여넣기를 완료했습니다");
         System.out.println("=> 파일 절대 주소 : " + targetPath + File.separator + targetFileName);
      } catch (FileNotFoundException fnfe) {
         fnfe.printStackTrace();

      } catch (Exception e) {
         e.printStackTrace();
      }
      return true;
   }

   public static boolean cutAndPaste4ImageFile(String mainDirectory, String sourcePath, String extension, Scanner sc) {

      String targetPath = null;
      String targetFileName = null;

      /* 파일명 입력 */

      while (true) {
         System.out.print("잘라넣기할 파일명을 입력해주세요>>");
         targetFileName = sc.nextLine();
         String targetExtension = targetFileName.substring(targetFileName.lastIndexOf(".") + 1);
         if (targetExtension.equals(extension)) {
            break;
         } else {
            System.out.println("해당 파일의 확장자 : " + extension + ", 입력한 파일의 확장자 : " + targetExtension);
            System.out.println("확장자가 잘못되었습니다.");
         }
      }

      System.out.println("=> 파일명 : " + targetFileName);
      System.out.print("잘라넣기할 디렉터리(절대주소)를 입력해주세요>>");
      targetPath = sc.nextLine();
      System.out.println("=> 절대주소 : " + targetPath);

      File file = new File(targetPath);

      if (file.mkdir()) {
         System.out.println("폴더를 새로 생성하였습니다.");
      }

      /* 생성부분 */
      try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
            BufferedOutputStream bos = new BufferedOutputStream(
                  new FileOutputStream(targetPath + File.separator + targetFileName));

      ) {
         System.out.println("복사를 시작합니다");
         byte buff[] = new byte[1024];
         while (bis.available() > 0) {
            bis.read(buff, 0, buff.length);
            bos.write(buff, 0, buff.length);
            bos.flush();
         }

         System.out.println("붙여넣기를 완료했습니다");
         System.out.println("=> 파일 절대 주소 : " + targetPath + File.separator + targetFileName);
      } catch (FileNotFoundException fnfe) {
         fnfe.printStackTrace();

      } catch (Exception e) {
         e.printStackTrace();
      }

      /* 삭제 */
      File deleteFile = new File(sourcePath);
      deleteFile.delete();

      return true;
   }

}