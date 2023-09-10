package com.java.class16.server;

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

public class ServerFileManager {
	// System.out.print("C:\\Users\\GAHUI\\Documents\\test > ");
	private static final String ROOT_PATH
	= Paths.get(File.separator + "Users", "GAHUI", "Documents", "test").toString();
	private static String currentPath = ROOT_PATH;

	// 확장자
	public static String extensionClassification(String absoluteFilePath) {
		String extension = absoluteFilePath.substring(absoluteFilePath.lastIndexOf(".") + 1);
		return extension;
	}

	// dir - 디렉토리 보여주기
	public static String showFileSubDirectory() {
		File directory = new File(ROOT_PATH);
		File[] files = directory.listFiles();

		ArrayList<Integer> subDirectories = new ArrayList<Integer>();
		SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd a hh:mm");

		StringBuilder directoryList = new StringBuilder();
		directoryList.append("============================================================").append("\n");

		for (int i = 0; i < files.length; i++) {
			String attr = "";

			if (files[i].isDirectory()) {
				attr = "<DIR>";
				subDirectories.add(i);
			}
			directoryList.append(timestamp.format(new Date(files[i].lastModified())))
			.append("\t").append(attr).append("\t").append(files[i].getName()).append("\n");
		}

		int directoryCount = subDirectories.size();
		int fileCount = files.length - directoryCount;

		directoryList.append("\n").append(directoryCount).append("개의 디렉토리, ").append(fileCount).append("개의 파일").append("\n");
		directoryList.append("============================================================");

		return directoryList.toString();
	}

	// type - 텍스트 파일 읽기
	public static String readFile(String sourcePath) {
		StringBuilder readTxt = new StringBuilder();
		String sourceFilePath = Paths.get(currentPath + File.separator + sourcePath).toString();

		try(BufferedReader br = new BufferedReader(new FileReader(sourceFilePath));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				readTxt.append(line).append("\n");
			}
			br.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}

		return readTxt.toString();	
	}

	// copy - 복사
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
			fnfe.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// move - 파일 삭제
	public static void removeFile(String sourcePath) {
		String sourceFilePath = Paths.get(currentPath + File.separator + sourcePath).toString();
		File deleteFile = new File(sourceFilePath);
		deleteFile.delete();
	}
}
