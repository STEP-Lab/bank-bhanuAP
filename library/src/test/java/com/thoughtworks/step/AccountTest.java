package com.thoughtworks.step;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTest {
  @Test
  public void getName() throws InvalidAccNumberException {
    Account harvar = new Account("HarVar",new AccountNumber("1912-7864").validate());
    assertThat(harvar.getName(), is("HarVar"));
  }

  @Test
  public void getAccNumber() throws InvalidAccNumberException {
    Account bhanu = new Account("Bhanu",new AccountNumber("1278-6524").validate());
    assertThat(bhanu.getAccNumber(), is("1278-6524"));
  }

  @Test
  public void getBalance() throws InvalidAccNumberException {
    Account harsha = new Account("Harsha",new AccountNumber("1912-1234").validate());
    assertThat(harsha.getBalance(), is(0F));
  }

  @Test
  public void creditPosAmount() throws NegAmountException, InvalidAccNumberException {
    Account teja = new Account("Teja",new AccountNumber("1234-5421").validate());
    assertThat(teja.credit(1000), is(1000F));
    assertThat(teja.credit(9000), is(10000F));
  }

  @Test (expected = NegAmountException.class)
  public void creditNegAmount() throws NegAmountException, InvalidAccNumberException {
    Account vardhana = new Account("Vardhana", new AccountNumber("1234-5678").validate());
    vardhana.credit(-1);
  }

  @Test
  public void debitPosAmount() throws NegAmountException, InsufficientBalanceException, InvalidAccNumberException {
    Account varma = new Account("Varma", new AccountNumber("1234-5678").validate());
    varma.credit(200);
    assertThat(varma.debit(100), is(100F));
  }

  @Test (expected = NegAmountException.class)
  public void debitNegAmount() throws NegAmountException, InsufficientBalanceException, InvalidAccNumberException {
    Account pavan = new Account("Pavan",new AccountNumber("1234-1235").validate());
    pavan.debit(-100);
  }

  @Test (expected = InsufficientBalanceException.class)
  public void debitMoreAmount() throws InsufficientBalanceException, NegAmountException, InvalidAccNumberException {
    Account kalyan = new Account("Kalyan",new AccountNumber("1234-1234").validate());
    kalyan.debit(100);
  }

}

