package RunnableTest;

import java.io.PrintWriter;

public class UpperCaseAlphabet extends CommonClass implements Runnable{

	//��ӹ��� �ڽĿ��� runnable�� �����Ͽ� Thread ��ü�� ���� Ŭ������ ����� 
	//�ٸ� main class���� Thread�� �¿�� ��.
	@Override
	public void run() {
		print();
	}

}
