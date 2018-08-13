package demo;
public class SPCommTest {
	public static void main(String[] args){
		Thread spcommThread = new Thread(new SPComm());
		spcommThread.setName("Thread-MyThread");
		spcommThread.start();
	
	}
}

