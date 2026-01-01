package com.baldhokade.reboot.dsa.binarysearch;

public class BinarySearch {

  public static int binarySearch(int[] nums, int target) {
    if(nums != null && nums.length == 0){
      return -1;
    }

    int left = 0, right = nums.length - 1;

    while (left <= right){
      // prevents integer overflow when left and right are large.
      // identical to (left + right)/2 which can cause integer overflow when numbers are large
      int mid = left + (right - left)/2;

      if(nums[mid] == target){
        return mid;
      } else if(nums[mid] < target){
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }

  public static int firstOccurrence(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    int ans = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        ans = mid;          // record
        right = mid - 1;    // search left half
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }

  public static int lastOccurrence(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    int ans = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        ans = mid;         // record
        left = mid + 1;    // search right half
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }
}
