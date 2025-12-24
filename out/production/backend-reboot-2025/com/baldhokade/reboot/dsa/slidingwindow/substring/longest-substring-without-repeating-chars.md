

### _Problem-1: Given a string s, find the length of the longest substring without repeating characters._

Example
```
Input:  "abcabcbb"
Output: 3   // "abc"

Input:  "bbbbb"
Output: 1   // "b"

Input:  "pwwkew"
Output: 3   // "wke"
```
**Constraints (interview-realistic)**

- No brute force
- Expected time: O(n)

**Use:**

Approach-1:
- No extra data structure

Approach-2: 
- use below
    - HashMap<Character, Integer> or
    - HashSet<Character>
    - Java only

**What the interviewer is testing?**

- Can you manage a moving window?
- Do you know when to move left vs right?
- Can you avoid off-by-one errors?
- Can you explain your logic calmly?

**Instructions for you**

_Think about:_
- What does the window represent?
- When do you shrink it?
- Write the Java method only (no main)
- Explain briefly why it works

_Method signature_

```
public int lengthOfLongestSubstring(String s)
```

### Problem-2: Longest substring with at most K distinct characters

Given String s and integer k, return the length of the longest substring that contains at most k distinct characters.

Example:
```
s = "eceba", k = 2 → output 3 ("ece")
s = "aa", k = 1 → output 2 ("aa")
```
**Key difference from Problem 1:**

- **State:** Map<Character, Integer> frequency

- **Condition:** map.size() <= k

When condition breaks → 
- shrink left, 
- decrement freq, 
- remove if zero, 
- Update max length in every iteration


### Problem-3: Longest Substring with Exactly K Distinct Characters

Statement:

Given a string s and an integer k, find the length of the longest substring that contains exactly k distinct characters.

Examples
```
s = "eceba", k = 2 → 3 ("ece")

s = "aa", k = 1 → 2

s = "aa", k = 2 → 0
```

✅ Edge cases

Handled properly:
```
s == null → 0

s.isEmpty() → 0

k <= 0 → 0

If no substring has exactly k distinct chars → returns 0
```
Example checks:
```
"aa", k = 2 → 0 ✅

"eceba", k = 2 → 3 ("ece") ✅

"aa", k = 1 → 2 ✅
```

✅ Time & space complexity (what to say)

**Time:** O(n) — each character enters and leaves the window at most once

**Space:** O(k) — at most k distinct characters in the map

**Subtle but important conceptual clarity (you got this right)**

- **At most K** → update result every iteration

- **Exactly K** → update result only when `freq.size() == k`


### Problem-4: Minimum Window Substring [HARD]

Statement:

Given two strings s and t, return the smallest substring of s that contains all characters of t (including duplicates).

Example
```
s = "ADOBECODEBANC", t = "ABC" → "BANC"

s = "a", t = "aa" → ""
```

