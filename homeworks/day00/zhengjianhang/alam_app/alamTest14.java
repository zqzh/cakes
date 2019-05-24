package com.alam.app.alam_app;

public class alamTest14 {
	/*斐波那契数列的第n个值
	 * 数量 1 1 2 3 5 8 13 21
	 * n=6 输出8
	 * */
	public static int fn(int n) {
		if(n<0) {
			return 0;
			}
		if(n==1) {
			return 1;
			}
		if(n==2) {
			return 1;
			}
		return fn(n-1)+fn(n-2);
		
	}

	public static void main(String[] args) {
		System.out.println(fn(6));//8
		System.out.println(fn(11));//89

	}

}
