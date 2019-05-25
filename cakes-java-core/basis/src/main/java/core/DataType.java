package core;

import java.math.BigDecimal;
import org.junit.Test;

/**
 * 数据类型练习
 *
 * @author haoc
 */
public class DataType {

  /**
   * 1.
   *
   * 业务中金额的表示,避免浮点型的计算而使用单位为分的long型表示
   */
  @Test
  public void aboutAmount() {
    // 12元8角4分
    long amount = 1284;
  }

  /**
   * 2.
   *
   * 浮点型计算的案例
   */
  @Test
  public void calcFloat() {
    // 案例1
    double a = 1;
    double b = 0.99;
    System.out.println(a - b);

    // 案例2
    float c = 1;
    float d = 0.99f;
    System.out.println(c - d);

    /**
     * 这种舍入误差的主要 原因是浮点数值采用二进制系统表示， 而在二进制系统中无法精确地表示分数 1/10
     *
     * 原因分析: @link https://blog.csdn.net/jianhong1990/article/details/44288251
     */
  }

  /**
   * 3.
   *
   * 解决方案一: 使用BigDecimal计算浮点型
   */
  @Test
  public void fixFloat1() {
    final BigDecimal a = new BigDecimal(1);
    final BigDecimal b = new BigDecimal(0.99);
    System.out.println(a.subtract(b));
  }

  /**
   * 4.
   *
   * 解决方案一: 使用BigDecimal+String value 计算浮点型
   */
  @Test
  public void fixFloat2() {
    final BigDecimal c = new BigDecimal("1");
    final BigDecimal d = new BigDecimal("0.99");
    System.out.println(c.subtract(d));
  }

  /**
   * 5.
   *
   * long 或 double在32位操作系统上的问题
   */
  @Test
  public void longTypeIn32() {
    // long类型为64位, 在32位的机器上,对long类型的数据操作通常需要多条指令组合出来. 进而无法保证原子性
    //  0: ldc2_w        #18                 // long 1024l
    long amount = 1024;
  }

  /**
   * 6.
   *
   * int和Integer的区别
   */
  @Test
  public void intAndInteger() {
    // ---------------- 字节码 ----------------
    //  0: bipush        32
    int num1 = 32;

    // 3: bipush        64
    // 5: invokestatic  #20                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
    Integer num2 = 64;
  }

  /**
   * 7.
   *
   * 自动拆箱装箱操作
   */
  @Test
  public void autoBoxing() {
    int i = 1;
    // 装
    Integer ii = i;

    // 拆
    int iii = ii;

    /**
     字节码如下: javap -verbose DataType

     0: iconst_1
     1: istore_1
     2: iload_1
     3: invokestatic  #20                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     6: astore_2
     7: aload_2
     8: invokevirtual #21                 // Method java/lang/Integer.intValue:()I
     11: istore_3
     12: return

     */
  }

  /**
   * 8.
   *
   * Integer的缓存
   */
  @Test
  public void integerCache() {
    Integer i1 = 128;
    Integer i2 = 128;
    System.out.println(i1 == i2);

    Integer i3 = 127;
    Integer i4 = 127;
    System.out.println(i3 == i4);
  }


}
