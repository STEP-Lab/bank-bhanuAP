import com.thoughtworks.step.Account;
import com.thoughtworks.step.NegAmountException;
import com.thoughtworks.step.InsufficientBalanceException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTest {
  @Test
  public void getName() {
    Account harvar = new Account("HarVar","1912-7864");
    assertThat(harvar.getName(),is("HarVar"));
  }

  @Test
  public void getAccNumber() {
    Account bhanu = new Account("Bhanu","1278-6524");
    assertThat(bhanu.getAccNumber(),is("1278-6524"));
  }

  @Test
  public void getBalance() {
    Account harsha = new Account("Harsha","1912-1234");
    assertThat(harsha.getBalance(),is(0));
  }

  @Test
  public void creditPosAmount() throws NegAmountException {
    Account teja = new Account("Teja","1234-5421");
    assertThat(teja.credit(1000),is(1000));
    assertThat(teja.credit(9000),is(10000));
  }

  @Test (expected = NegAmountException.class)
  public void creditNegAmount() throws NegAmountException {
    Account vardhana = new Account("Vardhana", "1234-5678");
    vardhana.credit(-1);
  }

  @Test
  public void debitPosAmount() throws NegAmountException, InsufficientBalanceException {
    Account varma = new Account("Varma", "1234-5678");
    varma.credit(200);
    assertThat(varma.debit(100), is(100));
  }

  @Test (expected = NegAmountException.class)
  public void debitNegAmount() throws NegAmountException, InsufficientBalanceException {
    Account pavan = new Account("Pavan","1234-1235");
    pavan.debit(-100);
  }

  @Test (expected = InsufficientBalanceException.class)
  public void debitMoreAmount() throws InsufficientBalanceException, NegAmountException {
    Account kalyan = new Account("Kalyan","1234-1234");
    kalyan.debit(100);
  }

}

