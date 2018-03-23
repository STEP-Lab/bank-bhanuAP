package com.thoughtworks.step;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TransactionTest {
  @Test
  public void mustRecordCorrectTransactionDate() {
    DebitTransaction transaction = new DebitTransaction(1000, "Dhanu");
    assertEquals(transaction.hashCode(),new DebitTransaction(1000, "Dhanu").hashCode());
  }
}
