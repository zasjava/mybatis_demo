package synchno;

import synchno.pojo.Demo;

/**
 * @ClassName TestStatic
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-5-8 9:28
 **/
public class TestStatic {
	/**
	 *  静态方法修饰的锁关键字，为同一个对象的出现互斥
	 *  非静态方法修饰的锁关键字，为同一个对象的出现互斥，不同对象不互斥
	 **/

	public static void main(String[] args) {
		final Demo demo = new Demo(1);
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.getI(Thread.currentThread().getName());
			}
		}, "thread0").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.getI(Thread.currentThread().getName());
			}
		}, "thread1").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				new Demo(2).getI(Thread.currentThread().getName());
			}
		}, "thread2").start();
	}
}
