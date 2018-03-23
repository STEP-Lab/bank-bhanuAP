package com.thoughtworks.step;

public class InvalidAmountException extends Exception {
  InvalidAmountException() {
    super("Balance should be a positive integer");
  }
}