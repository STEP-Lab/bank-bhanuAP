package com.thoughtworks.step;

import java.util.Date;

public class TransferFromTransaction extends Transaction {
  protected TransferFromTransaction(Date date, float amount, String type, String accountNumber) {
    super(date,amount,type,accountNumber);
  }
  public TransferFromTransaction(float amount, String to, String accountNumber) {
    this(new Date(),amount,to,accountNumber);
  }
}

