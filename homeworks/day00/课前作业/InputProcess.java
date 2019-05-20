import java.util.*;
import java.util.regex.Pattern;

public class InputProcess {
    public static void main(String[] args) {
        InputProcess();
    }

    private static void InputProcess(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入字符串：");
            String inputKey = scanner.nextLine();
            //判断退出匹配
            if(inputKey.equals("exit")){
                System.out.println("退出");
                break;
            }else if(inputKey.equals("-1")){
                System.out.println("退出");
                break;
                //判断字符串不超过32位
            }else if(inputKey.length()<=32){
                //判断是否是数字1-9
                if(isNum(inputKey)){
                    System.out.println("hello"+inputKey);
                }else{
                    //转换带空格字符串
                    String [] tmps = inputKey.split("");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String tmp:tmps) {
                        stringBuilder.append(tmp+" ");
                    }
                    System.out.println(stringBuilder.toString());
                }
                //判断超过32位处理
            }else if(inputKey.length()>32){
                System.err.println("你输入的字符串过长，请重新输入！");
            }else{
                System.err.println("非法操作");
            }
        }
    }

    private static boolean isNum(String inputKey){
        Pattern pattern = Pattern.compile("[1-9]*");
        return pattern.matcher(inputKey).matches();
    }
}
