package com.javaex.ex02;

public class DigitThread extends Thread {
	
	
	
	//필드
	
	
	//생성자
	public DigitThread() {
		
	}

	
	//메소드gs

	
	//메소드일반
	

	//숫자 출력 --> 출장
	public void run() { //run은 임의로 다른 걸 하면 안됨.
		
		for(int i=0; i<=30; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000); //1000은 1초
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	

}
