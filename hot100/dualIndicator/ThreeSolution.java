package LeetCodeMy.hot100.dualIndicator;
import java.util.*;

/*
 * 三数之和：三元组[nums[i], nums[j], nums[k]] i!=j i!=k j!=k 
 * 满足nums[i] + nums[j] + nums[k] == 0
 * 返回所有不重复的三元组
 */
public class ThreeSolution {

    /**
     * 先排序，再利用指针
     * 时间复杂度O(n^2)  空间复杂度：O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n-2; i++){
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, m = n-1; 
            while(j < m){
                int sum = nums[i] + nums[j] + nums[m];
                if(sum < 0) {
                    while(j < m && nums[j] == nums[++j]);
                } else if (sum > 0) {
                    while(j <m && nums[m] == nums[--m]);
                } else{
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[m])));
                    while(j < m && nums[j] == nums[++j]);
                    while(j < m && nums[m] == nums[--m]);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        ThreeSolution threeSolution = new ThreeSolution();
        threeSolution.threeSum(nums);
    }
}
