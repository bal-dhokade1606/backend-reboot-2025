package com.baldhokade.reboot.dsa.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointersPattern {

  public static int[] twoSumSorted(int[] nums, int target) {

    if (nums == null || nums.length < 2) {
      return new int[] {-1, -1};
    }

    int left = 0, right = nums.length - 1, sum = 0;

    while (left < right) {
      sum = nums[left] + nums[right];

      if (sum == target) {
        return new int[] {left, right};
      }

      if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return new int[] {-1, -1};
  }

  public static int removeDuplicates(int[] nums) {

    if (nums == null || nums.length == 0) {
      return 0;
    }

    int write = 1; // first element i always unique

    // Because the array is sorted, we only copy an element when it differs from the previous one,
    // compacting all unique values at the front.

    // Pointer roles
    //
    // - write → index where the next unique element should be written
    // - read → scans the array
    for (int read = 1; read < nums.length; read++) {
      if (nums[read] != nums[read - 1]) {
        nums[write] = nums[read];
        write++;
      }
    }
    return write;
  }

  public static int[] mergeSorted(int[] a, int[] b) {
    if (a == null) a = new int[0];
    if (b == null) b = new int[0];

    int[] result = new int[a.length + b.length];
    int i = 0, j = 0, k = 0;

    // merge while both arrays have elements
    while (i < a.length && j < b.length) {
      if (a[i] <= b[j]) {
        result[k++] = a[i++];
      } else {
        result[k++] = b[j++];
      }
    }

    // copy remaining elements
    while (i < a.length) {
      result[k++] = a[i++];
    }
    while (j < b.length) {
      result[k++] = b[j++];
    }

    return result;
  }

  //Note - In 3Sum, for each fixed element nums[i], we solve a Two Sum problem on the remaining array with target -nums[i].
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 3) return res;

    //Sorting enables monotonic pointer movement and makes duplicate handling straightforward,
    // reducing the problem to repeated two-sum.
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {

      // 1) skip duplicate 'i'
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      // After sorting, if nums[i] > 0, all remaining values are >= nums[i],
      // so the sum must be > 0; hence no zero-sum triplet is possible.
      // that's why optional early break: if smallest already > 0, sum can't be 0
      if (nums[i] > 0) break;

      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));

          // 2) skip duplicate 'left'
          while (left < right && nums[left] == nums[left + 1]) left++;
          // 3) skip duplicate 'right'
          while (left < right && nums[right] == nums[right - 1]) right--;

          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return res;
  }
}
