/**
 * 输入处理
 * --已完成
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//需要考虑输入是空格和直接回车情况。把判断输入是否是字符放到前面时，输入数字也被判断是字符，不知道是什么问题，把判断输入
//是否是数字就没有这个问题了
public class Handle_Input {

    public static void main(String[] args){

        while(true){
            Scanner input = new Scanner(System.in);
            input.useDelimiter("\n");
            System.out.println("请输入：");

            //判断输入是否是数字
            if (input.hasNextInt()){
                List<Integer> b = Arrays.asList(1,2,3,4,5,6,7,8,9);
                int i = input.nextInt();
                if (i == -1){
                    break;
                }
                else if ((i+"").length()<=32 && b.contains(i)){
                    System.out.println("hello"+i);
                }
            }
            //判断输入是否是字符
            else if (input.hasNext()){
                String b = "";
                StringBuffer a = new StringBuffer();
                String str = input.next();

                if (str.equals("exit")){
                    break;
                }
                else if (str.length()<=32) {
                    for (int i=0;i<str.length();i++){
                        b = str.charAt(i)+" ";
                        a.append(b);
                    }
                }
                System.out.println(a);
            }
        }
    }

}
