package com.cbooy.xmen.basic;

import com.cbooy.xmen.basic.impl.StringImpl;

/**
 * @author haoc
 */
public final class XmenString {

  public static void requireBlanks(String... strs) {
    StringImpl.requireBlanks(strs);
  }

  public static void requireBlank(String str) {
    StringImpl.requireBlank(str);
  }

  public static void requireNotBlanks(String... strs) {
    StringImpl.requireNotBlanks(strs);
  }

  public static void requireNotBlank(String str) {
    StringImpl.requireNotBlank(str);
  }

  public static String selectNotNull(String str1, String str2) {
    return StringImpl.selectNotNull(str1, str2);
  }

  public static String selectFirstNotNull(String... strs) {
    return StringImpl.selectFirstNotNull(strs);
  }

  public static String selectLastNotNull(String... strs) {
    return StringImpl.selectLastNotNull(strs);
  }
}
