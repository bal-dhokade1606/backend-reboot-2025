package com.baldhokade.reboot.day01.util;

import com.baldhokade.reboot.day01.model.Transaction;

import java.util.Comparator;

public class CompareByAmount implements Comparator<Transaction> {

    @Override
    public int compare(Transaction txn1, Transaction txn2) {
        return txn1.getAmount().compareTo(txn2.getAmount());
    }
}
