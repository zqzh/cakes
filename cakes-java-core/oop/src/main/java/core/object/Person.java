package core.object;

/**
 * 人类
 *
 * @author haoc
 */
public class Person {

  /**
   * 姓名
   */
  public String name;

  /**
   * 身高
   */
  public Integer height;

  /**
   * 性别
   */
  public String gender;

  /**
   * 年纪
   */
  private Integer age;

  /**
   * 年薪
   */
  private Integer salary;

  /**
   * 无参的构造器
   */
  public Person() {

  }

  /**
   * 有参的构造器
   */
  public Person(String name, Integer age) {
    // this关键字:
    this.name = name;
    this.age = age;
  }

  public Integer getAge() {
    if (this.name.equals("大叔")) {
      return this.age;
    }

    if (this.age > 23) {
      return 23;
    }
    return age;
  }

  public Integer getSalary(Person who) {
    if (this.name.equals("大叔")) {
      return this.salary;
    }

    if (who.gender.equals("woman")) {
      return 100;
    }

    return salary / 2;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }
}
