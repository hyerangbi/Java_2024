package q.thread.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerSend implements Runnable{
	private Socket socket;
	
	@Override
	public void run() {
		try(PrintWriter pw = new PrintWriter (socket.getOutputStream());) {
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("클라이언트에게 보낼 내용 : ");
				String sendMessage = sc.nextLine();
				pw.println(sendMessage);
				pw.flush();
				
			}
		} catch (IOException e) {			
			e.printStackTrace();
		} 
		
		
	}
	
}
