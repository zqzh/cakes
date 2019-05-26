package core.object;

/**
 * 分析初始化过程
 *
 * @author haoc
 */
public class User {

  private String name;
  private String info = "user";
  private Integer age;

  static {
    System.out.println("static code block");
  }

  {
    System.out.println("object code block");
    System.out.println(this.name);
    System.out.println(this.info);
    System.out.println(this.age);
  }

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
}
