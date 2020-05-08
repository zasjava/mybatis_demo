package synchno.pojo;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-5-8 9:29
 **/
public class Demo {
	static int i;

	public Demo(int i){
		this.i=i;
	}

	public static synchronized void staticGetI(String s){
		System.out.println(i+"---------"+s);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized  void getI(String s){
		System.out.println(i+"---------"+s);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
