package com.thoughtworks.step;

import java.util.ArrayList;
import java.util.Date;

public class Transactions {
  protected ArrayList<Transaction> list;
  private Transactions allTransactionsOnDate;

  public Transactions() {
    list = new ArrayList<>();
  }

  public void addDebitTransaction(float amount, String to) {
    list.add(new DebitTransaction(amount,to));
  }

  public void addCreditTransaction(float amount, String from) {
    list.add(new CreditTransaction(amount,from));
  }

  public void addTransferToTransaction(float amount, String to) {
    list.add(new TransferToTransaction(amount,to));
  }

  public void addTransferFromTransaction(float amount, String from) {
    list.add(new TransferFromTransaction(amount,from));
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

  public Transactions filterByAmountLessThan(float amount) {
    Transactions transactions = new Transactions();
    for (Transaction transaction:list) {
      if (transaction.getAmount() < amount) {
        transactions.list.add(transaction);
      }
    }
    return transactions;
  }

  public Transactions getAllTransaction() {
    Transactions transactions = new Transactions();
    transactions.list.addAll(list);
    return transactions;
  }

  public Transactions getAllCreditTransactions() {
    Transactions allCreditTransactions = new Transactions();
    for (Transaction transaction:list) {
      if (transaction.isCredit()) {
        allCreditTransactions.list.add(transaction);
      }
    }
    return allCreditTransactions;
  }

  public Transactions getAllDebitTransactions() {
    Transactions allDebitTransactions = new Transactions();
    for (Transaction transaction:list) {
      if (transaction.isDebit()) {
        allDebitTransactions.list.add(transaction);
      }
    }
    return allDebitTransactions;
  }

  public Transactions getAllTransactionsOnDate(Date date) {
    Transactions allTransactionsOnDate = new Transactions();
    for (Transaction transaction : list) {
      if(transaction.getDate().equals(date)) {
        allTransactionsOnDate.list.add(transaction);
      }
    }
    return allTransactionsOnDate;
  }
}
