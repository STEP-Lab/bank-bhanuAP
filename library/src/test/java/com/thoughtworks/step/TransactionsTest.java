package com.thoughtworks.step;

import org.junit.Test;


import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TransactionsTest {
  @Test
  public void mustRecordDebitTransaction() {
    Date date = new Date();
    Transactions transactions = new Transactions();
    transactions.addDebitTransaction(1000);
    assertEquals(transactions.list.get(0).hashCode(),new DebitTransaction(date,1000).hashCode());
  }
}
