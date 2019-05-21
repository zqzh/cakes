/**
 * 文件解析
 * 给一个log文件，内容每行形式为key=value,key=value&key=value,key=value
 * 要求解析出文件并封装成对象User(name:String,age:Integer)
 * --已完成，参考了别人的代码
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ReadTxt {
    public static String paths="G:\\java_pro\\src\\main\\resources\\a.txt";
    public static List<User> readTxts() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(paths), "gbk");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        int count = 0;
        List<User> list = new ArrayList<User>();

        while ((line = br.readLine()) != null) {
            User txt = new User();
            String[] arr = line.split("&");

            if (arr.length==2){
                txt.setName(arr[0].split(",")[0]);
                txt.setAge(arr[0].split(",")[1].substring(0,3)+arr[0].split(",")[1].substring(4));
                list.add(txt);
                System.out.println(txt.getName()+","+txt.getAge());

                txt.setName(arr[1].split(",")[0]);
                txt.setAge(arr[1].split(",")[1].substring(4));

                list.add(txt);
                System.out.println(txt.getName()+","+txt.getAge());
            }
            count++;
        }
//        System.out.println("读取总条数：" + count + "，读取的list的长度" + list.size());
        return list;
    }

    public static void main(String[] args) throws IOException {
        readTxts();
    }

    public static class User {
        private String name;
        private String age;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAge() {
            return age;
        }

        public User() {
            super();
        }
    }

}