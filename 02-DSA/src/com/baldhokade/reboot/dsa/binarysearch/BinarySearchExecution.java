package com.baldhokade.reboot.dsa.binarysearch;

import java.util.Arrays;

public class BinarySearchExecution {

  public static void main(String[] args){
    int[] nums = {-1, 0, 3, 5, 9, 12};
    System.out.println("nums : " + Arrays.toString(nums));
    int target = 12;
    System.out.println("target : " + target);

    int index = BinarySearchUtil.binarySearch(nums, target);
    System.out.println("Binary search target index : " + index);
  }

}
