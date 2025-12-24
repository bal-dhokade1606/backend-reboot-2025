package com.baldhokade.reboot.dsa.two_pointers;

import java.util.Arrays;

public class TwoPointersExecution {

  public static void main(String[] args) {

//    int[] nums = {1, 1, 2, 2, 2, 4, 7, 7, 8};
//    int target = 4;

    //    System.out.println(
    //        "Given sorted integer array is : " + Arrays.toString(nums) + "\ntarget is : " +
    // target);
    //    System.out.println(
    //        "indexes satisfying sum as target["
    //            + target
    //            + "] is : "
    //            + Arrays.toString(TwoPointersPattern.twoSumSorted(nums, target)));
//    int k = TwoPointersPattern.removeDuplicates(nums);
//    System.out.println("After removing duplicates - \nnums = " + Arrays.toString(nums) + "\nK = " + k);

    int[] a = {1, 3, 6, 7, 8};
    System.out.println("a = " + Arrays.toString(a));
    int[] b = {5, 9};
    System.out.println("b = " + Arrays.toString(b));
    System.out.println("After Merging = " + Arrays.toString(TwoPointersPattern.mergeSorted(a, b)));

  }
}
