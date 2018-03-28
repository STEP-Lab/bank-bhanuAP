package com.thoughtworks.step;

import java.util.Date;

public class TransferFromTransaction extends Transaction {
  protected TransferFromTransaction(Date date, float amount, String accountNumber) {
    super(date,amount,"credit",accountNumber);
  }
  public TransferFromTransaction(float amount, String accountNumber) {
    this(new Date(),amount,accountNumber);
  }
}

