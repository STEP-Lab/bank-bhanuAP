package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TransactionTest {
  private Transaction transaction;
  private  Date date;

  @Before
  public void setUp() throws Exception {
    date = new Date();
    transaction = new Transaction(date,1000,"credit");
  }

  @Test
  public void mustRecordCorrectTransaction() {
    assertEquals(transaction.hashCode(),new Transaction(date,1000, "credit").hashCode());
  }

  @Test
  public void checkTransactionObject() {
    transaction.equals(new Transaction(date,1000, "credit"));
  }

  @Test
  public void shouldCheckAmount() {
    assertThat(transaction.getAmount(),is(1000F));
  }
}
