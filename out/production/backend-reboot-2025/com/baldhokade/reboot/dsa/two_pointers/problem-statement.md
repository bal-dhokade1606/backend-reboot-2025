
### Problem-1: Two Sum in a Sorted Array

**Statement**

You are given a sorted integer array `nums` (sorted in non-decreasing order) and an integer `target`.

Your task is to determine whether there exists two distinct indices i and j such that:

- i < j
- nums[i] + nums[j] == target

**Input:**

- An integer array `nums` sorted in ascending order
- An integer target

**Output:**

- Return true if such a pair exists
- Otherwise, return false

(Variant: return the indices instead of true/false)

**Examples**

Example 1
```
Input:
nums = [1, 2, 4, 6, 10]
target = 8

Output:
true

Explanation:
nums[1] + nums[3] = 2 + 6 = 8
```

Example 2
```
Input:
nums = [1, 3, 5, 7]
target = 4

Output:
false
```

**Constraints:**

- 2 ≤ nums.length ≤ 10^5
- nums is sorted in ascending order
- -10^9 ≤ nums[i], target ≤ 10^9

**Important Notes (Interview Expectations)**

- The array is already sorted
- Do not use nested loops
- Optimal solution must be O(n)
- Extra space should be O(1)


### Problem-2: Remove Duplicates from Sorted Array

**Statement:**

You are given a sorted integer array nums in non-decreasing order.
Your task is to remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements must be preserved.

**After removing duplicates:**

- Return the number of unique elements k
- The first k elements of the array should contain the unique values
- It does not matter what values exist beyond index k - 1

**Input:**

A sorted integer array `nums`

**Output:**

- An integer `k` representing the count of unique elements
- The array modified in-place for the first `k` positions

**Examples**

Example 1
```
Input:
nums = [1,1,2]

Output:
k = 2
nums = [1,2,_]
```

Example 2
```
Input:
nums = [0,0,1,1,1,2,2,3,3,4]

Output:
k = 5
nums = [0,1,2,3,4,_,_,_,_,_]
```

Constraints

- 1 ≤ nums.length ≤ 10^5
- Array is sorted
- Do not use extra arrays (O(1) space)

Important Notes (Interview Expectations)

- Must modify the array in-place
- Do not use additional data structures
- Time complexity must be O(n)
- Use the two pointers (fast/slow) technique


### Problem-3: 3Sum

**Statement:**

You are given an integer array nums.
Your task is to find all unique triplets [nums[i], nums[j], nums[k]] such that:

- i ≠ j, j ≠ k, i ≠ k
- nums[i] + nums[j] + nums[k] == 0
- The solution set must not contain duplicate triplets

Return the triplets in any order.

**Input:**

An integer array nums

**Output:**

A list of unique triplets where the sum is 0

**Examples**

Example 1

```
Input:
nums = [-1, 0, 1, 2, -1, -4]

Output:
[[-1, -1, 2], [-1, 0, 1]]
```

Example 2
```
Input:
nums = [0, 1, 1]

Output:
[]
```

Example 3
```
Input:
nums = [0, 0, 0, 0]

Output:
[[0, 0, 0]]
```

**Constraints**

- 3 ≤ nums.length ≤ 3000
- -10^5 ≤ nums[i] ≤ 10^5

