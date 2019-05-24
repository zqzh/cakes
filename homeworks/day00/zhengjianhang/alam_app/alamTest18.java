package com.alam.app.alam_app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.omg.CORBA.PUBLIC_MEMBER;

public class alamTest18 {
	/* 十亿条淘宝购买记录,怎么获取出最多的前十个*/
	
	private static final int ITERATIONS = 5;
	private static final double MEG = (Math.pow(1024, 2));
	private static final int RECORD_COUNT = 10000000;
	
	private static void write(List<String> records, Writer writer) throws IOException {
//	    long start = System.currentTimeMillis();
	    for (String record: records) {
	        writer.write(record);
	    }
	    writer.flush();
	    writer.close();
//	    long end = System.currentTimeMillis();
//	    System.out.println((end - start) / 1000f + " seconds");
	}
	
	private static void writeBuffered(List<String> records, int bufSize) throws IOException {
	    File file = new File("../alam-app/src/main/java/com/alam/app/alam_app/alamTest18.txt");
	    try {
	        FileWriter writer = new FileWriter(file);
	        BufferedWriter bufferedWriter = new BufferedWriter(writer, bufSize);
	
//	        System.out.print("Writing buffered (buffer size: " + bufSize + ")... ");
	        write(records, bufferedWriter);
	    } finally {
//	        file.delete();
	    }
	}
	
	public static void generateShopingData() throws IOException {
//		File f=new File("../alam-app/src/main/java/com/alam/app/alam_app/alamTest18.txt");
		List<String> records = new ArrayList<String>(RECORD_COUNT);
	    int size = 0;
	    for (int i = 0; i < RECORD_COUNT; i++) {
	    	Random r=new Random();
	    	String name="alam-"+r.nextInt(100);
	        String good="good-"+r.nextInt(100);
	        int count=r.nextInt(10);
	        String RECORD=name+","+good+","+count+"\n";
	        records.add(RECORD);
//	        size += RECSIZE;
	    }
	    System.out.println(records.size() + " 'records'");
	
	    for (int i = 0; i < ITERATIONS; i++) {
//	        System.out.println("\nIteration " + i);
	        
	        writeBuffered(records, 8192);
	    }
		System.out.println("---------generateShopingData done");
	}

	public static void main(String[] args) throws IOException {
		generateShopingData();
	}

}
