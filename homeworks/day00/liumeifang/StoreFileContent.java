/**
 * 文件读取&数据入库
 * 读取文件xxx.json，解析后将数据入库
 * --没有完成
 */

import java.io.*;

public class StoreFileContent {

    public static void storeDataToDB(File filePath) throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");
        BufferedReader br = new BufferedReader(isr);
        String line = null;

        while ((line = br.readLine()) != null){
            String[] arr = line.split("");
        }

    }

    public static void main(String[] args){
        String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"list_test.json";
        System.out.println("test");
    }
}
