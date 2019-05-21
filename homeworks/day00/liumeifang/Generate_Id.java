/**
 * 随机id生成器
 * --已完成
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Generate_Id {

    private static String getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date());
    }

    private static String getRandomNum(){
        StringBuilder str = new StringBuilder();
        //考虑随机数多线程场景，使用ThreadLocalRandom，解决多个线程发生的竞争争夺
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i=0;i<2;i++){
            str.append(random.nextInt(99999)+"");
        }
        System.out.println("随机数是："+str.toString());
        return str.toString();
    }

    private static String genId(){

        //获取当前日期格式化值
        String date = getCurrentDate();

        //获取10位随机数
        String randomNum = getRandomNum();
        //获取10位随机数的最后一位数字
        String lastNum = randomNum.substring(randomNum.length()-1);
//        System.out.println("a is："+lastNum);
        //randomNum最后一位数字，除以2取余
        int c = Integer.parseInt(lastNum)%2;

        //余数为0，则10位随机数最后一位为偶数；余数不为0，则10位随机数最后一位为奇数
        if (c==0){
            return "230_"+date+randomNum+"2200";
        }
        else{
            return "230_"+date+randomNum+"1100";
        }
    }

    public static void main(String[] args){
        String id = genId();
        System.out.println("随机id值是："+id);
    }

}
