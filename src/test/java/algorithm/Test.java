package algorithm;

import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zhaoasong
 * @Date 2020-5-20 7:01
 **/
public class Test {
	/**
	 *
	 * @Description: 冒泡查询
	 * @auther: zhaoasong
	 * @date: 7:23 2020-5-20
	 * @param:
	 * @return:
	 **/
	@org.junit.Test
	public void testMp(){
		int[] arr = {78, 89, 67, 98, 90, 56, 88};

		for (int i = 0; i < arr.length -1; i++) {//循环arr.length-1次
			//第一次循环arr.length-1次，前者和后者比较，如果前者大于后者，则两者交换位置
			//第二次循环arr.length-2次，与上相同，j最大为arr.length-3
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		for (int a :arr) {
			System.out.print(a+" ");
		}
	}
	/**
	 *
	 * @Description: 二分查找
	 * @auther: zhaoasong
	 * @date: 7:24 2020-5-20
	 * @param: []
	 * @return: void
	 **/
	@org.junit.Test
	public void testEf() {
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个数字：");
		int num = sc.nextInt();

		int start = 0;
		int end = arr.length - 1;
		int index = -1;
		while (start <= end) {
			int middle = (start + end)/2;
			if (num == arr[middle]) {
				index = middle;
				break;
			}
			if (num > arr[middle]) {
				start = middle + 1;
			}
			if (num < arr[middle]) {
				end = middle - 1;
			}
		}
		System.out.println(index);
		sc.close();
	}

}
