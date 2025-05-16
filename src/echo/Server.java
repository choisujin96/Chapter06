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

//천호동
public class Server {

	public static void main(String[] args) throws IOException {
		
		//서버소켓생성
		ServerSocket serverSocket = new ServerSocket();
		
		//##바인드##
		//ip 192.168.0.35 --> 이건 실제 내 컴퓨터의 ip를 적어야함.
		//port 10001 --> 이건 지정
	
         /*
		 InetSocketAddress ipport = new InetSocketAddress("192.168.0.35", 10001);
		 serverSocket.bind(ipport);
		  이걸 아래코드로 사용할 수 있다.
		*/ 
		 serverSocket.bind(new InetSocketAddress("192.168.0.35", 10001));
		
		 
		 //서버시작
		 System.out.println("<서버시작>");
		 System.out.println("======================");
		 System.out.println("[연결을 기다리고 있습니다.]");
		 
		 //클라이언트가 연결되면 accept() 실행이 된다.
		 //socket 종이컵전화기
		 Socket socket = serverSocket.accept();
		 System.out.println("[클라이언트가 연결 되었습니다.]");
		 
		 //읽기 스트림 준비
		 InputStream in = socket.getInputStream();
		 InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		 BufferedReader br = new BufferedReader(isr);
		 
		 
		 //쓰기 스트림 준비
		 OutputStream out = socket.getOutputStream(); //주스트림
		 OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		 BufferedWriter bw = new BufferedWriter(osw);
		 
		 //---------------------------------------------------
		
		 while(true) {
			 
			 //-->메세지를 받는다.
			 String msg = br.readLine();
			 System.out.println("받은메세지: " +  msg);
			 
			 if(msg == null) {// /q가 나오면서 죽은메세지를 받으면 끝낸다.				 
				 break;
			 }
			 
			 //메세지를 보낸다.
			 bw.write(msg);
			 bw.newLine();
			 bw.flush();	 
			 
		 }
		
		
		 //------------------------------------------
		 System.out.println("======================");
		 System.out.println("<서버종료>");
		 
		 
		 //자원정리
		 br.close();
		 bw.close();
		 socket.close();
		 serverSocket.close();
		 

	}

}
