package core.object;

/**
 * @author haoc
 */
public class AppPerson {

  public static void main(String[] args) throws InterruptedException {
    final Person 木尘 = new Person("木尘", 23);
    木尘.gender = "man";
    木尘.height = 180;

    final Person 大叔 = new Person("大叔", 40);
    大叔.gender = "man";
    大叔.height = 167;

    Person 美眉 = new Person("美眉", 20);
    美眉.gender = "woman";

    Person 大汉 = new Person("抠脚大汉", 25);
    大汉.gender = "man";

    for (int i = 1; i < 30; i++) {
      // 年初涨一岁
      木尘.setAge(木尘.getAge() + 1);
      大叔.setAge(大叔.getAge() + 1);

      // 年初薪水在增加
      木尘.setSalary(i + 10);
      大叔.setSalary(i * 5);

      // 过了一年的时间
      Thread.sleep(1000 * 3);

      System.out.println(
          "木尘:[姓名=" + 木尘.name + ",性别=" + 木尘.gender + ",身高=" + 木尘.height + ",年纪:" + 木尘.getAge()
              + ",美眉问年薪="
              + 木尘.getSalary(美眉)
              + "]");
      System.out.println(
          "木尘:[姓名=" + 木尘.name + ",性别=" + 木尘.gender + ",身高=" + 木尘.height + ",年纪:" + 木尘.getAge()
              + ",大汉问年薪="
              + 木尘.getSalary(大汉)
              + "]");

      System.out.println(
          "大叔:[姓名=" + 大叔.name + ",性别=" + 大叔.gender + ",身高=" + 大叔.height + ",年纪:" + 大叔.getAge()
              + ",美眉问年薪="
              + 大叔.getSalary(美眉)
              + "]");
      System.out.println(
          "大叔:[姓名=" + 大叔.name + ",性别=" + 大叔.gender + ",身高=" + 大叔.height + ",年纪:" + 大叔.getAge()
              + ",大汉问年薪="
              + 大叔.getSalary(大汉)
              + "]");

      System.out.println();
    }
  }

}
