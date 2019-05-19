package com.cbooy.xmen.basic.impl;

import java.util.Objects;

/**
 * @author haoc
 */
public final class ObjectImpl {

  private ObjectImpl() {
  }

  public static <T> T selectFirstNotNull(T t1, T t2) {
    if (!Objects.isNull(t1)) {
      return t1;
    }

    return t2;
  }

}
