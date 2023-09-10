package com.java.class16.server;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ServerInput {
	public static void main(String[] args) {

		System.out.println("<<Server>>");
		try {
			/* 소켓 생성 및 연결 대기 */
			Socket client = null;
			int port = 5000;

			ServerSocket server = new ServerSocket();
			server.bind(new InetSocketAddress(port));
			System.out.println("클라이언트 연결 대기중 ...");

			/* 클라이언트 연결 */
			client = server.accept();
			System.out.println("클라이언트와 서버가 연결되었습니다.");
			System.out.println("[ Client IP ] " + client.getInetAddress().getHostAddress() + "\n[ Port ]" + port);
			System.out.println("=================================");

			/* [서버<-클라이언트] 클라이언트에게 받은 명령어를 출력 */
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			Receiver receiver = new Receiver(client);
			receiver.start();

			/* [서버->클라이언트] 클라이언트에게 명령어를 전송 */
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			Scanner scanner = new Scanner(System.in);

			System.out.print("\n서버 > ");
			while (true) {
				String command = scanner.nextLine();
				bw.write(command + "\n");
				bw.flush();
				if (command.equals("copy")) {
					sendFile(client);
				}
				Thread.sleep(500);
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("서버 입출력 예외가 발생하였습니다. ex)클라이언트 연결 끊김");
		} catch (InterruptedException e) {
			// e.printStackTrace();
			System.out.println("스레드 인터럽트가 발생하였습니다.");
		}

		System.out.println("서버를 종료합니다.");
	}

	public static void sendFile(Socket client) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("전송할 파일 경로를 입력하세요:");
		// C:\Users\Public\Documents\test\test.txt

		String sendFilePath = sc.nextLine();
		File inputFile = new File(sendFilePath);

		if (!inputFile.exists() || !inputFile.isFile()) {
			System.out.println("파일을 찾을 수 없거나 파일이 아닙니다.");
			return;
		}

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
		OutputStream os = client.getOutputStream();
		byte[] buff = new byte[1024];
		int bytesRead;

		while ((bytesRead = bis.read(buff)) != -1) {
			os.write(buff, 0, bytesRead);
		}

		os.flush();
		System.out.println("파일이 성공적으로 전송되었습니다.");
	}

}

/* [서버<-클라이언트] 클라이언트에게 받은 명령어를 출력 */
//class Receiver extends Thread {
//	Scanner sc = new Scanner(System.in);
//	private Socket socket;
//
//	public Receiver(Socket socket) {
//		this.socket = socket;
//	}
//
//	@Override
//	public void run() {
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
//			while (true) {
//				System.out.println("클라이언트>" + br.readLine());
//				Thread.sleep(2000);
//
//			}
//
//		} catch (IOException e) {
//			System.out.println("\n클라이언트와의 연결이 끊겼습니다");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//}