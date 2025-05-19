package com.javaex.ex02;

public class MainApp {

	public static void main(String[] args) {

		//숫자 출력 --> 출장 --> Thread
		
		Thread dt = new DigitThread();//쓰레드 생성
		dt.start(); //쓰레드생성 
		//run으로 안하는 이유는 출장이 작동을 안함. 반드시 주의하셈. 
		
		
		
		
		//문자 출력 --> 메인
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
		
			try {
				Thread.sleep(1000); //1000은 1초
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		 
	}

}
