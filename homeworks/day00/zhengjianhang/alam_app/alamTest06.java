package com.alam.app.alam_app;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class alamTest06 {
	/*log文件 ,内容为 key=value,key=value&key=value,key=value
	 * 解析文件 并且封装成对象User(name:String,age:integer)
	 * 例如:
	 * -文件内容"name=jim,age=23&name=jack,age=34"
	 * -解析出User(name=jim,age=23)
	 * -解析出User(name=jack,age=34)
	 * */
	public static String readTxtFile(String path){
		StringBuffer sBuffer = new StringBuffer();
        try {
            String encoding="utf-8";
            File file=new File(path);
            if(file.isFile() && file.exists()){ 
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    System.out.println(lineTxt);
                    sBuffer.append(lineTxt);
                }
                read.close();
//                System.out.println(sBuffer);
                return new String(sBuffer);
	        }else{
	            System.out.println("fomat is not correct");
	        }
	        } catch (Exception e) {
	            System.out.println("error");
	            e.printStackTrace();
	        }
        return "";
    }
	public static List<String> splitUser(String str) {
		List<String> ls = new ArrayList<String>(); 
		for (String retval: str.split("&")){
			ls.add(retval);
            System.out.println(retval);
        }
		return ls;
		
	}
	
	public static void RegexAlam(String str) {
//		str ="name=jim,age=23";
        Pattern p=Pattern.compile("name=(.*?),age=([0-9]*)");
        
        Matcher m=p.matcher(str);
        if(m.matches()) {
//        	System.out.println(m.group(1));
        	String name= m.group(1);
//            System.out.println(m.group(2));
            int age= Integer.parseInt(m.group(2));
            User alamUser = new User(name,age);
            System.out.println(alamUser);
//        	System.out.println("matches name=(.*?),age=([0-9]*)");
        }
        else {
        	System.out.println(" no match name=(.*?),age=([0-9]*)");
		}
	}
	
	public static void main(String[] args){
		String filePath = "../alam-app/src/main/java/com/alam/app/alam_app/alamTest06.log";
        System.out.println(readTxtFile(filePath));
        splitUser(readTxtFile(filePath));
        for(String s:splitUser(readTxtFile(filePath))) {
//        	System.out.println(s);
        	RegexAlam(s);
        }
	}
}