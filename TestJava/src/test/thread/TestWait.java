package test.thread;

import java.util.Date;
import java.util.Scanner;

public class TestWait implements Runnable {
	static int status = 0;
	int i=0;
	MainFunc mainFunc;
	public void setMainFunc(MainFunc mainFunc){
		this.mainFunc = mainFunc;
	}
	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " run");
			while (mainFunc.status == 0) {
				try {
//					if(i == 5){mainFunc.status = 1;}
//					i++;
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println(new Date() + "我在等待 : "+i);
			}
			notify();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestWait myThead = new TestWait();
		Thread thread = new Thread(myThead);
		synchronized (thread) {
			// 启动线程
			System.out.println(Thread.currentThread().getName() + " start t1");
			thread.start();

			// 主线程等待thread通过notify() 唤醒
			System.out.println(Thread.currentThread().getName() + " wait");
			try {
				thread.wait();
				System.out.println(Thread.currentThread().getName()
						+ " continue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("wait Scanner");
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Please Enter status:");
		// status = sc.nextInt(); //读取字符串型输入
		// System.out.println("after Scanner");
	}

}
