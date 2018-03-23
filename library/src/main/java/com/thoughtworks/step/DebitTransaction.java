package com.thoughtworks.step;

import java.util.Date;

public class DebitTransaction extends Transaction {

  protected DebitTransaction(Date date, float amount, String creditorAcc) {
    super(date, amount, creditorAcc);
  }

  public DebitTransaction(float amount, String name) {
    this(new Date(),amount,name);
  }

}
