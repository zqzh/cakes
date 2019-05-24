package com.alam.app.alam_app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import com.alam.app.alam_app.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class alamTest09 {
	/*
	 * 两个线程,实现死锁
	 */
	public static String obj1 = "obj1";
	public static String obj2 = "obj2";
	public static String obj3 = "obj3";

	public static void main(String[] args) {
		MyThread la = new MyThread();
		new Thread(la).start();
		MyThread2 lb = new MyThread2();
		new Thread(lb).start();
	}
}

class MyThread implements Runnable {
	public void run() {
		String name = Thread.currentThread().getName();
		try {
//			System.out.println(new Date().toString() + " LockA 开始执行");
			System.out.println(name + " 开始执行");
			while (true) {
				Thread.sleep(1000); 
				synchronized (alamTest09.obj1) {
					System.out.println(name + " 锁住 obj1");
//					long Temp = Math.round(Math.random()*8999+1000);
					Thread.sleep(1000); // 此处等待是给B能锁住机会
					synchronized (alamTest09.obj2) {
						System.out.println(name + " 锁住 obj2");
						Thread.sleep(1000); // 为测试，占用了就不放
					}System.out.println(name + " released lock on obj2");
				}System.out.println(name + " released lock on obj1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class MyThread2 implements Runnable {
	public void run() {
		String name = Thread.currentThread().getName();
		try {
//			System.out.println(new Date().toString() + " LockA 开始执行");
			System.out.println(name + " 开始执行");
			while (true) {
				Thread.sleep(1000); 
				synchronized (alamTest09.obj2) {
					System.out.println(name + " 锁住 obj2");
//					long Temp = Math.round(Math.random()*8999+1000);
					Thread.sleep(1000); // 此处等待是给B能锁住机会
					synchronized (alamTest09.obj1) {
						System.out.println(name + " 锁住 obj1");
						Thread.sleep(1000); // 为测试，占用了就不放
					}System.out.println(name + " released lock on obj1");
				}System.out.println(name + " released lock on obj2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}