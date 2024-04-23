package threads;

import java.util.concurrent.Semaphore;

public class TimedThread extends Thread {
	
	private Semaphore mutex;
	private int time;
	
	public TimedThread(Semaphore mutex) {
		this.mutex = mutex;
		this.time = (int)(Math.random() * 8001) + 4000;
	}
	
	public int getTime() {
		return time;
	}
	
	@Override
	public void run() {
		try {
			mutex.acquire();
			System.out.println(this + " Starting (" + time + ")");
			sleep(time);
			System.out.println(this + " Ending");
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
