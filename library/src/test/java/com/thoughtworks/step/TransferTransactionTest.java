package com.thoughtworks.step;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TransferTransactionTest {
  @Test
  public void mustRecordCorrectTransactionDate() {
    DebitTransaction transaction = new DebitTransaction(1000);
    assertEquals(transaction.hashCode(),new DebitTransaction(1000).hashCode());
  }
}
