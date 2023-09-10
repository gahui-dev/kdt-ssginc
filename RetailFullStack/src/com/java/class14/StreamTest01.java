package com.java.class14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StreamTest01 {

	public static void main(String[] args) {
		//System.in
		//System.out

		Scanner scanner = new Scanner(System.in);
		//scanner.next();
		//java.io.InputStream
		// |
		// FileInputStream

		String sourcePath = "C:\\USERS" + "\\GAHUI" + "\\Documents" + "\\testInputStream.txt";

		sourcePath = "C:" + File.separator +"Users"
				+ File.separator + "GAHUI"
				+ File.separator + "Documents"
				+ File.separator + "testInputStream.txt";

		sourcePath = Paths.get("C:", "Users", "GAHUI", "Documents", "video.mp4").toString();
		String targetPath = Paths.get("C:", "Users", "GAHUI", "Documents", "video_복사본.mp4").toString();
		copyAndPaste4Data(targetPath, sourcePath);

		// ArrayList<Integer> datas = readData(sourcePath); // 복사
		// writeData(datas, targetPath);  // 붙여넣기
	}
	
	public static void copyAndPaste4Data(String target, String source) {
		try(
				FileInputStream fis = new FileInputStream(source);
				FileOutputStream fos = new FileOutputStream(target);) {
			byte buff[] = new byte[1024];
			System.out.println("복사를 시작하였습니다.");
			while(fis.read(buff, 0, buff.length) > -1) {
				fos.write(buff, 0, buff.length);
				fos.flush();
			}
			System.out.println("붙여넣기를 완료하였습니다.");
		} catch(FileNotFoundException ffe) {
			ffe.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<Integer> readData(String path) {
		
		ArrayList<Integer> datas = null;
		try(FileInputStream fis = new FileInputStream(path);) {
			// EOF
			int data = 0;
			int cnt = 0;
			datas = new ArrayList();

			while((data = fis.read()) != -1) {
				System.out.println(cnt++ + " : " + data);
				datas.add(data);
			}
		} catch(FileNotFoundException e) {
			System.out.println("파일이 해당경로에 없습니다.");
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}		
		return datas;
	}
	
	private static void writeData(ArrayList<Integer> datas, String targetPath) {
		try(FileOutputStream fos = new FileOutputStream(targetPath);) {
			// EOF
			int data = 0;
			int cnt = 0;
			int idx = 0;
			datas = new ArrayList();
			System.out.println("붙여넣기를 시작합니다.");
			while(idx < datas.size()) {
				data = datas.get(idx++);
				fos.write(idx);
			}
			System.out.println("붙여넣기를 완료합니다.");
		} catch(FileNotFoundException e) {
			System.out.println("파일이 해당경로에 없습니다.");
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
