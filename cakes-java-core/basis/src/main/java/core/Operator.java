package core;

import org.junit.Test;

/**
 * 运算符
 *
 * @author haoc
 */
public class Operator {

  @Test
  public void normal() {
    // + - * / %
    // int num1 = 1024;
    // int num2 = 1024;
    //
    // int result = num1 + num2;
    // result = num1 - num2;
    // result = num1 * num2;
    // result = num1 / num2;
    // int orderId = 342234234;
    // int dbId = orderId % 8;
    // System.out.println("dbId = " + dbId);

    // && || !

    // 短路
    // boolean flag1 = true;
    // boolean flag2 = false;
    // System.out.println("(flag1||flag2) = " + (flag1 || flag2));
    // System.out.println("(flag1&&flag2) = " + (flag1 && flag2));
    // if (flag1 || flag2) {
    //   System.out.println("进入");
    // }

    // boolean flag1 = true;
    // boolean flag2 = false;
    // boolean flag3 = false;
    // boolean flag4 = false;
    // if (flag1 && flag2 && flag3 || flag4) {
    //
    // }
  }

  /**
   * ++i 与 i++的区别
   */
  @Test
  public void plusplus() {
    int num = 0;

    /**
     Code:
     stack=2, locals=2, args_size=1
     0: iconst_0
     1: istore_1
     2: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     5: iload_1
     6: iinc          1, 1
     9: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     12: return
     */
    // System.out.println(num++);

    /**
     Code:
     stack=2, locals=2, args_size=1
     0: iconst_0
     1: istore_1
     2: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     5: iinc          1, 1
     8: iload_1
     9: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     12: return
     */
    // System.out.println(++num);

    /**
     * 无论是i++还是++i, 在虚拟机的指令上都是两条,加载后自增,或者自增后加载,因此是没办法保证原子性的
     */
  }

  /**
   * 三目运算示例1
   */
  @Test
  public void ternaryCall1() {
    ternary1(true);
    ternary2(true);
  }

  public void ternary1(boolean flag) {
    String result = null;
    if (flag) {
      result = "居然是真的?!";
    } else {
      result = "原来是假的!?";
    }

    System.out.println(result);
  }

  public void ternary2(boolean flag) {
    String result = flag ? "居然是真的?!" : "原来是假的!?";
    System.out.println(result);
  }

  /**
   * 三目运算示例2
   */
  @Test
  public void ternaryCall2() {
    final String result1 = ternary3(59);
    System.out.println(result1);

    String result2 = ternary4(59);
    System.out.println(result2);
  }

  public String ternary3(int score) {
    if (score >= 90) {
      return "真牛逼,我靠";
    } else if (score >= 80) {
      return "牛逼";
    } else if (score >= 60) {
      return "呵呵";
    } else {
      return "对不起,学费不退哈!!!";
    }
  }

  public String ternary4(int score) {
    return score >= 90 ? "真牛逼,我靠" : score >= 80 ? "牛逼" : score >= 60 ? "呵呵" : "对不起,学费不退哈!!!";
  }
}
