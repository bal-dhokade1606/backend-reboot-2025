
## Double vs BigDecimal

* `double` cannot represent most decimal fractions exactly because it uses binary floating-point representation, which leads to precision and rounding errors.
* `BigDecimal` stores numbers in decimal form with arbitrary precision, making it suitable for monetary calculations.

### **Why double causes problems (simple explanation)**

**How double works?**
 
`double` is a binary floating-point type (IEEE-754). It stores numbers as powers of 2, not 10. Many decimal values cannot be represented exactly in binary.

Classic example:

```
double a = 0.1;
double b = 0.2;
System.out.println(a + b);
```

Output:
```
0.30000000000000004
```
This is not a bug — it’s how floating-point math works.

### Why this is dangerous for money

Example: transaction totals
```
double total = 0.0;
total += 0.1;
total += 0.2;
total += 0.3;
System.out.println(total);
```

Expected:

```
0.6
```

Actual:

```
0.6000000000000001
```


### How BigDecimal solves this?

BigDecimal stores numbers as:
- Unscaled integer
- Scale (decimal places)


So:
```
BigDecimal a = new BigDecimal("0.1");
BigDecimal b = new BigDecimal("0.2");
System.out.println(a.add(b));
```

Output:
```
0.3
```

### Important interview nuance (very important)

❌ Wrong way (still dangerous)
```
new BigDecimal(0.1);  // BAD
```

✅ Correct way
```
BigDecimal.valueOf(0.1);
// OR
new BigDecimal("0.1");
```

### 1. The BigDecimal.equals() trap (very common)
   
**_The issue :_**

BigDecimal.equals() compares **value AND scale**.

So these are NOT equal:
```
new BigDecimal("1.0").equals(new BigDecimal("1.00"))  // false
```

Because:
```
"1.0" has scale 1

"1.00" has scale 2
```
**What to use instead (for numeric equality)?**

**Use compareTo():**
```
new BigDecimal("1.0").compareTo(new BigDecimal("1.00")) == 0  // true
```

Interview implication

If you put BigDecimal in `equals()` / `hashCode()` directly, then two transactions that “look the same amount-wise” may not be equal if scales differ.

**How to handle it? (options)**

**Option A: Normalize scale in constructor (common)**
```
this.amount = amount.setScale(2, RoundingMode.HALF_UP);
```

Then equals/hashCode are stable.

**Option B: Define equality using compareTo (harder)**

If you do that in equals, you must also ensure hashCode matches that definition (non-trivial). Many teams avoid this and normalize instead.

_“BigDecimal.equals is scale-sensitive, so either normalize scale on write or use compareTo for numeric comparisons.”_

### When long minor units are better than BigDecimal?

**What “minor units” means?**

Store money as an integer in the smallest currency unit:

INR: paise

USD: cents

Examples:
```
₹10.25 → 1025 paise

$19.99 → 1999 cents
```
**Why companies choose this?**

- **Performance:** faster than BigDecimal (CPU + GC)

- **Storage:** smaller, simpler

- **Consistency:** no scale surprises

- **Indexing:** DB indexes are simpler and faster

**When it is a great fit?**

- High volume systems (payments, ledgers, wallets)
- Standard currencies with fixed decimal places
- Aggregations, sums, comparisons

**When BigDecimal is better?**

- FX conversions
- interest calculations
- Variable precision/scale computations
- Complex rounding policies

**When amounts are not always currency minor units (e.g., rates)**

- You must store currency + scale rules somewhere. Because minor units depend on currency:

```
JPY has 0 decimals
KWD has 3 decimals
```
So you store:
```
currency + amountMinor
```

_“For high-scale transaction systems, I prefer minor units in long plus currency code; I use BigDecimal for calculations requiring controlled rounding or variable precision.”_

### Common floating-point interview traps (and how to answer)
   
**Trap A: 0.1 + 0.2 != 0.3**

Expected interviewer intent: do you know binary floating point is approximate?

Good answer:

_“double is binary floating-point; many decimal fractions aren’t exactly representable, so results have tiny rounding errors.”_

**Trap B: Comparing doubles with ==**
```
Bad:

if (a == b) ...


Better:

Math.abs(a - b) < 1e-9
```
But for money: don’t use double at all.


**Trap C: Using new BigDecimal(0.1)**

This embeds the floating error into the BigDecimal.

Correct:
```
BigDecimal.valueOf(0.1)        // OK
new BigDecimal("0.1")          // Best for exact decimal input
```

**Trap D: “Rounding happens automatically”**

No—BigDecimal division needs rounding mode if not divisible:
```
new BigDecimal("10").divide(new BigDecimal("3")); // ArithmeticException
```

Correct:
```
divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP)
```

**Trap E: “It’s fine because we format to 2 decimals”**

Formatting hides the display problem but does not fix aggregation correctness.



