package com.alam.app.alam_app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class alamTest15 {
	/*从一个日志文件中根据关键字读取日志,记录出现次数,最后按照次数排序打印
	 * */
	
	//读取文件,返回内容字符串
	public static String readFile(String filePath) {
		String outWord="";
		StringBuilder result = new StringBuilder();
		File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println(tempString);
                result.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        outWord = result.toString();
        return outWord;
	}
	
	//字符串返回一个map<关键字,出现次数>
	public static Map<String, Integer> String2map(String fileContent) {
		
        Map<String, Integer> hm =new HashMap<String, Integer>();
        
        for (String retval: fileContent.split(" ")){
            if(hm.get(retval) == null) {
            	hm.put(retval, 1);
            }else {
				int count =hm.get(retval);
				hm.put(retval, (count+1));
			}
        }
        	
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(hm.entrySet());
		
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //升序排序
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
		Map<String, Integer> lm =new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : lm.entrySet()) {
        	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		for (Entry<String, Integer> e: list) {
//			System.out.println(e.getKey()+":"+e.getValue());
			lm.put(e.getKey(), e.getValue());
//			System.out.println(hm.get(e.getKey()));
		}
		return lm;
     }


	public static void main(String[] args) {
		String filePath="../alam-app/src/main/java/com/alam/app/alam_app/alamTest13.txt";
		String str =readFile(filePath);
		Map<String, Integer> wordMap = String2map(str);
		for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
        	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		/*	Key = helloWorld, Value = 2
			Key = World, Value = 4
			Key = hi, Value = 6
			Key = hello, Value = 7
		 * */
	}
}
