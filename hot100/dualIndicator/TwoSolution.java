package LeetCodeMy.hot100.dualIndicator;

/*
 * 盛最多水的容器：给定一个长度为n的整数数组height，有n条垂线，
 * 第i条线的两个端点是（i, 0） (i, height[i])
 * 找出两条线，是与x轴容纳最多的水
 * 返回：可以储存的最大水量
 */
public class TwoSolution {
    
    /**
     * 双指针：
     * 时间复杂度：O(n) 空间复杂度：O(1)
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int n = height.length;
        int l = 0, r = n-1;
        int result = 0;
        while(l < r) {
            result = Math.max(result, Math.min(height[r], height[l]) * (r - l));
            if(height[r] > height[l]){
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        TwoSolution twoSolution = new TwoSolution();
        int result = twoSolution.maxArea(height);
        System.out.println(result);
    }
}
