package com.thoughtworks.step;

public class NegAmountException extends Exception {
  NegAmountException() {
    super("Balance should be a positive integer");
  }
}