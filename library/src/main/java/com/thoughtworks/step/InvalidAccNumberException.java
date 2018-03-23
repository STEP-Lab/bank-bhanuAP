package com.thoughtworks.step;

public class InvalidAccNumberException extends Throwable {
  public InvalidAccNumberException() {
    super("Account number is invalid");
  }
}
