package com.thoughtworks.step;

import java.util.Date;

public class TransferToTransaction extends Transaction {
  protected TransferToTransaction(Date date, float amount, String to, String accountNumber) {
    super(date,amount,to,accountNumber);
  }
  public TransferToTransaction(float amount, String to, String accountNumber) {
    this(new Date(),amount,to,accountNumber);
  }
}
