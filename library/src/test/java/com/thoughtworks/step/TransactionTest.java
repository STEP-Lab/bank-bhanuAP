package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TransactionTest {
  private Transaction transaction;
  private  Date date;

  @Before
  public void setUp() throws Exception {
    date = new Date();
    transaction = new Transaction(date,1000,"credit", "self");
  }

  @Test
  public void mustRecordCorrectTransaction() {
    assertEquals(transaction.hashCode(),new Transaction(date,1000, "credit", "self").hashCode());
  }

  @Test
  public void checkTransactionObject() {
    transaction.equals(new Transaction(date,1000, "credit", "self"));
  }

  @Test
  public void shouldCheckAmount() {
    assertThat(transaction.getAmount(),is(1000F));
  }

  @Test
  public void shouldCheckTypeOfCreditTransaction() {
    assertTrue(transaction.isCredit());
    assertFalse(transaction.isDebit());
  }

  @Test
  public void shouldCheckTypeOfDebitTransaction() {
    transaction = new Transaction(date,100,"debit", "self");
    assertTrue(transaction.isDebit());
    assertFalse(transaction.isCredit());
  }
  
}
