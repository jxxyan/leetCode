package com.jxxyan.leetCode;

import java.util.Arrays;

/**
 * OK
 */
public class LeetCode0001 {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.stream(result).forEach(l -> System.out.println(l));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ( i == j){
                    continue;
                }
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
