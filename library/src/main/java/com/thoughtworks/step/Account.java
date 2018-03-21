package com.thoughtworks.step;

public class Account {
  private final String name;
  private final String number;
  private float balance = 0;

  public Account(String name, String number) throws IncorrectAccNumException {
    if(!this.isValidAccNumber(number)) {
      throw new IncorrectAccNumException();
    }
    this.name = name;
    this.number = number;
  }

  private boolean isValidAccNumber(String accNumber) {
    return accNumber.matches("\\d{4}-\\d{4}");
  }

  public String getName() {
    return name;
  }

  public String getAccNumber() {
    return number;
  }

  public float getBalance() {
    return balance;
  }

  public float credit(int amount) throws NegAmountException {
    if(amount <= 0) {
      throw new NegAmountException();
    }
    return balance += amount;
  }

  public float debit(int amount) throws NegAmountException, InsufficientBalanceException {
    if(amount <= 0) {
      throw new NegAmountException();
    }
    if(balance < amount){
      throw new InsufficientBalanceException();
    }
    return balance -= amount;
  }
}