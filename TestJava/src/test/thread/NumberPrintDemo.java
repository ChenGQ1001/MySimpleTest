package test.thread;

public class NumberPrintDemo {

	public static void main(String[] args) {
		final Business business = new Business();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 5; i++) {
						business.print(Thread.currentThread().getName());
					}
				}
			}, i + "").start();
		}
	}
}

class Business {

	private int number = 0;

	private int state = 1;

	public synchronized void print(String name) {
		int num = Integer.parseInt(name) + 1;
		while (state != num) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 5; i++) {
			number++;
			System.out.println("线程" + num + ":" + number);
		}
		state = state % 3 + 1;
		this.notifyAll();
	}
}