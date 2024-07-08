package LeetCodeMy.hot100.dualIndicator;

import java.util.Arrays;

/**
* 移动零：给定数组，零移动到数组后面，且不改变原来顺序，不复制数组
* 
 */
public class OneSolution {
    
    /*
     * 时间复杂度：O(n)  空间复杂度: O(1)
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        while(fast < n) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while(slow < n) {
            nums[slow] = 0;
            slow++;
        }

    }

    public static void main(String[] args){
        int[] nums = new int[]{0,1,0,3,12};
        OneSolution oneSolution = new OneSolution();

        oneSolution.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
