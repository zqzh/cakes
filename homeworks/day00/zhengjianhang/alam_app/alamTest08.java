package com.alam.app.alam_app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.alam.app.alam_app.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class alamTest08 {
	/*读取xxx.json内容为{"name":"jim","age":23} 多个数据则为[{},{}]
	 * 解析完成将数据入库mysql,数据表user(id,name,age)
	 * */
	public static void FileToJson(String sfilePath) throws IOException  { 
		Writer writer = new FileWriter("Output.json");

        Gson gson = new GsonBuilder().create();
        gson.toJson("Hello", writer);
        gson.toJson(123, writer);

        writer.close();
	}
	public static void JsonToDB(String sfilePath)  {    
        String sql = "INSERT INTO user (name, age ) VALUES( value1, value2,...valueN );";
	}
	public static void main(String[] args) throws IOException {
		FileToJson("");
	}
}