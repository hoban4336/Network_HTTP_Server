package threadtest;

import obj_thread.DigitThread;

public class ThreadTest01 {
	public static void main(String[] args) {
		
		//2. ��Ƽ ������.
		Thread digiThread = new DigitThread();
		digiThread.start();
		
		//1. �̱� ������.
		for(char c = 'A'; c<='Z';c++){
			System.out.print(c);
		}
		
		
		


		
			
	}
}
