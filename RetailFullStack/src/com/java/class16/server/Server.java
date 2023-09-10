package com.java.class16.server;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private static final int PORT = 5000;
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}

	public void start()  {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			// 서버 소켓 생성, 대기
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(PORT));
			System.out.println("[ " + PORT + "번 포트 서버 Client 연결 대기 중입니다. ] ");

			// 서버-클라이언트 연결 
			clientSocket = serverSocket.accept();
			System.out.println("[ Client IP ] " + clientSocket.getInetAddress().getHostAddress());

			// 스레드 생성
			Receiver receiver = new Receiver(clientSocket);
			receiver.start();

		} catch (IOException e) {
			e.printStackTrace();

		} 
	}

	public static void sender(BufferedWriter bw, String message) {
		try {
			bw.write(message + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

