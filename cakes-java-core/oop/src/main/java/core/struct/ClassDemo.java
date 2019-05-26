package core.struct;

/**
 * public, 修饰符,公共的,表示所有包的类都可以访问
 *
 * class,  类关键字
 *
 * ClassDemo, 类名,自定义,一般首字母大写,符合驼峰命名
 */
public class ClassDemo {

  /**
   * private,修饰符,私有的,只有内部可以使用
   *
   * 属性,id
   *
   * 存储位置位于堆中
   */
  private Integer id;

  /**
   * 属性,name
   */
  private String name;

  {
    // 构造代码块,优先于构造函数执行
    // 覆盖的是所有对象,不管调用哪个构造函数
    System.out.println("这里是实例代码块,只要new就掉一次");
  }

  /**
   * 构造方法,两个参数
   */
  public ClassDemo(Integer id, String name) {
    System.out.println("准备要构造");
    this.id = id;
    this.name = name;
  }

  /**
   * 实例方法,行为的描述
   */
  public String say(String message) {
    System.out.println(message);

    // 局部变量,存储位置位于方法的栈帧中
    int num = 1024;

    return this.id + "," + this.name + ": say hello";
  }
}
