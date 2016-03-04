package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */

public class SummaryRanges {
	/*
	 * 
	 *用begain和end做记录，遍历数组，如果为第一个元素则自动成为begain,如为末元素自动成为end,
	 *对nums[i]，如果)nums[i]！=nums[i-1]+1则nums[i-1]为end
	 *如出现end则输出string 加到list中
	 *如果)nums[i]！=nums[i-1]+1， begain=nums[i];
	 */
	public List<String> summaryRanges(int[] nums) {
	     List<String> out=new ArrayList<String>();
	     String s=null;
	     int begain = 0;
	     int end=0;
	     for(int i=0;i<nums.length;i++){
	         if(i==0){
	            begain=nums[0];
	         
	             
	         } else if((double)nums[i]-(double)nums[i-1]>1){
	        	
	             end=nums[i-1];
	             if(begain==end)s=Integer.toString(begain);
	             else s=begain+"->"+end;
	             out.add(s);
	             begain=nums[i];
	         }
	         if(i==nums.length-1){
	        	
	        	 end=nums[i];
	        	 if(begain==end)s=Integer.toString(begain);
	             else s=begain+"->"+end;
	             out.add(s);
	         }
	     }
	     return out;
	 }

}
