package com.thoughtworks.step;

import java.util.Date;
import java.util.Objects;

public abstract class TransferTransaction {
  protected final float amount;
  protected final String to;
  protected Date date;

  public TransferTransaction(Date date, float amount, String to) {
    this.date = date;
    this.amount = amount;
    this.to = to;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TransferTransaction that = (TransferTransaction) o;
    return Float.compare(that.amount, amount) == 0 &&
            Objects.equals(to, that.to);
  }

  @Override
  public int hashCode() {

    return Objects.hash(amount, to);
  }
}