package com.alam.app.alam_app;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class alamTest02 {
	/*输入1-9,输出hello+n
	 * 输入字符串 输出字符串空格间隔
	 * 限制32位
	 * 可循环输入
	 * 输入-1退出
	 * */
	public static String intChange(String inputString) {
		String OutString="限制32位";
		
		if(inputString.length()>32) {
			return OutString;
		}
		Pattern pattern = Pattern.compile("[1-9]{1}"); 
		Matcher isNum = pattern.matcher(inputString);
		if(isNum.matches()){
			OutString="hello"+inputString;
			return OutString; 
		} 
		else {
			StringBuffer sBuffer = new StringBuffer("");
			for(int i=0;i<inputString.length();i++){
				char c=inputString.charAt(i);
//				System.out.print(c+" ");//���a b c d e����ȡ�ַ���
			    sBuffer.append(c);
			    sBuffer.append(" ");
				}
			OutString = new String(sBuffer); 
		}
		return OutString;
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("next");
		
		// �ж��Ƿ�������
		while (scan.hasNext()) {
			String str1 = scan.next();
			if(str1.equals("exit")||str1.equals("-1")) {
				System.out.println("scan.close();");
				scan.close();
				break;
			}
			System.out.println(intChange(str1));
			
		}
//		scan.close();
	}
}