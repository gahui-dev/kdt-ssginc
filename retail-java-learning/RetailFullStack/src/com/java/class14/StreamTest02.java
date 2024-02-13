package com.java.class14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class StreamTest02 {

	public static void main(String[] args) throws FileNotFoundException {
		String sourcePath = "C:" + File.separator +"Users"
				+ File.separator + "GAHUI"
				+ File.separator + "Documents"
				+ File.separator + "testInputStream.txt";

		sourcePath = Paths.get("C:", "Users", "GAHUI", "Documents", "test", "video.mp4").toString();
		String targetPath = Paths.get("C:", "Users", "GAHUI","Documents", "test2").toString();

		String fileName= "video_복사본.mp4";

		File file = new File(targetPath);
		if(file.mkdir()) {
			System.out.println("타겟 경로를 설정하였습니다.");
		}

//		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
//				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetPath + file.separator + fileName));	
//				) {
//			System.out.println("복사를 시작합니다.");
//			byte[] buff = new byte[1024];
//			while(bis.available() > 0) {
//				bos.write(buff, 0, buff.length);
//			}
//			System.out.println("붙여넣기를 완료하였습니다.");
//			System.out.println("경로: " + targetPath + file.separator  + fileName);
//		} catch(Exception e) {
//			e.printStackTrace();
//		} 

		try( BufferedInputStream bis
				= new BufferedInputStream(new FileInputStream(sourcePath));
				BufferedOutputStream bos
				= new BufferedOutputStream(new FileOutputStream(targetPath
						+ File.separator
						+ fileName))
				){
			System.out.println("복사를 시작합니다.");
			byte[] buff = new byte[1024];
			while( bis.available() > 0 ) {
				bis.read(buff, 0, buff.length);
				bos.write(buff, 0, buff.length);
				bos.flush();
			}
			System.out.println("붙여넣기를 완료하였습니다");
			System.out.println("경로: "+targetPath + File.separator + fileName);
		}catch(Exception e) {

		}
	}

}
