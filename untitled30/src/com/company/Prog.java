package com.company;

import java.util.Arrays;

public class Prog {
    //[3,15,2,6,7] -> 10
    public int[] twoSum(int[] nums, int targetSum){
        int[] res = new int[2];
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == targetSum){
                res = new int[1];
                res[0] = nums[i];
                return res;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == targetSum){
                    res[0] = nums[i];
                    res[1] = nums[j];
                }
            }
        }
        return res;
    }
}
