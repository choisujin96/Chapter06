package com.javaex.ex06;

public class MainApp {

	public static void main(String[] args) {

		
		Runnable dt = new DigitImpl();
		Runnable ut = new UpperImpl();
		Runnable lt = new LowImpl();
		
		
		Thread d= new Thread(dt);
		d.start();
		
		
		Thread u= new Thread(ut);
		u.start();
		
		
		Thread l= new Thread(lt);
		l.start();
		
		
		
		
	}

}
