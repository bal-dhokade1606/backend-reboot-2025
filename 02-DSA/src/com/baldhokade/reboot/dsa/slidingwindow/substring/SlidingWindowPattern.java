package com.baldhokade.reboot.dsa.slidingwindow.substring;

import java.util.*;

/*

Definition:

- Sliding window means, Maintain a window (range) over the data and move it intelligently instead of restarting from scratch.
- Sliding window is a general technique where we maintain a moving range that satisfies a condition;
  the condition and state change per problem, but the left–right pointer mechanics stay the same.
- Sliding window is always the same two-pointer movement. Only the state and the condition change.

- What each term means (very crisp)

1️⃣ State

The data you maintain to evaluate the window.

Examples:

Frequency map (Map<Character, Integer>)
Current sum (int sum)
Count of distinct elements
Count of odd numbers

2️⃣ Condition

The rule that decides whether the window is valid.

Examples:

No duplicates
At most K distinct characters
Sum ≤ K
Window size == K

*/

public class SlidingWindowPattern {

  public static int lengthOfLongestSubstringArray(String str) {

    if (str == null || str.isEmpty()) {
      return 0;
    }
    int maxLength = 0;
    int left = 0;

    int[] lastSeen = new int[128];
    Arrays.fill(lastSeen, -1);

    for (int right = 0; right < str.length(); right++) {
      char c = str.charAt(right);
      if (lastSeen[c] >= left) {
        left = lastSeen[c] + 1;
      }
      lastSeen[c] = right;
      // The sliding window length keeps changing.
      // But the answer we want is the maximum length seen at any point in time.
      // So we need to get max length till now
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }

  public static int lengthOfLongestSubstringMap(String str) {
    if (str == null || str.isEmpty()) {
      return 0;
    }
    int maxLength = 0;
    int left = 0;

    Map<Character, Integer> lastSeen = new HashMap<>();

    for (int right = 0; right < str.length(); right++) {
      char c = str.charAt(right);

      Integer prev = lastSeen.get(c);
      if (prev != null && prev >= left) {
        left = prev + 1;
      }
      lastSeen.put(c, right);
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }

  public static int lengthOfLongestSubstringSet(String str) {
    if (str == null || str.isEmpty()) {
      return 0;
    }
    int maxLength = 0;
    int left = 0;

    Set<Character> window = new HashSet<>();

    for (int right = 0; right < str.length(); right++) {
      char c = str.charAt(right);

      // This is easier to understand but slightly less direct, because when duplicate occurs, you
      // move left one-by-one.
      while (window.contains(c)) {
        window.remove(str.charAt(left));
        left++;
      }
      window.add(c);
      maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
  }

  public static String longestSubstringWithoutRepeating(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }

    Map<Character, Integer> lastSeen = new HashMap<>();
    int left = 0;

    int bestStart = 0;
    int bestLen = 0;

    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);

      Integer prev = lastSeen.get(c);
      if (prev != null && prev >= left) {
        left = prev + 1;
      }

      lastSeen.put(c, right);

      int windowLen = right - left + 1;
      if (windowLen > bestLen) {
        bestLen = windowLen;
        bestStart = left;
      }
    }

    return s.substring(bestStart, bestStart + bestLen);
  }

  public static int longestSubstringAtMostKDistinct(String s, int k) {
    if (s == null || s.isEmpty() || k <= 0) return 0;

    Map<Character, Integer> freq = new HashMap<>();
    int left = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);

      // 1) add c to freq
      freq.put(c, freq.getOrDefault(c, 0) + 1);

      // 2) if distinct chars > k, shrink from left
      while (freq.size() > k) {
        char leftChar = s.charAt(left);

        // decrement freq for leftChar
        freq.put(leftChar, freq.get(leftChar) - 1);
        // if freq becomes 0, remove it
        if (freq.get(leftChar) == 0) {
          freq.remove(leftChar);
        }
        // move left
        left++;
      }

      // 3) update maxLength
      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }

  public static int longestSubstringExactlyKDistinct(String s, int k) {
    if (s == null || s.isEmpty() || k <= 0){
      return 0;
    }

    // consider freq map only contains distinct character with one or more occurrences
    Map<Character, Integer> freq = new HashMap<>();
    int left = 0, best = 0;

    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      // add c
      freq.put(c, freq.getOrDefault(c, 0) + 1);

      // shrink while distinct > k
      while (freq.size() > k){
        char leftChar = s.charAt(left);
        freq.put(leftChar, freq.get(leftChar) - 1);
        if (freq.get(leftChar) == 0) {
          freq.remove(leftChar);
        }
        left++;
      }
      // if distinct == k, update best
      if (freq.size() == k){
        best = Math.max(best, right - left + 1);
      }
    }

    return best;
  }

  /**
   * minimum window problem
   * @param s - main string
   * @param t - required chars string in substring of s
   * @return smallest substring of s that contains all char of t
   */
  public static String minWindow(String s, String t){
    if(s == null || s.isEmpty() || t == null || t.isEmpty()){
      return "";
    }

    Map<Character, Integer> requiredCharCount = new HashMap<>();
    char tc;
    for (int i = 0; i < t.length(); i++){
      tc = t.charAt(i);
      requiredCharCount.put(tc, requiredCharCount.getOrDefault(tc, 0) + 1);
    }

    int totalRequiredChar = requiredCharCount.size();

    Map<Character, Integer> currentCharCount = new HashMap<>();

    int left = 0, bestStart = 0, bestLen = Integer.MAX_VALUE, requiredCharSatisfied = 0;

    for(int right = 0; right < s.length(); right++){
      char rsc = s.charAt(right);

      currentCharCount.put(rsc, currentCharCount.getOrDefault(rsc, 0) + 1);

      if(requiredCharCount.containsKey(rsc) && currentCharCount.get(rsc).intValue() == requiredCharCount.get(rsc).intValue()){
        requiredCharSatisfied++;
      }

      while(left <= right && totalRequiredChar == requiredCharSatisfied){
        int windowLen = right - left + 1;
        if(windowLen < bestLen){
          bestLen = windowLen;
          bestStart = left;
        }

        char lsc = s.charAt(left);
        currentCharCount.put(lsc, currentCharCount.get(lsc) - 1);
        if (currentCharCount.get(lsc) == 0){
          currentCharCount.remove(lsc);
        }

        if(requiredCharCount.containsKey(lsc) && currentCharCount.getOrDefault(lsc, 0) < requiredCharCount.get(lsc)){
          requiredCharSatisfied--;
        }

        left++;
      }

    }
    return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
  }

}
