package com.alam.app.alam_app;

import java.util.HashMap;
import java.util.Map;

public class alamTest11 {
	/*判断是否满足成对的关闭
	 * 如[{{}}]符合
	 * 如[[{{}}]]] 不符合
	 * */
	private static boolean IsPaired(String str) {
//		boolean flag =true;
		int lenStr = str.length();
		HashMap<String, String> pairdMap=new HashMap<String, String>();
		pairdMap.put("{","}");
		pairdMap.put("[","]");
		pairdMap.put("(",")");
		
		if (lenStr%2>0) {
			return false;
		}
		for(int i =0 ;i<lenStr/2;i++) {
			char c= str.charAt(i);
//			System.out.println("c="+c);
			char d= str.charAt(lenStr-1-i);
//			System.out.println("d="+d);
			try {
				String cc=pairdMap.get(String.valueOf(c));
//				System.out.println(cc);
				if(!cc.equals(String.valueOf(d))) {
					return false;
				}
			} catch (NullPointerException e) {
				return false;
				// TODO: handle exception
			}
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(IsPaired("[2{()}2]1"));
		System.out.println(IsPaired("[2{()}2]"));
		System.out.println(IsPaired("[[{()}]]"));
	}

}
