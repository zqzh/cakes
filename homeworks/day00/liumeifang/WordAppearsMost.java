import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 读取文本文件中所有内容，查找出出现次数最多的单词
 * 例：文件内容：hello hi hello，最多的单词为‘hello’
 * 要求：考虑健壮性
 * --已完成
 *
 * 思路是把每个单词都计算一遍出现的次数，把次数放到集合中找出最大值，同时找到这个最大值的下标，用这个下标找到出现次数最多的单词
 */

public class WordAppearsMost {

    public static void main(String[] args){
        String str = "hello hi hello";
        String word = wordAppearsMost(str);
        System.out.println("出现次数最多的单词是："+word);
    }

    private static String wordAppearsMost(String a){
        int m = 0;
        List<Integer> int_list = new ArrayList<>();
        List<String> str_list = new ArrayList<>();
        int max_int = 0;
        int max_index = 0;

        if (a.length()<=1){
            return a;
        }

        String[] b = a.split(" ");
        for (String str:b){
            str_list.add(str);
        }

        for (String str1:b){
            str_list.remove(str1);
            for (int c=0;c<str_list.size();c++){
                if (str1.equals(str_list.get(c))){
                    m++;
                }
            }
            int_list.add(m);
        }

        max_int = Collections.max(int_list);
        max_index = int_list.indexOf(max_int);
        return b[max_index];
    }
}
