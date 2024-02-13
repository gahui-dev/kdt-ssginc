package com.java.class14.fileManager;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String rootPath = Paths.get("E:", "Users").toString();
		String absoluteFilePath = null;

		while(true) {
			// 지정된 디렉터리 리스트 출력
			showFileSubDirectory(rootPath);

			// 파일명 입력 받기
			File file = inputFileName(rootPath, sc);
			absoluteFilePath = file.getAbsolutePath();

			// 확장자 분류하기
			String extension = extensionClassification(absoluteFilePath);

			switch (extension) {
			case "txt":
				//System.out.println("버퍼리더라이터 실행");
				txtFileManagement.showMenu(rootPath, absoluteFilePath, extension, sc);
				break;
			case "mp4":
			case "jpg":
			case "png":
				//System.out.println("버퍼스트림 실행");
				otherFileManagement.showMenu(rootPath, absoluteFilePath, extension, sc);
				break;
			default:
				System.out.println("기능을 수행할 수 없는 확장자입니다.");

			}
		}
	}

	// 디렉터리 리스트 출력
	public static void showFileSubDirectory(String directoryPath) {
		File directory = new File(directoryPath);
		File files[] = directory.listFiles();

		for (File f : files) {
			if (f.isDirectory()) {
				System.out.println("\t**하위 폴더**");
				showFileSubDirectory(f.getPath());
			} else {
				String fileName = f.toString();
				//fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
				System.out.println("파일명 : " + f.getPath());
			}
		}
	}

	// 파일명 입력받기
	public static File inputFileName(String rootPath, Scanner sc) {
		while (true) {
			System.out.println("==============================");
			System.out.print("파일명을 입력하세요 >> ");
			String inputFileName = sc.nextLine();
			File file = new File(rootPath, inputFileName);
			System.out.println("\n=> 입력하신 파일 경로 : " + file + "\n");

			if (file.exists()) {
				return file;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	// 확장자 분류하기
	public static String extensionClassification(String absoluteFilePath) {
		String extension = absoluteFilePath.substring(absoluteFilePath.lastIndexOf(".") + 1);
		return extension;
	}
}
