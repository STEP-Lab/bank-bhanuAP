package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
  private  Transactions transactions;
  @Before
  public void setUp() throws Exception {
    transactions = new Transactions();
  }

  @Test
  public void mustRecordTransaction() {
    Date date = new Date();
    transactions.addDebitTransaction(1000);
    DebitTransaction transaction = new DebitTransaction(date,1000);
    assertThat(transactions.list,hasItem(transaction));
  }

  @Test
  public void mustRecordTransactionWithHashcode() {
    Date date = new Date();
    transactions.addDebitTransaction(1000);
    assertEquals(transactions.list.get(0).hashCode(),new DebitTransaction(date,1000).hashCode());
  }

  @Test
  @Ignore
  public void printTransaction() {
//    transactions.print();
  }

  @Test
  public void filterTransactionsByAmount() {
    transactions.addCreditTransaction(1100);
    transactions.addCreditTransaction(500);
    transactions.addCreditTransaction(1000);
    transactions.addDebitTransaction(500);
    Transactions filteredTransaction = transactions.filterByAmountGreaterThan(1000);
    CreditTransaction transaction = new CreditTransaction(1100);
    assertThat(filteredTransaction.list,hasItem(transaction));
  }
}
