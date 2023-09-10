package com.java.class16.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

class Receiver extends Thread {
	private Socket socket;

	public Receiver(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {

			while (true) {
				// 클라이언트한테 온 메세지				
				String command = br.readLine();
				System.out.println("[클라이언트 요청] " + command);
				
				switch(command.split(" ")[0]) {
				case "dir" :
					String dir = ServerFileManager.showFileSubDirectory();
					Server.sender(bw, dir);
					break;
				case "type" : 
					String sourceFile = command.split(" ")[1];
					String read = ServerFileManager.readFile(sourceFile);
					Server.sender(bw, read);
					break;
				case "copy" :
					sourceFile = command.split(" ")[1];
					String targetPath = command.split(" ")[2];
					ServerFileManager.copyFile(sourceFile, targetPath);
					Server.sender(bw, "[서버] 파일 복사가 완료되었습니다. \n");
					System.out.println("파일 복사 완료");
					break;
				default:
					Server.sender(bw, "[서버] 잘못된 명령어를 입력했습니다. \n");
					System.out.println("잘못된 명령어 입력");
				}
				Thread.sleep(1000);
			}

		} catch (IOException e) {
			System.out.println("[ 클라이언트와의 연결이 끊겼습니다. ] ");

		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

}

