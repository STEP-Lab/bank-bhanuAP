package com.thoughtworks.step;

import java.util.Date;

public class DebitTransaction extends Transaction {

  protected DebitTransaction(Date date, float amount) {
    super(date, amount);
  }

  public DebitTransaction(float amount) {
    this(new Date(),amount);
  }

}
