package com.thoughtworks.step;

import java.util.Date;
import java.util.Objects;

public class Transaction {
  private final Date date;
  private final float amount;
  private String type;
  private final String accountNumber;

  public Transaction(Date date, float amount, String type, String accountNumber) {
    this.date = date;
    this.amount = amount;
    this.type = type;
    this.accountNumber = accountNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return Float.compare(that.amount, amount) == 0 &&
            Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {

    return Objects.hash(amount, type);
  }

  public float getAmount() {
    return amount;
  }

  public boolean isCredit() {
    return type == "credit";
  }

  public boolean isDebit() {
    return type == "debit";
  }
}
