import java.util.Scanner;

public class WeekChange {
    public static void main(String[] args) {
        System.out.println("请输入数字或中文，按ENTER结束：");
        Scanner scanner = new Scanner(System.in);
        String inputKey = scanner.nextLine();
        System.out.println("1、星期转换：" + "输入项是：" + inputKey + "===>输入出项是：" + weekChange(inputKey));
    }

    private static String weekChange(String inputKey){
        String week = "";
        if (inputKey.length()==1){
            switch (inputKey){
                case "1":
                    week = "星期一";
                    break;
                case "2":
                    week = "星期二";
                    break;
                case "3":
                    week = "星期三";
                    break;
                case "4":
                    week = "星期四";
                    break;
                case "5":
                    week = "星期五";
                    break;
                case "6":
                    week = "星期六";
                    break;
                case "7":
                    week = "星期日";
                    break;
                case "一":
                    week = "星期1";
                    break;
                case "二":
                    week = "星期2";
                    break;
                case "三":
                    week = "星期3";
                    break;
                case "四":
                    week = "星期4";
                    break;
                case "五":
                    week = "星期5";
                    break;
                case "六":
                    week = "星期6";
                    break;
                case "七":
                    week = "星期7";
                    break;
                default:
                    return "你输错了，没有结果";
            }
        }else{
            return "你输错了，没有结果";
        }
        return week;
    }
}
