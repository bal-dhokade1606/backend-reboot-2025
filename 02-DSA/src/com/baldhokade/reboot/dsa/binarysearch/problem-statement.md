## Binary Search

### Problem 1: Binary Search in a Sorted Array

Statement:

You are given a sorted integer array `nums` and an integer `target`.
Return the index of target if it exists in the array.
Otherwise, return -1.

**Input**

- Sorted integer array `nums`
- Integer target

**Output**

- Index of target, or -1

Example
```
nums = [-1, 0, 3, 5, 9, 12]
target = 9

Output: 4
```


### Problem-2: First Occurrence of Target

Statement:

You are given a sorted integer array `nums` (may contain duplicates) and an integer `target`.

Return the `index` of the first occurrence of `target`.

If the `target` does not exist, return -1.


**Example:**
```
nums = [1,2,2,2,3,4]
target = 2

Output: 1
```

### problem-3: Last Occurrence of Target

Statement:

Return the index of the last occurrence of target in a sorted array.

Example:
```
nums = [1,2,2,2,3,4], target = 2
Output = 3
```

## Binary Search On Answer Space

### Problem-1: Integer Square Root

**Statement:**

Given a non-negative integer x, return the floor of its square root.

- Do not use built-in math functions
- Return only the integer part

Examples:

```
Input:  x = 4
Output: 2

Input:  x = 8
Output: 2   (since sqrt(8) ≈ 2.82)
```
Note: search the answer space to find the largest integer whose square does not exceed x.

### Problem-2: Binary Search on Answer Space

**Statement:**

You are given an array weights, where `weights[i]` represents the weight of the i-th package, and an integer days.

You must ship all packages in order within `days` days.

Each day, you can ship packages with a maximum capacity `C`.

Return the minimum capacity `C` required to ship all packages within `days`.

Example:

```
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5

Output = 15
```

Note: search the minimum capacity where shipping is feasible, because feasibility changes only in one direction.

**Why Binary Search applies**

Observation:

- If we can ship with capacity C
- Then we can also ship with any capacity > C

This is a **one-directional (ordered) condition**.

### Problem-3: KoKo Eating Bananas (Minimum Valid) [Homework]

Statement:

Koko has piles[] of bananas.
She can eat K bananas per hour and has h hours.

Return the minimum integer K such that she can finish all bananas within h hours.

Example

```
piles = [3,6,7,11]
h = 8
Output = 4
```

**Hints:**

- Search space: K = [1 … max(piles)]
- Condition: canEat(K) → total hours ≤ h
- Pattern: minimum valid


### Problem-4: Allocate Minimum Number of Pages (Minimum Valid)

Statement:

Given pages[] where pages[i] is number of pages in the i-th book,
and students, allocate books contiguously so that the maximum pages assigned to any student is minimized.

Return that minimum value.

Example
```
pages = [12, 34, 67, 90]
students = 2

Output = 113
```

**Hints:**

- **Search space:** [max(pages) … sum(pages)]
- **Condition:** canAllocate(maxPages)
- **Pattern:** minimum valid

### Problem-5: Painters Partition (Minimum Valid) [Homework]

Statement:

You have boards[] and k painters.
Each painter paints contiguous boards.
Time taken = sum of board lengths.

Find the minimum time to paint all boards.

Example

```
boards = [10, 20, 30, 40]
k = 2
Output = 60
```

**Note: This is the same pattern as shipping packages.

### Problem-6: Aggressive Cows (Maximum Valid) [Homework]

Statement:

Given stall positions (unsorted) and k cows, place cows so that the minimum distance between any two cows is maximized.

Return that maximum minimum distance.

Example
```
stalls = [1, 2, 8, 4, 9]
k = 3
Output = 3
```

**Hints:**

- Sort stalls first
- Search space: distance [1 … maxDistance]
- Condition: canPlace(distance)

**Note - Pattern: maximum valid

