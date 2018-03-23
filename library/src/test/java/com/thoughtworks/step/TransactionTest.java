package com.thoughtworks.step;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TransactionTest {
  @Test
  public void mustRecordCorrectTransactionDate() {
    Date date = new Date();
    Transaction transaction = new Transaction(date,1000);
    assertEquals(transaction.hashCode(),new Transaction(date,1000).hashCode());
  }
}
