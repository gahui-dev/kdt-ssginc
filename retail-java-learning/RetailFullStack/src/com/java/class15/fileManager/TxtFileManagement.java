package com.java.class15.fileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TxtFileManagement {

	public static boolean showMenu(String rootPath, String sourcePath, String extension, Scanner sc) {
		while(true) {
			//System.out.println(rootPath + " / " + sourcePath);
			System.out.print("어떤 작업을 수행하시겠습니까? [1] 읽기 [2] 복사 [3] 이동 [4] 삭제 [0] 파일 선택 >> ");

			int select = sc.nextInt();
			sc.nextLine();

			switch(select) {
			case 1:
				readFile(sourcePath);
				break;
			case 2:
				copyFile(rootPath, sourcePath, extension, sc);
				break;
			case 3:
				moveFile(rootPath, sourcePath, extension, sc);
				break;
			case 4:
				removeFile(sourcePath);
				break;
			case 0:
				return true;
			default:
				System.out.println("올바른 작업을 선택해주세요.");
			}
		}
	}

	// 읽기
	private static void readFile(String sourcePath) {
		try(BufferedReader br = new BufferedReader(new FileReader(sourcePath));) {
			System.out.println("===============================\n");
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("\n===============================");
			br.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	// 복사
	public static boolean copyFile(String rootPath, String sourcePath, String extension, Scanner sc) {
		String targetPath = null;
		String targetFileName = null;

		/* 폴더 설정 */
		System.out.println("현재 폴더에 복사하시겠습니까? [1] 예 [2] 아니오 >>");
		System.out.print("입력 >> ");

		int pasteThisDirectory = Integer.parseInt(sc.nextLine());
		if (pasteThisDirectory == 1) {
			targetPath = rootPath;
			System.out.println("=> 절대경로 : " + targetPath);
		} else if (pasteThisDirectory == 2) {
			System.out.print("파일을 복사할 절대경로를 입력해주세요 >> ");
			targetPath = sc.nextLine();
			System.out.println("=> 절대경로 : " + targetPath);
		} else {
			System.out.println("잘못 입력하셨습니다.");
			return false;
		}

		File file = new File(targetPath);
		if (file.mkdir()) {
			System.out.println("폴더를 새로 생성하였습니다.");
		}

		/* 파일명 입력 */
		while (true) {
			System.out.print("생성할 파일명을 입력해주세요 >> ");
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

		/* 생성부분 */
		try (BufferedReader br = new BufferedReader(new FileReader(sourcePath));
				BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath + File.separator + targetFileName));) {
			System.out.println("복사를 시작합니다. ");
			String line = null;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
				bw.flush();
			}

			System.out.println("복사를 완료했습니다.");
			System.out.println("=> 복사 파일 경로 : " + targetPath + File.separator + targetFileName);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}


	//  이동
	public static boolean moveFile(String rootPath, String sourcePath, String extension, Scanner sc) {
		String targetPath = null;
		System.out.print("파일을 이동할 절대경로를 입력해주세요 >> ");
		targetPath = sc.nextLine();
		//System.out.println("=> 절대주소 : " + targetPath);

		File file = new File(targetPath);

		if (file.mkdir()) {
			System.out.println("폴더를 새로 생성하였습니다.");
		}

		try (
				BufferedReader br = new BufferedReader(new FileReader(sourcePath));
				BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath + File.separator + new File(sourcePath).getName()));
			) {
			System.out.println("이동을 시작합니다. ");
			String line = null;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
				bw.flush();
			}

			System.out.println("이동을 완료했습니다. ");
			System.out.println("=> 파일 절대 주소 : " + targetPath + File.separator + new File(sourcePath).getName() + "\n");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		removeFile(sourcePath);

		return true;
	}

	// 삭제
	private static void removeFile(String sourcePath) {
		File deleteFile = new File(sourcePath);
		deleteFile.delete();
	}
}
