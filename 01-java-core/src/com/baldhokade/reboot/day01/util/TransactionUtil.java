package com.baldhokade.reboot.day01.util;

import com.baldhokade.reboot.day01.enums.TransactionType;
import com.baldhokade.reboot.day01.model.Transaction;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionUtil {

  public static Map<String, BigDecimal> getTotalAmtPerType(List<Transaction> txns) {
    if (txns == null || txns.isEmpty()) {
      return Collections.emptyMap();
    }
    return txns.stream()
        .collect(
            Collectors.groupingBy(
                Transaction::getType,
                TreeMap::new,
                Collectors.reducing(BigDecimal.ZERO, Transaction::getAmount, BigDecimal::add)));
  }

  public static Map<String, BigDecimal> getTopThreeCreditTxns(List<Transaction> txns) {
    if (txns == null || txns.isEmpty()) {
      return Collections.emptyMap();
    }
    return txns.stream()
        .filter(txn -> TransactionType.CREDIT.toString().equals(txn.getType()))
        .sorted(new CompareByAmount().reversed())
        .limit(3)
        .collect(
            Collectors.toMap(
                Transaction::getId,
                Transaction::getAmount,
                (existing, replacement) -> replacement,
                LinkedHashMap::new));
  }
}
