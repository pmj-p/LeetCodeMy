package LeetCodeMy.hot100.array;
import java.util.*;

/**
 * 最长连续序列：未排序数组nums，找出数字连续的最长序列的长度 设计时间复杂度为O(n)的算法
 * 
 * tag：数组、哈希表、并查集
 */
public class ThreeSolution {
    
    /**
     * 这个方法最朴素，排序后遍历
     * 时间复杂度：O(nlogn)  空间复杂度
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        int result = 0;
        int count = 1;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // 先排序
        Arrays.sort(nums);
        // 遍历数组中的每个元素，每次+1向后遍历
        for(int i = 1; i < n; i++) {
            // 如果当前元素与前一个元素相同，则跳过
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] == nums[i-1] + 1){
                count++;
                result = Math.max(count, result);
            } else {
                count = 1;
            }

        }
        return result;
    }

    /**
     * 哈希表：1、先去重；2、再判断set集合中是否有连续
     * 时间复杂度：O(n) 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        // 先去重--使用set集合
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }

        int result = 0; 

        for(int num : nums){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentIndex = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    currentIndex = currentIndex + 1;
                }
                result = Math.max(result, currentIndex);
            }
        }        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        ThreeSolution threeSolution = new ThreeSolution();
        int result = threeSolution.longestConsecutive1(nums);
        System.out.println(result);
    }
}
