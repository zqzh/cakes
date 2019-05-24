package com.alam.app.alam_app;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class alamTest03 {
	/*输入abc 输出CBA
	 * */
	public static String intChange(String inputString) {
		String OutString="请输入全部字母";
		
		if(!inputString.matches("[a-zA-Z]+")) {
			return OutString;
		}
//		OutString="matches(\"[a-zA-Z]+\")";
		int count=inputString.length();
		int n = count - 1;
		String[] value =inputString.split("");
		int middlleIndex=(count)>> 1;
//		System.out.println("middlleIndex="+middlleIndex);
		String cm=value[middlleIndex].toUpperCase();
//		System.out.println(cm);
		value[middlleIndex]=cm;
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
//            String[] value =inputString.split("");
            String cj = value[j].toUpperCase();
            String ck = value[k].toUpperCase();
            value[j] = ck;
            value[k] = cj;
        }
//		String reverse = new StringBuffer(inputString).reverse().toString();
        StringBuffer StringBuffer1 = new StringBuffer();
        for (String s : value) {
        	StringBuffer1.append(s);
        }
		return new String(StringBuffer1);
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("next:");
		// �ж��Ƿ�������
		while (scan.hasNext()) {
			
			String str1 = scan.next();
			if(str1.equals("-1")) {
				System.out.println("scan.close();");
				scan.close();
				break;
			}
			System.out.println(intChange(str1));
			
		}
//		scan.close();
	}
}