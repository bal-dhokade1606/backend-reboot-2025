package com.baldhokade.reboot.core;

import com.baldhokade.reboot.core.enums.TransactionType;
import com.baldhokade.reboot.core.model.Transaction;
import com.baldhokade.reboot.core.util.TransactionUtil;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TransactionDemo {

  public static void main(String[] args) {
    Transaction txn1 =
        new Transaction("001", TransactionType.CREDIT, BigDecimal.valueOf(1020.00), "INR");
    Transaction txn2 =
        new Transaction("002", TransactionType.DEBIT, BigDecimal.valueOf(1520.80), "INR");
    Transaction txn3 =
        new Transaction("003", TransactionType.DEBIT, BigDecimal.valueOf(520.80), "INR");
    Transaction txn4 =
        new Transaction("004", TransactionType.CREDIT, BigDecimal.valueOf(3520.80), "INR");
    Transaction txn5 =
        new Transaction("005", TransactionType.DEBIT, BigDecimal.valueOf(1150.80), "INR");
    Transaction txn6 =
        new Transaction("006", TransactionType.CREDIT, BigDecimal.valueOf(950.80), "INR");
    Transaction txn7 =
        new Transaction("007", TransactionType.CREDIT, BigDecimal.valueOf(3750.00), "INR");
    Transaction txn8 =
        new Transaction("008", TransactionType.CREDIT, BigDecimal.valueOf(2150.50), "USD");

    List<Transaction> txnList = Arrays.asList(txn1, txn2, txn3, txn4, txn5, txn6, txn7, txn8);

    System.out.println("\nTransaction List :::: ");
    txnList.forEach(System.out::println);

    System.out.println("\nTotal amount by type :::: ");
    Map<TransactionType, BigDecimal> totalAmtByType = TransactionUtil.getTotalAmtPerType(txnList);
    totalAmtByType.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));

    System.out.println("\nTop 3 credit transactions :::: ");
    Map<String, BigDecimal> topThreeCreditTxns = TransactionUtil.getTopThreeCreditTxns(txnList);
    topThreeCreditTxns.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
  }
}
