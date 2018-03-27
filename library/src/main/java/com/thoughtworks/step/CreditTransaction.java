package com.thoughtworks.step;

import java.util.Date;

public class CreditTransaction extends Transaction {
  protected CreditTransaction(Date date, float amount) {
    super(date, amount, "credit");
  }

  public CreditTransaction(float amount) {
    this(new Date(),amount);
  }
}
