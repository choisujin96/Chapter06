package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

//뉴욕
public class Client {

	public static void main(String[] args) throws IOException {
		
		//소켓생성  종이컵전화기
		Socket socket = new Socket();
		
		System.out.println("클라이언트 시작");
		System.out.println("======================");
		
		//서버에 연결
		System.out.println("[서버에 연결을 요청합니다.]");
		
		socket.connect(new InetSocketAddress("192.168.0.96", 10001));	
		
		// 쓰기 스트림
		//OutputStream out = new FileOutputStream("C:\\javaStudy\\MS949-copy.txt");
	
		OutputStream out = socket.getOutputStream();  //주스트림
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		//읽기 스트림 준비
		InputStream in = socket.getInputStream();//주스티림
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
	
		
		//스캐너 준비
		Scanner sc = new Scanner(System.in);
	
		
		//------------------------------------
		
		while(true) {
			//메세지 키보드로 입력받기
			String msg = sc.nextLine(); //입력대기
				
			if("/q".equals(msg)) { //종료조건
				break;
			}
			
			//--> 메세지를 보낸다.
			bw.write(msg);
			bw.newLine(); //줄바꿈
			bw.flush();  //꽉안차도 보내라
			
			
			//메세지를 받는다.
			String reMsg = br.readLine();
			System.out.println("server:[" + reMsg + "]");			
			
		}
		
		System.out.println("======================================");
		System.out.println("<클라이언트 종료>");
		
		//닫기
		sc.close();
		bw.close();
		br.close();
		socket.close();
	}

}
