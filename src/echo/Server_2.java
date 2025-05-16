package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_2 {

	public static void main(String[] args) throws IOException {

		ServerSocket serversocket = new ServerSocket();
		serversocket.bind(new InetSocketAddress("192.168.0.35", 10001));
		
		//서버시작
		System.out.println("<서버 시작>");
		System.out.println("------------------");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		//종이컵 전화기
		Socket socket = serversocket.accept();
		System.out.println("[클라이언트가 연결되었습니다.]");
		
		//읽기 스트림준비
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//쓰기 스트림준비
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		while(true) {
			String msg = br.readLine();
			System.out.println("받은메세지:" + msg);
			
			if(msg == null) {
				break;
			}
			
			bw.write(msg);
			bw.newLine();
			bw.flush();
			
		}
		
		System.out.println("------------");
		System.out.println("<서버종료>");
		
		br.close();
		bw.close();
		socket.close();
		serversocket.close();
		
	}

}
