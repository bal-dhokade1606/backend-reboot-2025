
### What?

_"Java streams represents declarative way of processing data. Instead of describing 
how to iterate and manipulate collections, we describe what transformation we want,
and the stream framework handles the iteration internally."_

A stream:

* is not a data structure
* does not store a data
* works on a source (collection, array, I/O etc.)

Think of stream as a **pipeline of operations applied to data.**


### Key mental model (important)

A stream pipeline has three stages:

1. Source – where data comes from (e.g., list.stream())
2. Intermediate operations – transformations (filter, map, sorted)
3. Terminal operation – triggers execution (collect, forEach, reduce)

Nothing runs until the terminal operation is called.

_"Streams provide high level functional style way to process collections with lazy evaluation and better readability"_


### Lazy evaluation — why streams are efficient?

Streams are lazy meaning,

Intermediate operations do not execute immediately.
They only define **what should happen**
Execution start **only when a terminal operation is invoked**

Example
```
list.stream()
    .filter(x -> {
        System.out.println("filtering " + x);
        return x > 10;   
    })
    .map(x -> x * 2);
```
👉 Nothing prints.

Why? Because there is no terminal operation.

**Why Laziness matters?**

* Avoids unnecessary computation 
* Enables short-circuiting [ ex. `findFirst()`,`anyMatch()`]
* improves performance on large datasets.

### Java Stream Operations — Quick Reference

**Intermediate Operations (Lazy)**

_"These transform the stream and return a new stream.
Nothing executes until a terminal operation is called."_

Transformation:

* `map()` – Transforms each element into another element (1 → 1).
* `flatMap()` – Transforms each element into a stream and flattens (1 → many).
* `peek()` – Performs a side-effect action for debugging (should not modify state).

Filtering:

* `filter()` – Keeps elements that match a condition.
* `distinct()` – Removes duplicate elements (uses equals).


Ordering:

* `sorted()` – Sorts elements using natural order.
* `sorted(Comparator)` – Sorts elements using custom order.


Limiting:

* `limit(n)` – Takes only the first n elements.
* `skip(n)` – Skips the first n elements.


**Terminal Operations (Eager)**

_"These trigger execution of the stream pipeline and produce a result or side effect."_

Short-Circuiting (Stop early)

* `findFirst()` – Returns the first element (preserves encounter order).
* `findAny()` – Returns any matching element (faster in parallel).
* `anyMatch()` – Returns true if any element matches.
* `allMatch()` – Returns true if all elements match.
* `noneMatch()` – Returns true if no elements match.

Reduction / Aggregation

* `reduce()` – Combines elements into a single value using an associative operation.
* `count()` – Returns number of elements.
* `min() / max()` – Finds minimum or maximum element.
* `sum() / average()` – Numeric aggregations (via primitive streams).

Collection

* `collect()` – Accumulates elements into a collection or map.
* `toArray()` – Converts stream to array.

Side-Effect Operations

* `forEach()` – Performs an action on each element (order not guaranteed in parallel).
* `forEachOrdered()` – Performs action in encounter order (slower in parallel).

Primitive Stream Conversions

* `mapToInt() / mapToLong() / mapToDouble()` – Converts to primitive stream.

* `boxed()` – Converts primitive stream back to wrapper stream.

Stream Creation (for completeness)

* `stream()` – Creates stream from collection.
* `parallelStream()` – Creates parallel stream.
* `Stream.of(...)` – Creates stream from values.
* `Arrays.stream()` – Creates stream from array.

🧠 **Interview Memory Hooks (VERY IMPORTANT)**

* Intermediate = lazy, chainable
* Terminal = triggers execution
* Short-circuiting = stops early
* map ≠ Map
* Streams don’t store data
* Prefer stateless lambdas

🎯 **One-liner you can say in interviews**

_“Intermediate operations define the pipeline lazily, and terminal operations trigger execution and produce results.”_



### `map` vs `flatMap`

