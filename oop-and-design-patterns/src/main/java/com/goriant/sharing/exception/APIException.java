package com.goriant.sharing.exception;

public class APIException extends Exception {

  public APIException(String message, Exception e) {
    super(message, e);
  }

  public APIException(String message) {
    super(message);
  }

  public APIException(Throwable cause) {
    super(cause);
  }
}
