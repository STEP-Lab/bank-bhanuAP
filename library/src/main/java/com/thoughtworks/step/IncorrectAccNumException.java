package com.thoughtworks.step;

public class IncorrectAccNumException extends Throwable {
  public IncorrectAccNumException() {
    super("Incorrect account number");
  }
}
