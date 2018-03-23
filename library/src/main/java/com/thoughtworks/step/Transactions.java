package com.thoughtworks.step;

import java.util.ArrayList;

public class Transactions {
  protected ArrayList<Object> list;

  public Transactions() {
    list = new ArrayList<>();
  }

  public void addDebitTransaction(float amount) {
    list.add(new DebitTransaction(amount));
  }

  public void addCreditTransaction(float amount) {
    list.add(new CreditTransaction(amount));
  }
}
