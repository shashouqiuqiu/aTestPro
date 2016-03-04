package leetcode;
/*
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint
 *  stopping you from robbing each of them is that adjacent houses have 
 *  security system connected and it will automatically contact the police 
 *  if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of
 each house, determine the maximum amount of money you can rob tonight 
 without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test
 cases. Also thanks to @ts for adding additional test cases.
 */
public class HouseRobber {//动态规划，则对编号i，则最大收益m[i]为max(抢i:i的钱加上m[i-2],不抢i:m[i-1])
	public int rob(int[] nums) {
        if(nums.length==0)return 0;
        else if(nums.length==1)return nums[0];
        int[] m=new int[nums.length];
        m[0]=nums[0];
        m[1]=Integer.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            m[i]=Integer.max(m[i-2]+nums[i],m[i-1]);
        }
        return m[nums.length-1];
    }

}
