package core.struct;

/**
 * @author haoc
 */
public class StaticClassDemo {

  /**
   * static 类属性,
   *
   * static final, 常量,不可修改
   *
   * 常量名一些大写,下划线
   */
  public static final String CONST_INFO = "class demo";

  /**
   * 类属性,静态域
   */
  public static String data = "static class demo";

  /**
   * 静态方法,类方法
   */
  public static String call(String info) {
    return data + "++" + info;
  }

  static {
    System.out.println("static code block");
  }

}
