package obj_thread;

public class AlpahbetThread extends Thread {

	@Override
	public void run() {
		for(char c = 'A'; c<='Z';c++){	
			System.out.print(c);
		}
	}
}
