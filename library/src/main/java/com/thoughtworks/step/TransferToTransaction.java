package com.thoughtworks.step;

import java.util.Date;

public class TransferToTransaction extends Transaction {
  protected TransferToTransaction(Date date, float amount, String accountNumber) {
    super(date,amount,"debit",accountNumber);
  }
  public TransferToTransaction(float amount, String accountNumber) {
    this(new Date(),amount,accountNumber);
  }
}
