package com.baldhokade.reboot.dsa.slidingwindow.array;


public class SubArraySum {

  public static int longestSubarraySumAtMostK_nonNegative(int[] nums, int k){

    if (nums == null || nums.length == 0) return 0;

    int sum = 0, left = 0, best = 0;

    for(int right = 0; right < nums.length; right++){
      sum += nums[right];

      while(left <= right && sum > k){
        sum -= nums[left++];
      }

      best = Math.max(best, right - left + 1);
    }

    return best;
  }
}
