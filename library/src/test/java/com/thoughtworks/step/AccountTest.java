package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class AccountTest {
  private Account account;
  @Before
  public void setUp() throws InvalidAccNumberException {
    account = new Account("Bhanu",new AccountNumber("1234-5678").validate());
  }

  @Test
  public void getName()  {
    assertThat(account.getName(), is("Bhanu"));
  }

  @Test
  public void getAccNumber() {
    assertThat(account.getAccNumber(), is("1234-5678"));
  }

  @Test
  public void getBalance() {
    assertThat(account.getBalance(), is(0F));
  }

  @Test
  public void creditPositiveAmount() throws InvalidAmountException {
    assertThat(account.credit(1000), is(1000F));
    assertThat(account.credit(9000), is(10000F));
  }

  @Test (expected = InvalidAmountException.class)
  public void creditNegativeAmount() throws InvalidAmountException {
    account.credit(-1);
  }

  @Test
  public void debitPositiveAmount() throws InvalidAmountException, InsufficientBalanceException {
    account.credit(200);
    assertThat(account.debit(100), is(100F));
  }

  @Test (expected = InvalidAmountException.class)
  public void debitNegativeAmount() throws InsufficientBalanceException, InvalidAmountException {
    account.debit(-100);
  }

  @Test (expected = InsufficientBalanceException.class)
  public void debitMoreAmount() throws InsufficientBalanceException, InvalidAmountException {
    account.debit(100);
  }

  @Test
  public void checksTransactionsOfAcc() throws InvalidAmountException, InsufficientBalanceException {
    account.credit(1000);
    account.debit(500);
    assertEquals(account.transactions.list.size(),1);
  }
}

