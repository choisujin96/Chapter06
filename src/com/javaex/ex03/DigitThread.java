package com.javaex.ex03;

public class DigitThread extends Thread{
	//숫자

	
	//필드
	
	//생성자
	public DigitThread() {
		
	}
	
	//메소드gs
	
	//메소드일반
	public void run() {
		
		for(int i=0;i<=30;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
