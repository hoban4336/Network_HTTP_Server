package RunnableTest;

import obj_thread.AlpahbetThread;
import obj_thread.DigitThread;

public class MultithreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlpahbetThread();
		
		//thread �����ڿ� runnable�� �ִ� ����? ALT+CLICK !
		Thread thread3 = new Thread(new UpperCaseAlphabet());
		
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
