package com.alam.app.alam_app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class alamTest07 {
	/*源文件复制到目的文件
	 * */
	public static void copyFileUsingFileChannels(String sfilePath, String dfilePath) throws Exception {    
        FileChannel inputChannel = null;    
        FileChannel outputChannel = null;
        try {
        	File sfile = new File(sfilePath);
            File dfile = new File(dfilePath);
            if (!sfile.exists()||!dfile.exists()) {
            	System.out.println("file not exists");
            	throw new Exception("file not exists");
            	} 
	        inputChannel = new FileInputStream(sfilePath).getChannel();
	        outputChannel = new FileOutputStream(dfilePath).getChannel();
	        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
	        System.out.println("copyFileUsingFileChannels done");
	    } catch (Exception e) {
            e.printStackTrace();
        }finally {
	        inputChannel.close();
	        outputChannel.close();
	    }
	}
	
	public static void main(String[] args) throws Exception{
		String sfilePath = "../alam-app/src/main/java/alam01/Spath_alamTest07/alamTest07s.txt";
		String dfilePath = "../alam-app/src/main/java/alam01/Dpath_alamTest07/alamTest07d.txt";
		copyFileUsingFileChannels(sfilePath,dfilePath);
	}
}