`map` ->  one-to-one transformation.

`map` transforms each element into exactly one element

Example:
```
List<String> names = List.of("a", "bb", "ccc");

List<Integer> length = names.stream()
                            .map(String :: length)
                            .collect(Collectors.toList());
```

Each input produces **one output.**

`flatMap` -> one-to-many transformation + flattening

`flatMap` is used when:
* Each element maps to a collection or stream.
* And you want a single flattened stream.

Example:
```
List<List<Integer>> data = List.of(
    List.of(1, 2),
    List.of(3, 4)
);

List<Integer> result =
    data.stream()
        .flatMap(List::stream)
        .collect(Collectors.toList());
```

Result:
```
[1, 2, 3, 4]
```

_“map is used for one-to-one transformations, while flatMap is used when each element produces multiple values 
and we want to flatten them into a single stream.”_



### `forEach` vs `forEachOrdered`

`forEach`

* Does not guarantee order
* Faster in parallel stream
* Suitable when order does not matter 

`forEachOrdered`

* Preserve original order
* May reduce parallel performance
* Used when order matters

```
list.parallelStream().forEachOrdered(System.out::println);
```

_“forEach allows unordered processing for better performance, while forEachOrdered preserves the original order, especially important in parallel streams.”_


### reduce() vs collect()

`reduce()` - immutable reduction (combines element into single value)

**Concept:**
- combines element into single value
- uses an associative operation
- No mutable container involved

Example
```
int sum = list.stream().reduce(0, Integer::sum);
```

use `reduce()` when:
- result is a single value
- operation is associative and stateless

`collect()` - mutable reduction

Concept:

- Accumulates elements into mutable container
- Designed for list, sets, maps

Example:
```
List<Integer> result = 
        list.stream().collect(Collectors.toList());
```

**Why `collect()` is preferred for container?**

- Internally optimized
- Thread-safe when used with parallel streams
- clearer intent

"`reduce` is used for immutable value aggregation while `collect()` is used for mutable reductions like building collections or maps."


### Big-picture takeaway (very important)

**Streams are about:**

* What, not how
* Immutability
* Stateless operations
* Readable intent


### Streams vs Traditional Loops — When and Why

**How to think about it (mental model)**

**Streams** → describe what you want

**Loops** → describe how to do it

Neither is “better” universally.

**When Streams are a GOOD choice**

1️⃣ **Data transformation pipelines**

When the problem is:
```
filter → transform → aggregate
```
Example:
```
int sum =
list.stream()
.filter(x -> x > 10)
.mapToInt(x -> x)
.sum();
```

Why streams fit well:

* Reads like business logic
* No index/state tracking
* Less boilerplate

Interview line:

_“Streams are ideal for declarative data transformations.”_

2️⃣ **Read-only, stateless operations**

When:

* No mutation
* No shared state
* No complex control flow

Streams shine here.

3️⃣ **Easy parallelization (carefully)**

If:

* Operation is CPU-bound
* Stateless
* Order doesn’t matter

```
list.parallelStream()
.map(this::heavyCompute)
.collect(Collectors.toList());
```

**When Loops are a BETTER choice**

1️⃣ **Complex control flow**

If you need:

* break
* continue
* nested conditions
* early exits with multiple rules

Example:
```
for (Item i : items) {
    if (i.isInvalid()) break;
    if (i.shouldSkip()) continue;
    process(i);
}
```

Trying this in streams usually hurts readability.

Interview line:

_“For complex control flow, loops are clearer and safer.”_

2️⃣ **Heavy exception handling**

Streams are not exception-friendly.

If:

* error handling is central
* multiple recovery paths exist

Prefer loops.

3️⃣ **Performance-critical tight loops**

In some low-level or hot-path code:

* loops are easier to optimize
* less allocation / lambda overhead

(Not common, but valid to mention.)

4️⃣ **Stateful transformations**

If logic depends on:

