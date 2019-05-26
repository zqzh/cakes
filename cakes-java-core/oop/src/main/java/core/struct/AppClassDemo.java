package core.struct;

import org.junit.Test;

/**
 * @author haoc
 */
public class AppClassDemo {

  /**
   * 1.
   *
   * 类和对象的关系
   */
  @Test
  public void callClassDemo() {
    // 定义一个对象cd,类型是ClassDemo
    // new 关键字, 实例化,创建对象,在堆中新建一块内存空间,并将地址引用赋值给cd
    // ClassDemo(1, "jim"), 调用构造方法来创建对象,并为属性赋值
    ClassDemo cd = new ClassDemo(1, "jim");

    // obj.method(), 对象调自己的实例化方法
    final String response = cd.say("haha");
    System.out.println("response = " + response);
  }

  /**
   * 2. 匿名
   */
  @Test
  public void noneName() {
    final String response = new ClassDemo(1, "jim").say("hehe");
    System.out.println(response);
  }

  /**
   * 3.测试下实例的代码块
   */
  @Test
  public void testObjectCodeBlock() {
    new ClassDemo(1, "jim");
    new ClassDemo(2, "jack");
    new ClassDemo(3, "tom");
  }

}
