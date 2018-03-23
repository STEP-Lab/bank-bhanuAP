package com.thoughtworks.step;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountNumberTest {
  @Test
  public void checkCorrectAccNumber() throws InvalidAccNumberException {
    new AccountNumber("1234-5678").validate();
  }

  @Test (expected = InvalidAccNumberException.class)
  public void checkHyphenInAccNumber() throws InvalidAccNumberException {
    new AccountNumber("12341234").validate();
  }

  @Test (expected = InvalidAccNumberException.class)
  public void checkAlphabetsPresenceInAccNumber() throws InvalidAccNumberException{
    new AccountNumber("a234-1234").validate();
  }

  @Test
  public void ShouldReturnValidAccNumber() throws InvalidAccNumberException {
    String accNumber = "1234-5678";
    String accountNumber = new AccountNumber(accNumber).validate();
    assertThat(accountNumber,is(accNumber));
  }
}
