package com.thoughtworks.step;

import java.util.ArrayList;

public class Transactions {
  protected ArrayList<Transaction> list;

  public Transactions() {
    list = new ArrayList<>();
  }

  public void addDebitTransaction(float amount, String to) {
    list.add(new DebitTransaction(amount,to));
  }

  public void addCreditTransaction(float amount, String from) {
    list.add(new CreditTransaction(amount,from));
  }

  public Transactions filterByAmountGreaterThan(float amount) {
    Transactions transactions = new Transactions();
    for (Transaction transaction:list) {
      if (transaction.getAmount() > amount) {
        transactions.list.add(transaction);
      }
    }
    return transactions;
  }

}
