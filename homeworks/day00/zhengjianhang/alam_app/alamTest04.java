package com.alam.app.alam_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class alamTest04 {
	/*随机生成方法,要求32位
	 * 前4位230_
	 * 随后14位yyyyMMddHHmmss
	 * */
	public static void main(String[] args) {
//		RandomID ls = new RandomID();

		new Thread(new RandomID()).start();
		new Thread(new RandomID()).start();
	}
}

class RandomID implements Runnable{  
	  
//	private List<String> ls = new ArrayList<String>(); 
    public void run() { 
//    	List<String> ls = new ArrayList<String>();
		StringBuffer sBuffer = new StringBuffer();
	    sBuffer.append("230_");
	    sBuffer.append("yyyyMMddHHmmss");
	    
	    long min = 10000000000L;
	    long max = 99999999999L;
	    long rangeLong = min + (((long) (new Random().nextDouble() * (max - min))));
	    sBuffer.append(rangeLong);
	    
	    if((rangeLong%2)>0) {
	    	sBuffer.append("1100");
	    }
	    else {
	    	sBuffer.append("2200");
	    }
	    System.out.println(sBuffer);
//	    ls.add(new String(sBuffer));
//	    return ls;
	}
}  
