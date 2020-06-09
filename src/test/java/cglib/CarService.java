package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @ClassName CarService
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-6-9 18:25
 **/
public class CarService {
	public static void save(String car) {
		System.out.println("save car "+ car);
	}

	public static void main(final String[] args) {
		final CarService carService = new CarService();
		Enhancer enhancer = new Enhancer();
		enhancer.setClassLoader(carService.getClass().getClassLoader());
		enhancer.setSuperclass(carService.getClass());
		enhancer.setCallback(new InvocationHandler() {
			@Override
			public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
				System.out.println("开启事务");
				Object invoke = method.invoke(carService, args);
				System.out.println("结束事务");
					return invoke;
			}
		});
		CarService carProx = (CarService) enhancer.create();
		carProx.save("保时捷");
	}
}
