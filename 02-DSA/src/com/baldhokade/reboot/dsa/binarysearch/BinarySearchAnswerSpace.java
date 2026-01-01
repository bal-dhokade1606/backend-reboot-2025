package com.baldhokade.reboot.dsa.binarysearch;

public class BinarySearchAnswerSpace {

  public static int mySqrt(int x) {
    if (x < 2) return x;

    int left = 1, right = x / 2;
    int ans = 0;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      // use long to avoid overflow
      long sq = (long) mid * mid;

      if (sq <= x) {
        ans = mid;        // mid is a valid answer
        left = mid + 1;   // try for a bigger one
      } else {
        right = mid - 1;  // mid is too large
      }
    }
    return ans;
  }

  public static int shipWithinDays(int[] weights, int days) {
    int left = 0, right = 0;

    // establish search space
    for (int w : weights) {
      left = Math.max(left, w); // minimum capacity
      right += w;               // maximum capacity
    }

    int ans = right;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (canShip(weights, days, mid)) {
        ans = mid;           // mid is a valid capacity
        right = mid - 1;     // try smaller capacity
      } else {
        left = mid + 1;      // capacity too small
      }
    }
    return ans;
  }

  private static boolean canShip(int[] weights, int days, int capacity) {
    int usedDays = 1;
    int currentLoad = 0;

    for (int w : weights) {
      if (currentLoad + w > capacity) {
        usedDays++;          // need new day
        currentLoad = 0;
      }
      currentLoad += w;
    }
    return usedDays <= days;
  }


}
