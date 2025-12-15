package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionUtil {

    public static Map<String, Double> getTotalAmtPerType(List<Transaction> txns){
        if(txns == null || txns.isEmpty()){
            return new HashMap<>();
        }
        System.out.println("Size of list = " + txns.size());
        return txns.stream().collect(Collectors.groupingBy(Transaction::getType, Collectors.summingDouble(Transaction::getAmount)));
    }
}