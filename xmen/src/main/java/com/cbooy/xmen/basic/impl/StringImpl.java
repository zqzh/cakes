package com.cbooy.xmen.basic.impl;

import com.cbooy.xmen.exception.XmenException;
import com.cbooy.xmen.log.XmenLog;
import com.google.common.base.Strings;

/**
 * @author haoc
 */
public final class StringImpl {

  private StringImpl() {

  }

  public static void requireBlanks(String... strs) {
    if (null == strs || strs.length == 0) {
      return;
    }

    for (String str : strs) {
      if (!Strings.isNullOrEmpty(str)) {
        throw new XmenException("required strs is null or empty");
      }
    }
  }

  public static void requireBlank(String str) {
    if (!Strings.isNullOrEmpty(str)) {
      throw new XmenException("required str null, but not null value found");
    }
  }

  public static void requireNotBlanks(String... strs) {
    if (null == strs || strs.length == 0) {
      throw new XmenException("required str list is null");
    }

    for (String str : strs) {
      if (Strings.isNullOrEmpty(str)) {
        throw new XmenException("required strs not null, but null value found");
      }
    }
  }

  public static void requireNotBlank(String str) {
    if (Strings.isNullOrEmpty(str)) {
      throw new XmenException("required str not null, but null value found");
    }
  }

  public static String selectNotNull(String str1, String str2) {
    if (!Strings.isNullOrEmpty(str1)) {
      return str1;
    }

    if (!Strings.isNullOrEmpty(str2)) {
      return str2;
    }

    XmenLog.of().targetClass(StringImpl.class).warn("select not null val,but found none");

    return null;
  }

  public static String selectFirstNotNull(String... strs) {
    if (null == strs || strs.length == 0) {
      return null;
    }

    for (String str : strs) {
      if (!Strings.isNullOrEmpty(str)) {
        return str;
      }
    }

    XmenLog.of().targetClass(StringImpl.class).warn("select first not null,but found none");

    return null;
  }

  public static String selectLastNotNull(String... strs) {
    if (null == strs || strs.length == 0) {
      return null;
    }

    for (int i = strs.length - 1; i >= 0; i--) {
      if (!Strings.isNullOrEmpty(strs[i])) {
        return strs[i];
      }
    }

    XmenLog.of().targetClass(StringImpl.class).warn("select last not null,but found none");

    return null;
  }
}
