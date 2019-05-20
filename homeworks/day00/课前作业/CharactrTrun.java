import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharactrTrun {

    public static void main(String[] args) {
        System.out.println("请输入字符串，按ENTER结束：");
        Scanner scanner = new Scanner(System.in);
        String inputKey = scanner.nextLine();
        System.out.println("3、字符串大写与翻转：" + "输入项是：" + inputKey + "===>输入出项是：" + characterTurn(inputKey));
    }

    private static String characterTurn(String inputKey){
        inputKey = "abc";
        String outputKey = "";
        for (int i = 0 ; i<inputKey.length() ; i++){
            String tmpL = inputKey.substring(i,i+1);
            String tmpU = tmpL.toUpperCase();
            for(int j = tmpU.length() - 1 ; j >=0 ; j--){
                outputKey += (tmpU.charAt(j));
            }
        }
        return outputKey;
    }
}
