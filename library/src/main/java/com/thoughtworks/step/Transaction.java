package com.thoughtworks.step;

import java.util.Date;
import java.util.Objects;

public class Transaction {
  private final Date date;
  protected final float amount;

  public Transaction(Date date, float amount) {
    this.date = date;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return Float.compare(that.amount, amount) == 0;
  }

  @Override
  public int hashCode() {

    return Objects.hash(amount);
  }
}
