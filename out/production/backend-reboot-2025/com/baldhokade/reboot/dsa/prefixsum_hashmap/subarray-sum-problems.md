
### Problem-1: Subarray Sum Equals K

**Statement:**

You are given an integer array nums and an integer k. Your task is to count the total number of contiguous subarrays whose sum equals k.

A subarray is a continuous part of the array.

**Input**

- `int[]` nums (can contain positive, negative, and zero values)

- `int k`

**Output**

An integer representing the number of contiguous subarrays whose sum is exactly k

**Examples:**

Example 1
```
Input:
nums = [1, 1, 1]
k = 2

Output:
2

Explanation:
Subarrays with sum = 2:
[1, 1] (index 0 to 1)
[1, 1] (index 1 to 2)

```

Example-2:
```
Input:
nums = [1, 2, 3]
k = 3

Output:
2

Explanation:
Subarrays with sum = 3:
[1, 2]
[3]

```
**Constraints:**

1 ≤ nums.length ≤ 20,000

-1,000 ≤ nums[i] ≤ 1,000

-10^7 ≤ k ≤ 10^7


### Problem-2: Longest Subarray with Sum = K

**Statement:**

You are given an integer array nums and an integer k. Return the length of the longest contiguous subarray whose sum equals k.

Examples

Example 1
```
nums = [1, -1, 5, -2, 3]
k = 3
Output = 4
Explanation: subarray [1, -1, 5, -2] sums to 3
```

Example 2
```
nums = [-2, -1, 2, 1]
k = 1
Output = 2
Explanation: subarray [2, 1]
```

