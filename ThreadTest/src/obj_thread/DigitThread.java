package obj_thread;

public class DigitThread extends Thread{

	@Override
	public void run() {
		
		for(char c = '1'; c<='9';c++){
			System.out.print(c);
		}
	}
}
