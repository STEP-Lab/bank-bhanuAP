package com.thoughtworks.step;

import java.util.Date;

public class DebitTransaction extends Transaction {

  protected DebitTransaction(Date date, float amount, String to) {
    super(date, amount, "debit",to);
  }

  public DebitTransaction(float amount, String to) {
    this(new Date(),amount,to);
  }

}
