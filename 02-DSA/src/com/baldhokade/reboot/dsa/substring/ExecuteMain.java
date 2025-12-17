package com.baldhokade.reboot.dsa.substring;

public class ExecuteMain {
  public static void main(String[] args) {

    String givenString = "ababcdefgaxyzadb";
    System.out.println("Given String is : " + givenString);

    // Longest substring length
    /*String longestSubStr = new LongestSubString().longestSubstringWithoutRepeating(givenString);
    int longestSubStrLengthUsingArray =
        new LongestSubString().lengthOfLongestSubstringArray(givenString);
    int longestSubStrLengthUsingMap =
        new LongestSubString().lengthOfLongestSubstringMap(givenString);
    int longestSubStrLengthUsingSet =
        new LongestSubString().lengthOfLongestSubstringSet(givenString);

    System.out.println("longest substring without repeating character: " + longestSubStr);
    System.out.println(
        "length of longest substring without repeating character using array: "
            + longestSubStrLengthUsingArray);
    System.out.println(
        "length of longest substring without repeating character using map: "
            + longestSubStrLengthUsingMap);
    System.out.println(
        "length of longest substring without repeating character using set: "
            + longestSubStrLengthUsingSet);*/

    // Longest Substring with At Most K Distinct Characters

    int longestSubStrLengthWithKDistinctsChar =
        SlidingWindowPattern.longestSubstringAtMostKDistinct("eceba", 2);
    System.out.println(
        "length of longest substring with at most K distinct characters: "
            + longestSubStrLengthWithKDistinctsChar);
  }
}
