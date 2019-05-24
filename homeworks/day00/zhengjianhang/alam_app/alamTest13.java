package com.alam.app.alam_app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class alamTest13 {
	/*找出文件中单词出现最多的单词
	 * hello hi hello,最多的单词是hello
	 * */
	public static String findWord(String filePath) {
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
        Map<String, Integer> hm =new HashMap<String, Integer>();
        outWord = result.toString();
        for (String retval: outWord.split(" ")){
//        	System.out.println(retval);
            if(hm.get(retval) == null) {
            	hm.put(retval, 1);
            }else {
				int count =hm.get(retval);
				hm.put(retval, (count+1));
			}
        }
//        int mapSize=hm.size();
        String maxS="";
        int maxValue=0;
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
        	if("".equals(maxS)) {
        		maxS=entry.getKey();
        	}
        	if(hm.get(maxS)<entry.getValue()) {
        		maxValue=entry.getValue();
        		maxS=entry.getKey();
        	}
//        	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        	
        }
//        System.out.println("maxKey = " + maxS + ", maxValue = " + hm.get(maxS));
        return maxS;
		
	}

	public static void main(String[] args) {
		String filePath="../alam-app/src/main/java/com/alam/app/alam_app/alamTest13.txt";
		System.out.println(findWord(filePath));//hello
	}

}
