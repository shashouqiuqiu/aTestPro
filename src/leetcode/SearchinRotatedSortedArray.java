package leetcode;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Subscribe to see which companies asked this question
 */

public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
	     return rangeSearch(nums, 0, nums.length-1, target);
	 }
	 private int getmiddle(int start,int end){
	     return (start+end)/2;
	 }
	 private int rangeSearch(int[] nums,int start,int end, int target){//递归进行变形的二分查找
	     int middle=getmiddle(start,end);
	     if(nums[middle]==target)return middle; 
	     else if(start==end)return -1;
	     else if(nums[middle]<nums[start]){//情况1.middle 到 end 为已排序
	    	 if(target==nums[end])return end;
	         if(target<nums[end]&&target>nums[middle]) //如target在[m+1,e]间则执行正常二分查找，否则在[s,m-1]间继续递归
	         return commonSearch( nums, middle+1,end,target);
	         else return rangeSearch(nums,start,middle-1,target);
	         
	     }else if(nums[middle]>nums[start]){//情况2.start 到 middle 为 已排序
	    	 if(target==nums[start])return start;
	         if(target>nums[start]&&target<nums[middle])//如target在已排序区间则执行正常二分查找，否则在[m+1,e]继续递归
	         return commonSearch(nums,start,middle-1,target);
	         else  return rangeSearch(nums,middle+1,end,target);
	     
	     }else return (target==nums[end])?end:-1;//情况3.nums[middle]==nums[start] 即区间长度为2，则看end是否是要找的    
		
	 }
	   private int commonSearch(int[] nums,int start,int end,int target){
	     int middle=getmiddle(start,end);
	     if(nums[middle]==target)return middle; 
	     else if(start>=end)return -1;
	     if(target>nums[middle])return commonSearch(nums,middle+1,end,target);
	     else return commonSearch(nums,start,middle-1,target);
		
	 }

}
