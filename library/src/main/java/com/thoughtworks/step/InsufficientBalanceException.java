package com.thoughtworks.step;

public class InsufficientBalanceException extends Throwable {
  public InsufficientBalanceException() {
    super("Insufficient balance");
  }
}