package com.alam.app.alam_app;

import java.util.List;

import javax.net.ssl.ExtendedSSLSession;

import org.omg.CORBA.PUBLIC_MEMBER;

public class alamTest16 {
	/*有三个线程ABC,分别向一个数组中写入a,l,i
	 * 要求最终的写入结果如alialiali 写入次数由A线程决定
	 * 
	 * */
	
	
	public static void main(String[] args) {
		alamT mr = new alamT();
		Thread t1 = new Thread (mr,"A");
        t1.start();
        Thread t2 = new Thread (mr,"L");
        t2.start();
        Thread t3 = new Thread (mr,"I");
        t3.start();
        //alilailaiailaliali
	}
}

class alamT implements Runnable {
	
	public static StringBuffer bstr = new StringBuffer();
	
	public void run() {
		String Threadname = Thread.currentThread().getName();
		
		try {
			System.out.println(Threadname + " 开始执行");
		
			while(true){
				Thread.sleep(1000); 
				synchronized (bstr) {
					if("A".equals(Threadname)) {
						bstr.append("a");
					}
					else if ("L".equals(Threadname)) {
						bstr.append("l");
					}
					else if ("I".equals(Threadname)) {
						bstr.append("i");
					}else {
						bstr.append("");
					}
				}
	//			System.out.println(Threadname + " released lock on obj1");
				System.out.println(bstr);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
