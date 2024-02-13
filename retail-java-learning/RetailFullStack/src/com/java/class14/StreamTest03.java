package com.java.class14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class StreamTest03 {
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(null);
		//System.out.println();
		
		String sourcePath = Paths.get("C:", "Users", "GAHUI", "Documents", "test", "testInputStream.txt").toString();
		String targetPath = Paths.get("C:", "Users", "GAHUI","Documents", "test2", "testInputStream_복사본.txt").toString();
		
		try(
				BufferedReader br = new BufferedReader(new FileReader(sourcePath));
				BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath.toString()));
		) {
			String str;
			while((str = br.readLine()) != null) {
				System.out.println(str);
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			br.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
