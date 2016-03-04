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
	 *��begain��end����¼���������飬���Ϊ��һ��Ԫ�����Զ���Ϊbegain,��ΪĩԪ���Զ���Ϊend,
	 *��nums[i]�����)nums[i]��=nums[i-1]+1��nums[i-1]Ϊend
	 *�����end�����string �ӵ�list��
	 *���)nums[i]��=nums[i-1]+1�� begain=nums[i];
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
