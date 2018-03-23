package com.thoughtworks.step;

public class AccountNumber {

  private final String number;

  public AccountNumber(String number) throws InvalidAccNumberException {
    this.number = number;
  }

  public String validate() throws InvalidAccNumberException {
    if(!number.matches("\\d{4}-\\d{4}")) {
      throw new InvalidAccNumberException();
    }
    return number;
  }
}
