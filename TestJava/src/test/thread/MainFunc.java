package test.thread;

public class MainFunc {
	int status = 0;
	public void start() {
		TestWait myThead = new TestWait();
		Thread thread = new Thread(myThead);
		myThead.setMainFunc(this);
		synchronized (thread) {
			// 启动线程
			System.out.println(Thread.currentThread().getName() + " start t1");
			thread.start();

			MergeThread mThead = new MergeThread();
			mThead.setMainFunc(this);
			Thread mthread2 = new Thread(mThead);
			mthread2.start();
			
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
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFunc mainFunc = new MainFunc();
		mainFunc.start();
	}

}
