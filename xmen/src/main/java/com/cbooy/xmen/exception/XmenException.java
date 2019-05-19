package com.cbooy.xmen.exception;

/**
 * @author haoc
 */
public class XmenException extends RuntimeException {

  public XmenException() {
  }

  public XmenException(String message) {
    super(message);
  }

  public XmenException(String message, Throwable cause) {
    super(message, cause);
  }

  public XmenException(Throwable cause) {
    super(cause);
  }

  public XmenException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
