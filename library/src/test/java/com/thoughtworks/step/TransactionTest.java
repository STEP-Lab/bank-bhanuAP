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

  @Test
  public void shouldRecordTransferToTransaction() {
    TransferToTransaction toTransaction = new TransferToTransaction(date,100,"debit","1234-6789");
    assertThat(toTransaction.hashCode(),is(new TransferToTransaction(date,100,"debit","1234-6789").hashCode()));
  }

  @Test
  public void checksTransferToObject() {
    TransferToTransaction toTransaction = new TransferToTransaction(date,100,"debit","1234-6789");
    toTransaction.equals(new TransferToTransaction(date,100,"debit","1234-6789"));
  }

  @Test
  public void shouldRecordTransferFromTransaction() {
    TransferFromTransaction fromTransaction = new TransferFromTransaction(date, 100, "debit", "1234-6789");
    assertThat(fromTransaction.hashCode(),is(new TransferFromTransaction(date,100,"debit","1234-6789").hashCode()));
  }

  @Test
  public void checksTransferFromObject() {
    TransferFromTransaction fromTransaction = new TransferFromTransaction(date,100,"debit","1234-6789");
    fromTransaction.equals(new TransferFromTransaction(date,100,"debit","1234-6789"));
  }
}
