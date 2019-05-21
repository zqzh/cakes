/**
 * 算法-编程：括号规则判断
 *---已完成
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Algorithm {

    public static void main(String[] args){
        String a = "{,&*, ,{}{}[],{[([})]},({[{}]})";
        String[] b = a.split(",");

        for (String str: b){
            System.out.println(str+" 结果是：");
            boolean c = judge(str);
            System.out.println(c);
        }
    }

    private static boolean judge(String str){

        boolean isMatch = false;
        // 如果字符长度为0或者1，或者字符长度和2求余不等于0，都不能符合配对场景
        if (str.length()<=1 || str.length()%2 != 0){
            return false;
        }

        for (int i=0;i<str.length()/2;i++){
            String a = str.substring(i,i+1) + str.substring(str.length()-i-1,str.length()-i);
//            System.out.println(a);
            if (a.equals("()") || a.equals("{}") || a.equals("[]")){
                isMatch = true;
            } else {
                isMatch = false;
                break;  //如果不配对则跳出循环
            }
        }
        return isMatch;
    }
}
