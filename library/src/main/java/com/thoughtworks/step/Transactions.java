package com.thoughtworks.step;

import java.util.ArrayList;

public class Transactions {
  protected ArrayList<Transaction> list;

  public Transactions() {
    list = new ArrayList<>();
  }

  public void addDebitTransaction(float amount, String name) {
    list.add(new DebitTransaction(amount,name));
  }
}
