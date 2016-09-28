package RunnableTest;

public class CommonClass {
	//쓰레드로 구현이 되지 않은 라이브러리의 메서드를 thread에 태우고 싶을때 구현하는것.
	protected void print() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c);
		}
	}

}
