package synchno.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-6-3 15:39
 **/
public class MyThread implements Runnable {
	final  Lock lock = new ReentrantLock();
	@Override
	public void run() {
		if (lock.tryLock()) {
			lock.lock();
			try {
				System.out.println("执行线程123");
			}finally {
				lock.unlock();
			}
		} else {
			System.out.println("线程未得到锁");
		}


	}
}
