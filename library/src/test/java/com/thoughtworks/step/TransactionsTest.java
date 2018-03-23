package com.thoughtworks.step;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TransactionsTest {
  @Test
  public void mustRecordDebitTransaction() {
    Transactions transactions = new Transactions();
    transactions.addDebitTransaction(1000,"Dhanu");
    assertEquals(transactions.list.get(0).hashCode(),new DebitTransaction(1000,"Dhanu").hashCode());
  }
}
