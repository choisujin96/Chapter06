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

public class Client_2 {

	public static void main(String[] args) throws IOException {
		
		//소켓생성
		Socket socket = new Socket();
		System.out.println("클라이언트 시작");
		System.out.println("-------------------------");
		
		//서버에 연결
		System.out.println("[서버에 연결 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.0.35", 10001));
		
		//쓰기 스트림
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//읽기 스트림
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//스캐너 준비
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			String msg = sc.nextLine();
			
			if("/q".equals(msg)) {
				break;
			}
			
			bw.write(msg);
			bw.newLine();
			bw.flush();
			
			String reMsg = br.readLine();
			System.out.println("server: [" + reMsg + "]");
			
		}
		System.out.println("---------------------");
		System.out.println("<클라이언트 종료>");
		
		sc.close();
		bw.close();
		br.close();
		socket.close();

	}

}
