package core;

import java.util.Arrays;
import org.junit.Test;

/**
 * 数组练习
 *
 * @author haoc
 */
public class Array {

  /**
   * 数组的创建
   */
  @Test
  public void create() {
    int[] arr1 = new int[3];
    arr1[0] = 1;
    arr1[1] = 2;
    arr1[2] = 3;

    int[] arr2 = new int[]{1, 2, 3};
  }

  /**
   * 数组的遍历
   */
  @Test
  public void foreach() {
    int[] arr = new int[]{1, 2, 3, 4, 5};

    // 遍历方式1
    for (int ele : arr) {
      System.out.println(ele);
    }

    System.out.println("\n------ \n");

    // 遍历方式2
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }

    System.out.println("\n------ \n");

    // 遍历方式3
    Arrays.stream(arr).forEach(System.out::println);
  }


}
