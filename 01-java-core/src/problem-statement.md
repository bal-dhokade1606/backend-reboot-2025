## Problem Statement

You are given a list of transactions. Each transaction has:

- id (String)
- type (String) → e.g. CREDIT, DEBIT
- amount (double)
- currency (String)

### Your tasks
1️⃣ _Create a Transaction class_

- Fields should be private
- Constructor-based initialization
- Override:
  - equals()
  - hashCode()
- Make it immutable (important)

2️⃣ _Write a Java program that:_

Given a `List<Transaction>`:
- Groups transactions by type
- Calculates total amount per type

**Uses:**
- Map
- Java Streams
- ❌ No for / while loops
- ❌ No external libraries

**Expected output example:**

```
CREDIT -> 4500.00
DEBIT  -> 2300.00
```

3️⃣ _Edge cases to handle_

- Empty transaction list
- Null safety (defensive, not over-engineered)
- Floating-point precision awareness (no BigDecimal yet—just be conscious)

**Technical Constraints**

- Java 8+ only
- Single main class is fine
- Keep code readable (this matters)
