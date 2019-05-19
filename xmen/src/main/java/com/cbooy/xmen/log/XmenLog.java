package com.cbooy.xmen.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haoc
 */
public final class XmenLog {

  private static Logger LOGGER = LoggerFactory.getLogger(XmenLog.class);

  private XmenLog() {
    LOGGER = LoggerFactory.getLogger(XmenLog.class);
  }

  public static XmenLog of() {
    return new XmenLog();
  }

  public XmenLog targetClass(Class clazz) {
    LOGGER = LoggerFactory.getLogger(clazz);
    return this;
  }

  public void warn(String s, Object... objs) {
    LOGGER.warn("[xmen warn occur]: " + s, objs);
  }
}
