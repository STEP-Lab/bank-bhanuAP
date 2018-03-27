package com.thoughtworks.step;

import java.util.ArrayList;

public class Transactions {
  protected ArrayList<Transaction> list;

  public Transactions() {
    list = new ArrayList<>();
  }

  public void addDebitTransaction(float amount) {
    list.add(new DebitTransaction(amount));
  }

  public void addCreditTransaction(float amount) {
    list.add(new CreditTransaction(amount));
  }

  public Transactions filterByAmountGreaterThan(float amount) {
    Transactions transactions = new Transactions();
    for (Transaction transaction:list) {
      if (transaction.getAmount() > amount)
        transactions.list.add(transaction);
    }
    return transactions;
  }

}
