/**
 * 字符串大写并反转
 * --已完成
 */

import java.util.Arrays;
import java.util.List;

public class Convert_Str {

    public static String convertStr(String a){
        StringBuffer b = new StringBuffer();

        //空字符
        if (a.length()==0){
            return a;
        }
        //只包含一个字符
        if (a.length()==1){
            return a.toUpperCase();
        }
        //至少有两个字符，for循环倒序取数据
        for (int i=0;i<a.length();i++){
            b.append(a.substring(a.length()-i-1,a.length()-i));
        }

        return b.toString().toUpperCase();
    }

    public static void main(String[] args){
        List<String> a = Arrays.asList("abc","test","","a","testtest");
        for (String c:a){
            System.out.println(convertStr(c));
        }
    }

}
