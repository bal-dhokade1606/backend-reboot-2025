package com.baldhokade.reboot.dsa.slidingwindow;

import com.baldhokade.reboot.dsa.slidingwindow.array.SubArraySum;

import java.util.Arrays;

public class ExecuteMain {
  public static void main(String[] args) {

    // Longest substring length

//    String givenString = "ababcdefgaxyzadb";
//    System.out.println("Given String is : " + givenString);
//
//    String longestSubStr = LongestSubString.longestSubstringWithoutRepeating(givenString);
//    int longestSubStrLengthUsingArray =
//        LongestSubString.lengthOfLongestSubstringArray(givenString);
//    int longestSubStrLengthUsingMap =
//        LongestSubString.lengthOfLongestSubstringMap(givenString);
//    int longestSubStrLengthUsingSet =
//        LongestSubString.lengthOfLongestSubstringSet(givenString);
//
//    System.out.println("longest substring without repeating character: " + longestSubStr);
//    System.out.println(
//        "length of longest substring without repeating character using array: "
//            + longestSubStrLengthUsingArray);
//    System.out.println(
//        "length of longest substring without repeating character using map: "
//            + longestSubStrLengthUsingMap);
//    System.out.println(
//        "length of longest substring without repeating character using set: "
//            + longestSubStrLengthUsingSet);

    // Longest Substring with At Most K Distinct Characters

//    int longestSubStrLengthWithKDistinctsChar =
//        SlidingWindowPattern.longestSubstringAtMostKDistinct("eceba", 2);
//    System.out.println(
//        "length of longest substring with at most K distinct characters: "
//            + longestSubStrLengthWithKDistinctsChar);

    // Minimum window problem
//    String givenSting = "ADOBECODEBANC", requiredString = "ABC";
//    System.out.println("Given String :: " + givenSting + "\nRequired String :: " + requiredString);
//    String smallestSubStr = SlidingWindowPattern.minWindow(givenSting, requiredString);
//    System.out.println("smallest substring containing required string :: " + smallestSubStr);

    // longest sub array with sum <= k
    int[] given = {5};
    int k = 3;

    System.out.println("Given Array: " + Arrays.toString(given));
    System.out.println("Expected subarray sum : " + k);
    System.out.println("longest subarray with sum <= " + k + " is : " + SubArraySum.longestSubarraySumAtMostK_nonNegative(given, k));
  }
}
