package com.thoughtworks.step;

import java.util.Date;

public class CreditTransaction extends Transaction {
  protected CreditTransaction(Date date, float amount,String from) {
    super(date, amount, "credit", from);
  }

  public CreditTransaction(float amount,String from) {
    this(new Date(),amount,from);
  }
}
