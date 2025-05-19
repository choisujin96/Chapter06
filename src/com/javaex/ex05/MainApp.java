package com.javaex.ex05;

public class MainApp {

	public static void main(String[] args) {

		
		//Runnable 만들고 ()
		Runnable dt = new DigitThread(); //Run로직(숫자출력)로직
		//Thread t = new Thread(new DigitThread());
		
		//숫자 출장
		Thread t = new Thread(dt);
		t.start();
		
		//대문자 메인
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
