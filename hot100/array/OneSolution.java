package LeetCodeMy.hot100.array;
import java.util.*;
/*
 *  两数之和: 在整数数组中找到和为target的两个整数，并返回下标
 *
 *  tag: 数组、哈希表
 */

class OneSolution {

    /*
     * 1、简单的暴力枚举
     * 时间复杂度：O(n^2) 空间复杂度O(n^2)
     */
    public int[] twoSum1(int[] nums, int target){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++){
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /*
     * 2、哈希表
     * 时间复杂度O(n) 空间复杂度O(n)
     */
    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if (hashtable.containsKey(target - nums[i])){
                return new int[]{i, hashtable.get(target - nums[i])};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args){
        OneSolution solution = new OneSolution();
        int[] nums = new int[]{2, 7, 11,15};
        int target = 9;
        int[] result = solution.twoSum1(nums, target);
        System.out.println("result: "+ Arrays.toString(result));
    }

}


