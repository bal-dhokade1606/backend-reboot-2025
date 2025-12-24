package com.baldhokade.reboot.dsa.prefixsum_hashmap;

import java.util.Arrays;

public class PrefixSumMain {

  public static void main(String[] args){
    int[] nums = {1, -1, 5, -2, 3};
    int k = 3;

    System.out.println("Given Array: " + Arrays.toString(nums));
    System.out.println("Expected subarray sum : " + k);

    System.out.println("Total subarrays having sum " + k + " is : " + PrefixSumPattern.subarraySum(nums, k));
    System.out.println("length of longest subarrays having sum " + k + " is : " + PrefixSumPattern.longestSubarraySumK(nums, k));
  }
}
