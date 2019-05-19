package com.cbooy.xmen.basic;

import com.cbooy.xmen.basic.impl.IfImpl;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author haoc
 */
public final class XmenIf {

  private XmenIf() {
  }

  public static void if1(boolean statement, Runnable task) {
    IfImpl.ifTrue(statement, task);
  }

  public static <T, R> R ifTrueReturn(boolean statement, T t, Function<T, R> func) {
    return IfImpl.ifTrueReturn(statement, t, func);
  }

  public static void ifFalse(boolean statement, Runnable task) {
    IfImpl.ifFalse(statement, task);
  }

  public static <T, R> R ifFalseReturn(boolean statement, T t, Function<T, R> func) {
    return IfImpl.ifFalseReturn(statement, t, func);
  }

  public static <E> void ifNotNull(E obj, Consumer<E> consumer) {
    IfImpl.ifNotNull(obj, consumer);
  }

  public static <E> void ifNotEmpty(Collection<E> collection, Consumer<Collection<E>> consumer) {
    IfImpl.ifNotEmpty(collection, consumer);
  }

  public static void ifNotBlank(String str, Consumer<String> consumer) {
    IfImpl.ifNotBlank(str, consumer);
  }

  public static IfImpl ifElseif() {
    return IfImpl.ifElseif();
  }
}
