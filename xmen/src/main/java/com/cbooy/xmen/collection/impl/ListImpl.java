package com.cbooy.xmen.collection.impl;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author haoc
 */
public final class ListImpl {

  private ListImpl() {

  }

  public static <T> List<T> join(List<T> list1, List<T> list2) {
    List<T> list = Lists.newArrayList();
    list.addAll(list1);
    list.addAll(list2);
    return list;
  }

  public static <T, R> List<R> join(List<T> list1, List<T> list2, Function<T, R> func) {
    List<R> list = Lists.newArrayList();
    list.addAll(list1.stream().map(func).collect(Collectors.toList()));
    list.addAll(list2.stream().map(func).collect(Collectors.toList()));
    return list;
  }
}