* previous elements
* shared mutable state

Streams become dangerous or misleading.

Very important misconception to avoid

* ❌ _“Streams are always slower than loops”_
* ❌ _“Streams are always cleaner than loops”_

Both are wrong.

Correct view:

Streams optimize clarity, loops optimize control.

* _“Prefer streams for declarative, stateless data transformations and aggregation."_ 
* _"Prefer loops when control flow, exception handling, or stateful logic is important. Choose based on readability and correctness, not syntax.”_



### Collectors Deep Dive
(`groupingBy`, `mapping`, `reducing`)


1️⃣ **What is a Collector (first principles)**

_"A Collector defines how stream elements are accumulated into a final result, including how to create the container, add elements, and combine partial results."_

So `collect()` is just the terminal operation,
the `Collector` defines how collection happens.

2️⃣ **`groupingBy` — the most important collector**

What it does

_"Groups stream elements by a `key` and returns a `Map<K, List<V>>` by default."_

Simple example
```
Map<String, List<String>> byLength =
             words.stream()
                  .collect(Collectors.groupingBy(
                        w -> w.length() > 3 ? 
                        "LONG" 
                        : 
                        "SHORT"
                  ));
```

Result:
```
{
    SHORT = ["a", "to"],
    LONG  = ["hello", "world"]
}
```

_“`groupingBy` classifies elements based on a key function and groups them into a `map`.”_

3️⃣ **Why `groupingBy` is powerful (and not just syntax sugar)**

Because it combines:

* classification
* accumulation
* reduction

All in one pass.

Without streams, this would be:

* a loop
* containsKey checks
* manual list management

4️⃣ **`groupingBy` with downstream collectors (VERY IMPORTANT)**

Basic form

`groupingBy(classifier)`

Advanced form

`groupingBy(classifier, downstreamCollector)`

5️⃣ **`groupingBy` + `counting`**

Problem

_Count how many elements fall into each group._
```
Map<String, Long> countByType =
                   items.stream()
                        .collect(Collectors.groupingBy(
                            Item::getType,
                            Collectors.counting()
                        ));
```

Result
```
{A=3, B=5}
```

_“Instead of collecting lists, I can apply a downstream collector like counting to directly aggregate results.”_

6️⃣ **`groupingBy` + `mapping`**

Why mapping exists

Sometimes you:

group by one thing, but want to collect a transformed value

Example

Group users by department, but store names only.
```
Map<String, List<String>> usersByDept =
                    users.stream()
                         .collect(Collectors.groupingBy(
                                User::getDepartment,
                                Collectors.mapping(User::getName, Collectors.toList())
                         ));
```

_“mapping allows transformation before accumulation inside a grouping operation.”_

7️⃣ **`groupingBy` + `reducing`**

When to use reducing

Use it when:

* you want custom aggregation
* and no simpler collector exists

Example:

sum salaries per department
```
Map<String, Integer> salaryByDept =
           employees.stream()
                    .collect(Collectors.groupingBy(
                                    Employee::getDept,
                                    Collectors.reducing(
                                            0,
                                            Employee::getSalary,
                                            Integer::sum
                                    )
                    ));
```

What’s happening conceptually

* 0 → identity
* Employee::getSalary → mapping
* Integer::sum → associative reduction

_“reducing performs a custom associative reduction as a downstream collector.”_

8️⃣ **Important design note**

Often:
```
Collectors.summingInt(Employee::getSalary)
```

is better than reducing.

_“Prefer specialized collectors when available; reducing is for cases without built-in alternatives.”_

9️⃣ Mental hierarchy (WRITE THIS)
```
collect()
└── Collector
├── groupingBy
│     ├── counting
│     ├── mapping
│     └── reducing
├── toList / toSet
└── joining
```

_“`Collectors` define how stream elements are accumulated. `groupingBy` classifies data, and downstream collectors like `mapping`, `counting`, and `reducing` control how each group is aggregated.”_


