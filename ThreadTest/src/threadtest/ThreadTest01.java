package threadtest;

import obj_thread.DigitThread;

public class ThreadTest01 {
	public static void main(String[] args) {
		
		//2. 멀티 쓰레드.
		Thread digiThread = new DigitThread();
		digiThread.start();
		
		//1. 싱글 쓰레드.
		for(char c = 'A'; c<='Z';c++){
			System.out.print(c);
		}
		
		
		


		
			
	}
}
