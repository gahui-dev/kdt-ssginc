package com.java.class15.fileManager;

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
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManager {
	private static final String ROOT_PATH
	= Paths.get(File.separator + "Users", "GAHUI", "Documents", "test").toString();

	private static String currentPath = ROOT_PATH;

	public static void fileManagement(Scanner sc) {
		while(true) {
			showFileSubDirectory(currentPath);
			inputCommand(sc);
		}
	}

	public static File inputCommand(Scanner sc) {
		while (true) {
			System.out.print(currentPath + " > ");
			String command = sc.nextLine();

			String targetPath;
			String sourceFile;

			switch(command.split(" ")[0]) {
			case "dir" :
				showFileSubDirectory(currentPath);
				break;
			case "mkdir" :
				makeDirectory(command, currentPath);
				break;
			case "cd" :
				currentPath = changeDirectory(command, currentPath);
				break;
			case "type" :
				sourceFile = command.split(" ")[1];
				readFile(currentPath, sourceFile);
				break;
			case "copy" :
				sourceFile = command.split(" ")[1];
				targetPath = command.split(" ")[2];
				copyFile(sourceFile, targetPath);
				System.out.println("파일 복사가 완료되었습니다. ");
				break;
			case "move" :
				sourceFile = command.split(" ")[1];
				targetPath = command.split(" ")[2];
				moveFile(sourceFile, targetPath);
				System.out.println("파일 이동이 완료되었습니다. ");
				break;
			case "exit" :
				System.out.println("시스템이 종료되었습니다.");
				System.exit(0);
			default:
				System.out.println("잘못된 명령어입니다.");
			}
		}
	}

	// dir
	public static void showFileSubDirectory(String currentPath) {
		File directory = new File(currentPath);
		File[] files = directory.listFiles();

		ArrayList<Integer> subDirectories = new ArrayList<Integer>();
		SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd a hh:mm");

		System.out.println("============================================================");
		for (int i = 0; i < files.length; i++) {
			String attr = "";

			if (files[i].isDirectory()) {
				attr = "<DIR>";
				subDirectories.add(i);
			}
			System.out.println(timestamp.format(new Date(files[i].lastModified()))
					+ "\t" + attr + "\t" + files[i].getName());
		}

		int directoryCount = subDirectories.size();
		int fileCount = files.length - directoryCount;

		System.out.println("\n" + directoryCount + "개의 디렉토리, " + fileCount + "개의 파일");
		System.out.println("============================================================");
	}

	// cd
	private static String changeDirectory(String command, String currentPath) {
		String target = command.split(" ")[1];

		// 상위 경로 이동
		if (target.equals("..")) {	
			String root= Paths.get(File.separator + "Users").toString();

			if(!currentPath.equals(root)) {
				currentPath = currentPath.substring(0, currentPath.lastIndexOf("\\"));
				showFileSubDirectory(currentPath);
			} else {
				System.out.println("접근할 수 없습니다.");	
			}	

			// ROOT_PATH 이동
		} else if (target.equals("\\")) {
			currentPath = ROOT_PATH;
			showFileSubDirectory(currentPath);

			// 폴더 이동
		} else {
			target = command.substring(3);

			String targetPath = Paths.get(currentPath + File.separator + target).toString();
			File targetDirectory = new File(targetPath);

			if(targetDirectory.exists() && targetDirectory.isDirectory()) {
				currentPath = targetPath;
				showFileSubDirectory(currentPath);
			} else {
				System.out.println("디렉토리가 아닙니다. ");
			}
		}

		return currentPath;
	} 

	// mkdir 
	private static void makeDirectory(String command, String currentPath) {
		String target = command.substring(6);

		if(!target.contains(" ")) {
			File directory = new File(currentPath + File.separator + target);

			if(!directory.exists()) {
				directory.mkdir();
				System.out.println(target + " 폴더가 생성되었습니다. ");

				showFileSubDirectory(currentPath);
			} else {
				System.out.println("이미 폴더가 존재합니다. ");
			}		
		} else {
			System.out.println("공백은 포함할 수 없습니다. ");
		}


	}

	// type
	private static void readFile(String currentPath, String sourceFile) {
		boolean isTxt = false;
		if(extensionClassification(sourceFile).equals("txt")) {
			isTxt = true;
		}

		if(isTxt) {
			try(BufferedReader br = new BufferedReader(new FileReader(currentPath + File.separator +sourceFile));) {
				System.out.println("============================================================\n");
				String line = null;
				while((line = br.readLine()) != null) {
					System.out.println(line);
				}
				System.out.println("\n============================================================");
			} catch(FileNotFoundException e) {
				// e.printStackTrace();
				System.out.println("파일이 존재하지 않습니다. ");
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("텍스트 파일만 읽을 수 있습니다. ");
		}
	}

	// copy
	public static void copyFile(String sourceFile, String targetPath) {
		String sourceFilePath = Paths.get(currentPath + File.separator + sourceFile).toString();
		String targetFilePath = Paths.get(currentPath + File.separator + targetPath + File.separator + sourceFile).toString();

		String extension = extensionClassification(sourceFile);

		try {
			if (extension.equals("txt")) {
				try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath));
						BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePath));) {
					String line = null;
					while ((line = br.readLine()) != null) {
						bw.write(line);
						bw.newLine();
						bw.flush();
					}
				}
			} else {
				try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFilePath));) {
					byte buff[] = new byte[1024];
					while (bis.available() > 0) {
						bis.read(buff, 0, buff.length);
						bos.write(buff, 0, buff.length);
						bos.flush();
					}
				}
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("존재하지 않는 폴더입니다. ");
			inputCommand(new Scanner(System.in));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// move
	public static void moveFile(String sourceFile, String targetPath) {
		copyFile(sourceFile, targetPath);
		removeFile(sourceFile);
	}

	// remove
	public static void removeFile(String sourcePath) {
		String sourceFilePath = Paths.get(currentPath + File.separator + sourcePath).toString();
		File deleteFile = new File(sourceFilePath);
		deleteFile.delete();
	}

	// 확장자
	public static String extensionClassification(String absoluteFilePath) {
		String extension = absoluteFilePath.substring(absoluteFilePath.lastIndexOf(".") + 1);
		return extension;
	}
}
