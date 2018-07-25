package test.thread;

public class MergeThread implements Runnable{
	MainFunc mainFunc;
	public void setMainFunc(MainFunc mainFunc){
		this.mainFunc = mainFunc;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName() + " run MergeThread");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mainFunc == null) {
			System.out.println("mainFunc is null");
		}
		mainFunc.status = 1;
	}
}
