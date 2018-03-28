package com.thoughtworks.step;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
  private  Transactions transactions;
  @Before
  public void setUp() {
    transactions = new Transactions();
  }

  @Test
  public void mustRecordTransaction() {
    Date date = new Date();
    transactions.addDebitTransaction(1000,"1234-5678");
    DebitTransaction transaction = new DebitTransaction(date,1000,"1234-5678");
    assertThat(transactions.list,hasItem(transaction));
  }

  @Test
  public void mustRecordTransactionWithHashcode() {
    Date date = new Date();
    transactions.addDebitTransaction(1000,"1234-5678");
    assertEquals(transactions.list.get(0).hashCode(),new DebitTransaction(date,1000,"1234-5678").hashCode());
  }

  @Test
  public void mustRecordTransferToTransaction() {
    Date date = new Date();
    transactions.addTransferToTransaction(1000,"1234-8765");
    TransferToTransaction toTransaction = new TransferToTransaction(1000, "1234-8765");
    assertThat(transactions.list,hasItem(toTransaction));
    assertEquals(transactions.list.get(0).hashCode(),toTransaction.hashCode());
  }

  @Test
  public void mustRecordTransferFromTransaction() {
    Date date = new Date();
    transactions.addTransferFromTransaction(1000,"1234-8765");
    TransferFromTransaction fromTransaction = new TransferFromTransaction(1000, "1234-8765");
    assertThat(transactions.list,hasItem(fromTransaction));
    assertEquals(transactions.list.get(0).hashCode(),fromTransaction.hashCode());
  }

  @Test
  @Ignore
  public void printTransaction() {
//    transactions.print();
  }

  @Test
  public void filterTransactionsAboveGivenAmount() {
    transactions.addCreditTransaction(1100,"self");
    transactions.addCreditTransaction(500, "self");
    transactions.addCreditTransaction(1000, "self");
    transactions.addDebitTransaction(500,"1234-5678");
    Transactions filteredTransaction = transactions.filterByAmountGreaterThan(1000);
    CreditTransaction transaction = new CreditTransaction(1100,"self");
    assertThat(filteredTransaction.list,hasItem(transaction));
  }

  @Test
  public void filterTransactionsBelowGivenAmount() {
    transactions.addCreditTransaction(1000,"self");
    transactions.addDebitTransaction(300,"self");
    transactions.addCreditTransaction(200,"self");
    Transactions filteredTransaction = transactions.filterByAmountLessThan(400);
    CreditTransaction transaction = new CreditTransaction(200,"self");
    assertThat(filteredTransaction.list,hasItem(transaction));
  }

  @Test
  public void filterTransferTransactionAboveGivenAmount() {
    transactions.addTransferFromTransaction(1100,"1234-8765");
    transactions.addTransferFromTransaction(500, "1234-8765");
    transactions.addTransferFromTransaction(1000, "1234-8765");
    transactions.addTransferToTransaction(1100,"1234-8765");
    Transactions filteredTransaction = transactions.filterByAmountGreaterThan(1000);
    TransferToTransaction transaction = new TransferToTransaction(1100,"1234-8765");
    assertThat(filteredTransaction.list,hasItem(transaction));
  }

  @Test
  public void filterTransferTransactionBelowGivenAmount() {
    transactions.addTransferFromTransaction(1000,"self");
    transactions.addTransferToTransaction(300,"self");
    transactions.addTransferFromTransaction(200,"self");
    Transactions filteredTransaction = transactions.filterByAmountLessThan(400);
    TransferFromTransaction transaction = new TransferFromTransaction(200,"self");
    assertThat(filteredTransaction.list,hasItem(transaction));
  }

  @Test
  public void filterAllTransaction() {
    transactions.addCreditTransaction(1000,"self");
    Transactions filteredTransaction = transactions.getAllTransaction();
    assertThat(filteredTransaction.list,hasItem(new CreditTransaction(1000,"self")));
  }

  @Test
  public void shouldGetAllCreditTransactions() {
    transactions.addCreditTransaction(1000,"self");
    transactions.addDebitTransaction(300,"self");
    transactions.addCreditTransaction(200,"self");
    transactions.addTransferFromTransaction(2000,"1234-8765");
    Transactions filteredTransaction = transactions.getAllCreditTransactions();
    assertThat(filteredTransaction.list,hasItem(new CreditTransaction(200,"self")));
    assertThat(filteredTransaction.list,hasItem(new TransferFromTransaction(2000,"1234-8765")));
  }

  @Test
  public void shouldGetAllDebitTransactions() {
    transactions.addCreditTransaction(1000,"self");
    transactions.addDebitTransaction(300,"self");
    transactions.addDebitTransaction(200,"self");
    transactions.addTransferToTransaction(2500,"1234-9876");
    Transactions filteredTransaction = transactions.getAllDebitTransactions();
    assertThat(filteredTransaction.list,hasItem(new DebitTransaction(300,"self")));
    assertThat(filteredTransaction.list,hasItem(new TransferToTransaction(2500,"1234-9876")));
  }

  @Test
  public void shouldGetAllTransactionsByDate() {
    transactions.addCreditTransaction(1000,"self");
    transactions.addDebitTransaction(500,"self");
    Transactions filteredTransactions = transactions.getAllTransactionsOnDate(new Date());
    assertThat(filteredTransactions.list,hasItem(new CreditTransaction(1000,"self")));
  }
}
