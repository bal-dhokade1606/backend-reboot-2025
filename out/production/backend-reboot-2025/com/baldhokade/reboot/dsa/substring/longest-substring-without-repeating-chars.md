## Problem Statement

**Given a string s, find the length of the longest substring without repeating characters.**

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

