package com.javaex.ex03;

public class MainApp {

	public static void main(String[] args) {

		//쓰레드 생성
		Thread dt = new DigitThread();
		Thread lt = new LowerThread();
		Thread ut= new UpperThread();
		
		
		//쓰레드 실행
		dt.start();
		lt.start();
		ut.start();
		
		
	}

}
