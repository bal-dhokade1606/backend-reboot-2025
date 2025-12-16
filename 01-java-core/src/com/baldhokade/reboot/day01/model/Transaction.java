package com.baldhokade.reboot.day01.model;

import com.baldhokade.reboot.day01.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {

  private final String id;
  private final TransactionType type;
  private final BigDecimal amount;
  private final String currency;

  public Transaction(String id, TransactionType type, BigDecimal amount, String currency) {
    if (Objects.isNull(id)
        || id.trim().isEmpty()
        || Objects.isNull(type)
        || Objects.isNull(amount)
        || amount.signum() <= 0
        || Objects.isNull(currency)
        || currency.trim().isEmpty()) {
      throw new IllegalArgumentException(
          "One of Transaction id, type, amount, currency value is invalid");
    }
    this.id = id;
    this.type = type;
    this.amount = amount;
    this.currency = currency;
  }

  public String getId() {
    return id;
  }

  public TransactionType getType() {
    return type;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (!(object instanceof Transaction)) return false;
    Transaction that = (Transaction) object;
    return Objects.equals(amount, that.amount)
        && Objects.equals(id, that.id)
        && Objects.equals(type, that.type)
        && Objects.equals(currency, that.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, amount, currency);
  }

  @Override
  public String toString() {
    return "{"
        + "id:'"
        + id
        + '\''
        + ", type:"
        + type
        + ", amount:"
        + amount
        + ", currency:'"
        + currency
        + '\''
        + '}';
  }
}
