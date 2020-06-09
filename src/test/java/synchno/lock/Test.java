package synchno.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-6-3 15:44
 **/
public class Test {
	public static void main(String[] args) throws InterruptedException {
		final Lock lock = new ReentrantLock(true);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 2; i++) {
					lock.lock();
					System.out.println(Thread.currentThread().getName()+"获取锁");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						lock.unlock();
					}
				}
			}
		};
		new Thread(runnable,"线程1").start();
		new Thread(runnable,"线程2").start();
		new Thread(runnable,"线程3").start();
		new Thread(runnable,"线程4").start();
		new Thread(runnable,"线程5").start();
	}
}
