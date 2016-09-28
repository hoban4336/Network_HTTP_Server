package threadtest;

import obj_thread.AlpahbetThread;
import obj_thread.DigitThread;

public class MultithreadEx02 extends Thread{
	
	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlpahbetThread();
		
		thread1.start();
		thread2.start();
	}
	

}
