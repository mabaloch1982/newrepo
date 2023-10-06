package main;

public class MyThread extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread myThread = new MyThread();
		myThread.start();
		myThread.setPriority(MAX_PRIORITY);
		MyThreadInterface interface1 = myThread.new MyThreadInterface();
		Thread thread = new Thread(interface1);
		thread.setPriority(MIN_PRIORITY);
		thread.start();
	}
	
	@Override
	public void run() {
		
		int i=1;
		while (true) {
			++i;
			System.out.println(i + " Thread 1 ");
			try {
			Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	class MyThreadInterface implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i=1;
			while (true) {
				++i;
				System.out.println(i + " Thread 2 ");
				try {
				Thread.sleep(1000);
				
				}catch(Exception e) {
					e.printStackTrace();
				}
			
			}
		}
		
		
	}
	
}
