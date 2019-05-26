package core.struct;

import org.junit.Test;

/**
 * @author haoc
 */
public class AppStaticClassDemo {

  /**
   * 会调静态代码块
   */
  @Test
  public void callStaticCodeBlock1() {
    StaticClassDemo.call("hello");
  }

  /**
   * 会调静态代码块
   */
  @Test
  public void callStaticCodeBlock2() {
    new StaticClassDemo();
  }

  /**
   * 会调静态代码块
   */
  @Test
  public void callStaticCodeBlock3() {
    System.out.println(StaticClassDemo.data);
  }

  /**
   * 不会调
   */
  @Test
  public void callStaticCodeBlock4() {
    System.out.println(StaticClassDemo.CONST_INFO);
  }
}
