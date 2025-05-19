package com.javaex.ex03;

public class LowerThread extends Thread{
	//소문자
	
	//숫자

	
	//필드
	
	//생성자
	public LowerThread() {
		
	}
	
	//메소드gs
	
	//메소드일반

	public void run() {
		for(char ch='a'; ch<='z'; ch++) {
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
