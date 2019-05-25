package core;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.junit.Test;

/**
 * 字符串
 *
 * @author haoc
 */
public class CakesString {

  /**
   * 1.新建
   *
   * 需要格外注意编码的问题
   */
  @Test
  public void newStr() throws UnsupportedEncodingException {
    // 定义, 为初始化
    String str1;

    // 定义, 并初始化为null
    String str2 = null;

    // 定义, 并初始化为空串
    String str3 = "";

    // new 空串
    String str4 = new String();

    // new "hello"
    String str5 = new String("hello");

    // char数组创建
    final char[] chars = {'h', 'e', 'l', 'l', 'o'};
    final String str6 = new String(chars);
    System.out.println("str6=" + str6);

    // 在char数组中切片,从0开始,切3个长度,即:hel
    final String str7 = new String(chars, 0, 3);
    System.out.println("str7=" + str7);

    int[] codePoints = new int[]{97, 98, 99, 100, 101};
    final String str8 = new String(codePoints, 0, 3);
    System.out.println("str8=" + str8);

    String val = "中国";
    final String str9 = new String(val.getBytes());
    System.out.println("str9 = " + str9);

    final String str10 = new String(val.getBytes("UTF-8"), 0, val.length(), Charset.forName("GBK"));
    System.out.println("str10 = " + str10);
  }

  /**
   * 2.创建
   */
  @Test
  public void valueof() {
    String.valueOf(1024);
    String.valueOf(1024L);
    String.valueOf(10.24F);
    String.valueOf(10.24D);
    String.valueOf(false);
    String.valueOf('a');
    String.valueOf(new Object());
    String.valueOf(new byte[]{1, 2, 3, 4});
    String.valueOf(new char[]{'a', 'b', 'c', 'd'});
  }

  /**
   * 3.获取属性信息
   */
  @Test
  public void prop() {
    String str = "hello";

    // 字符串是否为空,""
    final boolean isEmpty = str.isEmpty();
    System.out.println("str.isEmpty() = " + isEmpty);

    // 字符串的长度
    final int length = str.length();
    System.out.println("length = " + length);

    // 获取字符串的hash code
    final int hashCode = str.hashCode();
    System.out.println("hashCode = " + hashCode);
  }

  /**
   * 4.分割与连接
   */
  @Test
  public void splitAndJoin() {
    String str = "hello,world,hi,thank,you";
    final String[] strs1 = str.split(",");
    Arrays.stream(strs1).forEach(System.out::println);

    System.out.println("\n-----我是分割线------\n");

    final String[] strs2 = str.split(",", 2);
    Arrays.stream(strs2).forEach(System.out::println);

    System.out.println("\n-----我是分割线------\n");

    final String joinResult1 = String.join("+", strs1);
    System.out.println("joinResult1 = " + joinResult1);

  }

  /**
   * 5.截取
   */
  @Test
  public void subAndTrim() {
    String str = "123456789";

    // 从beginIndex开始截取,一直截取到最后
    final String res1 = str.substring(3);
    System.out.println("res1 = " + res1);

    System.out.println("\n-----我是分割线------\n");

    // 从beginIndex开始截取一直截取到endIndex
    final String res2 = str.substring(3, 6);
    System.out.println("res2 = " + res2);

    System.out.println("\n-----我是分割线------\n");

    String originStr = "  abcdefg    ";
    System.out.println("origin:[" + originStr + "]");

    originStr = originStr.trim();
    System.out.println("origin:[" + originStr + "]");
  }

  /**
   * 6.定位
   */
  @Test
  public void indexOf() {
    String str = "hello,love";
    // 从前定位
    System.out.println("str.indexOf(\"e\") = " + str.indexOf("e"));
    System.out.println("str.indexOf(2) = " + str.indexOf('e'));
    System.out.println("str.indexOf(\"l\") = " + str.indexOf("l"));
    System.out.println("str.indexOf(\"l\", 5) = " + str.indexOf("l", 5));

    // 从后定位
    System.out.println("str.lastIndexOf(\"e\") = " + str.lastIndexOf("e"));
    System.out.println("str.lastIndexOf('e') = " + str.lastIndexOf('e'));

    // 定位指定索引位置的char
    System.out.println("str.charAt(0) = " + str.charAt(0));
    System.out.println("str.charAt(1) = " + str.charAt(1));
  }

  /**
   * 7.判断,全相等,前缀相等,后缀相等,包含
   */
  @Test
  public void check() {
    // 值相等判断
    System.out.println("\"hello\".equals(\"hello\") = " + "hello".equals("hello"));
    System.out.println("\"hello\".equals(\"Hello\") = " + "hello".equals("Hello"));

    // 忽略大小学的值判断
    System.out
        .println("\"hello\".equalsIgnoreCase(\"Hello\") = " + "hello".equalsIgnoreCase("Hello"));

    // 前缀匹配
    System.out
        .println("\"hello world\".startsWith(\"hello\") = " + "hello world".startsWith("hello"));
    System.out.println("\"hello world\".startsWith(\"abc\") = " + "hello world".startsWith("abc"));
    System.out.println(
        "\"hello hi world \".startsWith(\"hi\",6) = " + "hello hi world ".startsWith("hi", 6));

    // 后缀匹配
    System.out.println("\"how are you\".endsWith(\"you\") = " + "how are you".endsWith("you"));
    System.out.println("\"how are you\".endsWith(\"your\") = " + "how are you".endsWith("your"));

    // 包含
    System.out.println(
        "\"hello world, how are you\".contains(\"are\") = " + "hello world, how are you"
            .contains("are"));

  }

  /**
   * 8.转化&替换
   */
  @Test
  public void toSth() {
    System.out.println("\"hello\".toUpperCase() = " + "hello".toUpperCase());

    System.out.println("\"HELLO\".toLowerCase() = " + "HELLO".toLowerCase());

    final char[] chars = "hello".toCharArray();

    // 替换
    "hello world".replace("hello", "hi");
    "hello world,hello java".replaceAll("hello", "hi");
    "hello world,hello java".replaceFirst("hello", "hi");
  }

  /**
   * 面试点一
   */
  @Test
  public void interviewPoint1() {
    String str1 = "hello";
    String str2 = new String("hello");

    System.out.println(str1 == str2);
    System.out.println(str1.equals(str2));
  }

  /**
   * 面试点二
   */
  @Test
  public void interviewPoint2() {
    String str1 = "hello";
    String str2 = "hello";

    System.out.println(str1 == str2);
    System.out.println(str1.equals(str2));

  }

  /**
   * 面试点三
   */
  @Test
  public void interviewPoint3() {
    String str1 = "a" + "b" + "c";
    String str2 = "abc";

    System.out.println(str1 == str2);
    System.out.println(str1.equals(str2));
  }

  /**
   * 面试点四
   */
  @Test
  public void interviewPoint4() {
    String str1 = "ab";
    String str2 = "abc";
    String str3 = str1 + "c";

    System.out.println(str2 == str3);
    System.out.println(str2.equals(str3));
  }
}
