package test.thread;

import java.util.Date;
class OrderNum{
	public int num = 0;
}

class PrintBusiness {

	private int number = 0;

	private int state = 0;

	public synchronized void print(int num) {
		System.out.println("----线程" + num + ":" + number);
		while (state != num) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("线程" + num + ":" + number);
		number++;
		state = state + 1;
		this.notifyAll();
	}
}
public class TestPrintThrad implements Runnable{
	private OrderNum ordernum;
	
	public void setOrderNum(OrderNum ordernum) {
		this.ordernum = ordernum;
	}
	public void run() {
		synchronized (ordernum) {
			int num = Integer.parseInt(Thread.currentThread().getName());
			System.out.println("----线程" + num + ":" + ordernum.num);
			//while (true) {
				try {
					while (num != ordernum.num) {
						ordernum.wait();
					}
					//for (int i = 0; i < 2; i++) {
						System.out.println("Print:"+num);
		            //}
					ordernum.num++;
					ordernum.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			//}
		}
	}
	
	public static void startPrint1() {
		final PrintBusiness business = new PrintBusiness();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					//for (int i = 0; i < 5; i++) {
						business.print(Integer.parseInt(Thread.currentThread().getName()));
					//}
				}
			}, i + "").start();
		}
	}
	
	public static void startPrint2() {
		OrderNum ordernum = new OrderNum();
		for (int i = 0; i < 10; i++) {
			TestPrintThrad testPrintThrad= new TestPrintThrad();
			testPrintThrad.setOrderNum(ordernum);
			new Thread(testPrintThrad,i+"").start();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestPrintThrad.startPrint2();

	}

}
