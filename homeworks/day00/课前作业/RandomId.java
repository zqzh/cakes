import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomId {

    public static void main(String[] args) {

        System.out.println("4、RandomId：" + randomId());
    }

    private static String randomId(){
        String randid = "";
        String base = "0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        //当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String now = simpleDateFormat.format(new Date());
        //随机10位数
        Random random = new Random();
        for (int i = 0 ; i < base.length() ; i++ ){
            //获取随机10个数
            int lastTenNumber = random.nextInt(10);
            //获取成功后加到sb里面
            stringBuilder.append(base.charAt(lastTenNumber));
        }
        String randomNumber = stringBuilder.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        //判断最后一位数是不是偶数
        if(Integer.parseInt(randomNumber.substring(9,10))%2==0){
            stringBuilder1.append("230_");
            stringBuilder1.append(now);
            stringBuilder1.append(randomNumber);
            stringBuilder1.append("2200");
            randid = stringBuilder1.toString();
        }else{
            stringBuilder1.append("230_");
            stringBuilder1.append(now);
            stringBuilder1.append(randomNumber);
            stringBuilder1.append("1100");
            randid = stringBuilder1.toString();
        }
        return randid;
    }
}
