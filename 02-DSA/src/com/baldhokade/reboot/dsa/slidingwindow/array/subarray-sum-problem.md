
### Problem-1: Longest Subarray with Sum at Most K (Non-Negative Numbers)

**Statement:**

You are given an integer array nums containing only non-negative integers and an integer k.
Your task is to find the length of the longest contiguous subarray whose sum is less than or equal to k.


**Input**

- An integer array nums where nums[i] ≥ 0

- An integer k

**Output**

- An integer representing the maximum length of a contiguous subarray whose sum is ≤ k

**Examples**

Example 1

```
Input:
nums = [1, 2, 1, 0, 1, 1, 0]
k = 4

Output:
5

Explanation:
The subarray [1, 0, 1, 1, 0] has sum = 3 ≤ 4 and length = 5,
which is the longest possible.
```

Example 2

```
Input:
nums = [2, 1, 1, 1, 2]
k = 3

Output:
3

Explanation:
Subarrays like [1,1,1] have sum = 3 and length = 3.
```

Example 3 (edge case)
```
Input:
nums = [5]
k = 3

Output:
0

Explanation:
No subarray satisfies sum ≤ k.
```

Constraints:

```
1 ≤ nums.length ≤ 10^5

0 ≤ nums[i] ≤ 10^4

0 ≤ k ≤ 10^9
```