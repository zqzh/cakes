package com.cbooy.xmen.basic.impl;

import com.cbooy.xmen.exception.XmenException;
import com.cbooy.xmen.tuples.XmenPair;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author haoc
 */
public final class IfImpl {

  private Runnable elseTask;

  private XmenException elseException;

  private Set<XmenPair<Boolean, Runnable>> statements;

  private IfImpl() {
    this.statements = Sets.newHashSet();
  }

  public static void ifTrue(boolean statement, Runnable task) {
    if (statement) {
      task.run();
    }
  }

  public static <T, R> R ifTrueReturn(boolean statement, T t, Function<T, R> func) {
    return statement ? func.apply(t) : null;
  }

  public static void ifFalse(boolean statement, Runnable task) {
    if (!statement) {
      task.run();
    }
  }

  public static <T, R> R ifFalseReturn(boolean statement, T t, Function<T, R> func) {
    return statement ? null : func.apply(t);
  }

  public static <E> void ifNotNull(E obj, Consumer<E> consumer) {
    if (!Objects.isNull(obj)) {
      consumer.accept(obj);
    }
  }

  public static <E> void ifNotEmpty(Collection<E> collection, Consumer<Collection<E>> consumer) {
    if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(collection)) {
      consumer.accept(collection);
    }
  }

  public static void ifNotBlank(String str, Consumer<String> consumer) {
    if (!com.google.common.base.Strings.isNullOrEmpty(str)) {
      consumer.accept(str);
    }
  }

  public static void ifElse(boolean statement, Runnable trueTask, Runnable falseTask) {
    if (statement) {
      trueTask.run();
    } else {
      falseTask.run();
    }
  }

  public static IfImpl ifElseif() {
    return new IfImpl();
  }

  public IfImpl addBooleanStatement(Boolean statement, Runnable task) {
    this.statements.add(XmenPair.of(statement, task));
    return this;
  }

  public IfImpl addElseStatement(Runnable task) {
    if (this.elseException != null) {
      throw new IllegalArgumentException("else exception exists,should not have runnable");
    }

    this.elseTask = task;

    return this;
  }

  public IfImpl withElseException(Exception ex) {
    if (this.elseTask != null) {
      throw new IllegalArgumentException("else runnable exists,should not have Exception");
    }

    this.elseException = new XmenException(ex);

    return this;
  }

  public void exec() {
    for (XmenPair<Boolean, Runnable> statement : this.statements) {
      if (statement.getKey()) {
        statement.getValue().run();
        return;
      }
    }

    if (this.elseTask != null) {
      this.elseTask.run();
    }

    if (this.elseException != null) {
      throw this.elseException;
    }
  }
}
