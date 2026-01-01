package com.baldhokade.reboot.dsa.prefixsum_hashmap;

import java.util.*;

/**
 * What?
 * -> Prefix sum is a technique where we precompute the cumulative sum of elements up to each index in an array.
 *    Formally, prefixSum[i] = nums[0] + nums[1] + ... + nums[i]
 *    Core Property: sum(l+1 .. r) = prefixSum[r] - prefixSum[l] - The sum of a subarray from index (l + 1) to r
 *
 * When?
 * -> 1. The problem involves contiguous subarrays
 *    2. The condition is exact equality (e.g., sum == k)
 *    3. The array may contain negative numbers
 *    4. Sliding window is not reliable
 *
 * Summary:
 * -> Prefix sum combined with hashing is used to efficiently solve contiguous subarray problems with exact sum constraints,
 *    especially when negative numbers are present.
 */
public class PrefixSumPattern {

  public static int subarraySum(int[] nums, int k){

    if (nums == null || nums.length == 0) return 0;

    Map<Integer, Integer> prefixSumFreq = new HashMap<>();
    prefixSumFreq.put(0, 1);

    int sum = 0, count = 0;

    for(int i = 0; i < nums.length; i++){
      sum += nums[i];

      if(prefixSumFreq.containsKey(sum - k)){
        count += prefixSumFreq.get(sum - k);
      }

      prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
    }

    return count;

  }

  public static int longestSubarraySumK(int[] nums, int k) {

    if (nums == null || nums.length == 0) return 0;

    Map<Integer, Integer> prefixIndex = new HashMap<>();
    prefixIndex.put(0, -1); // to handle subarrays starting at index 0

    int sum = 0, maxLen = 0;

    for (int i = 0; i < nums.length; i++){
      sum += nums[i];

      if(prefixIndex.containsKey(sum - k)){
        maxLen = Math.max(maxLen,  i - prefixIndex.get(sum - k));
      }
      // store only first occurrence
      prefixIndex.putIfAbsent(sum, i);
    }
    return maxLen;
  }

  public static List<int[]> subarraysWithSumKIndices(int[] nums, int k) {
    List<int[]> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;

    Map<Integer, List<Integer>> prefixIndices = new HashMap<>();
    prefixIndices.put(0, new ArrayList<>(Collections.singletonList(-1))); // important

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      int target = sum - k;
      List<Integer> starts = prefixIndices.get(target);
      if (starts != null) {
        for (int j : starts) {
          result.add(new int[]{j + 1, i});
        }
      }

      prefixIndices.computeIfAbsent(sum, x -> new ArrayList<>()).add(i);
    }

    return result;
  }
}
