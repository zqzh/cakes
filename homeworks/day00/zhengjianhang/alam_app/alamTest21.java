package com.alam.app.alam_app;

import java.util.HashMap;


public class alamTest21 {
	/* 输入一个double,要求返回与他最近的.49或者.99的数字
	 * 例如12.77返回12.99
	 * 11.02 返回10.99
	 * 12.61返回12.49*/
	
	public static double return49or99(double d) {
//		System.out.println(d);
		double min=00.00;
		HashMap<Double, Double> m1= new HashMap<Double, Double>();
		//key 是最小距离,value是值
		
		double maxd= (int)d+0.99-d;
//		System.out.println(maxd);//.99的距离
		m1.put(maxd, (int)d+0.99);
		
		double midd=00.00;
		
		if((int)d+0.49>d) {
			midd= (int)d+0.49-d;
			m1.put(midd,(int)d+0.49);
//			System.out.println("midd= (int)d+0.49-d;");
		}else {
			midd= d-(int)d-0.49;
			m1.put(midd, (int)d+0.49);
//			System.out.println("midd= d-(int)d+0.49;");
		}
//		System.out.println(midd);
		
		double mind= d-(int)d-1+0.99;
		m1.put(mind, (int)d-1+0.99);
//		System.out.println(mind);
		
		//比较最小值,然后存在min中
		if(maxd>midd) {
			min=midd;
		}else {
			min=maxd;
		}
		if(min>mind) {
			min=mind;
		}
		
		return m1.get(min);
		
	}
	

	public static void main(String[] args) {
		System.out.println(return49or99(12.77));//12.99
		System.out.println(return49or99(11.02));//10.99
		System.out.println(return49or99(12.61));//12.49

	}

}
