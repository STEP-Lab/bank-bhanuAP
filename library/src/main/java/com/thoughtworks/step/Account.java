package com.thoughtworks.step;

public class Account {
  private final String name;
  private final String number;
  private int balance = 0;

  public Account(String name, String number) {
    this.name = name;
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public String getAccNumber() {
    return number;
  }

  public int getBalance() {
    return balance;
  }

  public int credit(int amount) throws NegAmountException {
    if(amount <= 0) {
      throw new NegAmountException();
    }
    return balance += amount;
  }

  public int debit(int amount) throws NegAmountException, InsufficientBalanceException {
    if(amount <= 0) {
      throw new NegAmountException();
    }
    if(balance < amount){
      throw new InsufficientBalanceException();
    }
    return balance -= amount;
  }
}