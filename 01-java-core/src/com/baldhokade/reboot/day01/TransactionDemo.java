package com.baldhokade.reboot.day01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TransactionDemo {

    public static void main(String[] args) {
        Transaction txn1 = new Transaction("001", "credit", 1020.00, "INR");
        Transaction txn2 = new Transaction("002", "debit", 1520.80, "INR");
        Transaction txn3 = new Transaction("003", "debit", 520.80, "INR");
        Transaction txn4 = new Transaction("004", "credit", 3520.80, "INR");
        Transaction txn5 = new Transaction("005", "debit", 1150.80, "INR");

        Map<String, Double> totalAmtByType = TransactionUtil.getTotalAmtPerType(Arrays.asList(txn1,txn2,txn3,txn4,txn5));

        totalAmtByType.forEach((key, value) -> System.out.printf("%s -> %.2f\n", key, value));
    }
}