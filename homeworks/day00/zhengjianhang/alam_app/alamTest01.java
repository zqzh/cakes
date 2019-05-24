package com.alam.app.alam_app;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class alamTest01 {
	/*输入1 输出星期一
	 * 输入一 输出星期1
	 * */
	public static String weekdateChange(String inputString) {
		String OutString="input wrong";
		Map<String,String> map = new HashMap<String,String>();
		  map.put("一","1");
		  map.put("二","2");
		  map.put("三","3");
		  map.put("四","4");
		  map.put("五","5");
		  map.put("六","6");
		  map.put("七","7");
//		  System.out.println(inputString);
		for(Entry<String, String> vo : map.entrySet()){

			if(inputString.equals(vo.getKey())) {
//				System.out.println("inputString ==vo.getKey()");
				return("星期" +vo.getValue());
			}else if(inputString.equals(vo.getValue())){
//				System.out.println("inputString ==vo.getValue()");			
				return("星期" +vo.getKey());
			}
		}
		return OutString;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("next:");
		if (scan.hasNext()) {
			String str1 = scan.next();
			System.out.println(weekdateChange(str1));
		}
		scan.close();
	}
}