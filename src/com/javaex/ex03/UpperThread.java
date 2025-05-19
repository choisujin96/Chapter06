package com.javaex.ex03;

public class UpperThread extends Thread {

	//대문자

	//필드
	
	//생성자
	public UpperThread() {
		
	}
	
	//메소드gs
	
	//메소드일반

	public void run() {
		
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
