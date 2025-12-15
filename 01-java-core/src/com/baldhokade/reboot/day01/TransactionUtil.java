package com.baldhokade.reboot.day01;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionUtil {

    public static Map<String, Double> getTotalAmtPerType(List<Transaction> txns){
        if(txns == null || txns.isEmpty()){
            return Collections.emptyMap();
        }
        return txns.stream().collect(Collectors.groupingBy(Transaction::getType, Collectors.summingDouble(Transaction::getAmount)));
    }
}