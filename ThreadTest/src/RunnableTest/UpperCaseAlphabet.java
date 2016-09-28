package RunnableTest;

import java.io.PrintWriter;

public class UpperCaseAlphabet extends CommonClass implements Runnable{

	//상속받은 자식에서 runnable을 구현하여 Thread 객체를 만들 클래스를 만들어 
	//다른 main class에서 Thread에 태우는 것.
	@Override
	public void run() {
		print();
	}

}
