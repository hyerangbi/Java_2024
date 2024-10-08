package p.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.Scanner;

public class TCPClient {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		
		// 요청하고자 하는 서버 : 192.168.30.15
		// 포트번호 : 3000
		
		int port = 3000;
		String serverIp = "192.168.30.15";
		
		Socket socket = null;
		
		 
		try {
			// ⑴ 서버로 연결 요청을 보내는 구문(연결을 요청하고자 하는  서버의 ip와 지정된 포트를 전달)
			socket = new Socket(serverIp, port);
			//만약 통신에 실패했다면 null값이 socket객체에 담김
			
			if(socket != null) {
				System.out.println("서버와 연결 성공");
				
				// ⑵ 서버와 입출력기반 스트림 생성
				// ⑶ 보조스트림을 활용해서 성능 개선
				
				
				
				// 입력용 스트림
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				// 출력용 스트림
				pw = new PrintWriter(socket.getOutputStream());
				
				while(true) {
					System.out.println("서버에게 보낼 내용 : ");
					String sendMessage = sc.nextLine();
					pw.println(sendMessage); // 입력 받은 내용 스트림에 담기
					pw.flush(); // 스트림에 담겨있는 내용을 강제로 보냄
					
					String message = br.readLine();
					System.out.println("서버로부터 전달받은 메세지 : " + message);
				}
			}
			// ⑷ 클라이언트와 입출력 기반 스트림 생성(바이트스트림 밖에 안됨)
			// ⑸ 보조스트림을 활용해서 성능개선
		
		} catch (IOException e) {			
			e.printStackTrace();
		}finally {
			try {
				pw.close();
				br.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
