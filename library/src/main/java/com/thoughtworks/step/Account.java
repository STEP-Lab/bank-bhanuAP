package com.thoughtworks.step;

public class Account {
  private final String name;
  private final String number;
  private float balance = 0;
  protected Transactions transactions = new Transactions();

  public Account(String holder, String number) {
    this.name = holder;
    this.number = number;
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

  public float credit(int amount) throws InvalidAmountException {
    if(amount <= 0) {
      throw new InvalidAmountException();
    }
    return balance += amount;
  }

  public float debit(int amount) throws InvalidAmountException, InsufficientBalanceException {
    if(amount <= 0) {
      throw new InvalidAmountException();
    }
    if(balance < amount){
      throw new InsufficientBalanceException();
    }
    transactions.addDebitTransaction(amount);
    return balance -= amount;
  }
}