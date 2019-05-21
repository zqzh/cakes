/**
 * 星期转换
 * --已完成
 */

import java.util.Arrays;
import java.util.List;


public class TransferWeekDay {

    public static void main(String[] args)
    {
        List<String> aa = Arrays.asList("六","日","1","一","测试");
        TransferWeekDay day = new TransferWeekDay();

        for (String c:aa){
            System.out.println(day.getWeekDay(c));
        }
    }

    private String getWeekDay(String a)
    {
        System.out.print(a + "-->");
        List<String> weekday = Arrays.asList("1","2","3","4","5","6","7","一","二","三","四","五","六","日");

        if (a.length()==1 && weekday.contains(a))
        {
            int index = weekday.indexOf(a);
//            System.out.println(index);
            return index < weekday.size()/2?"星期"+weekday.get(weekday.size()/2+index):"星期"+weekday.get(index-weekday.size()/2);
        }

        return "星期不存在";
    }
}


