package leetcode;

import java.util.HashMap;
public class LeetCode01_TwoSum {
    //给目标数，在数组中查找两个数，返回数组的两个角标
    //这个方法时间复杂度太高
//    public int[] twoSum(int[] nums, int target) {
//        if (nums.length <= 0) {
//            return null;
//        }
//        int i=0;
//        int j=nums.length-1;
//        while (i <=(nums.length-1)/ 2) {
//            while (j >i) {
//                if ((nums[i]+nums[j]) == target) {
//                    return new int[]{i, j};
//                }else {
//                    j--;
//                }
//            }
//            j=nums.length-1;
//            i++;
//        }
//        return null;
//    }
// 这道题是看了答案才想到居然会有这么简单的方法！
// 此方法只有O（n）的复杂度，相对不足的是需要申请新的内存空间
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (map.containsKey(m)) {
                return new int[]{map.get(m), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
