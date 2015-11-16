package algorithmsWithJave;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

class returnValue{
	private double sum;
	private int maxLeft;
	private int maxRight;
	public  double getSum() {
		return sum;
	}
	public  void setSum(Double sum) {
		this.sum = sum;
	}
	public  int getMaxLeft() {
		return maxLeft;
	}
	public  void setMaxLeft(int maxLeft) {
		this.maxLeft = maxLeft;
	}
	public  int getMaxRight() {
		return maxRight;
	}
	public  void setMaxRight(int maxRight) {
		this.maxRight = maxRight;
	}
	
}

public class FindMaximumSubrray {
	/**
	 * 对于一个子序列，找出其跨元素Middle的最大和连续子序列，并记录左右边界和最大和
	 * @param A
	 * @param l
	 * @param m
	 * @param h
	 * @return
	 * @throws NoSuchElementException
	 * @throws InputMismatchException
	 * @throws IndexOutOfBoundsException
	 */
	private static returnValue FindMaxCrossingSubarray(double[] A,int l,int m,int h)throws NoSuchElementException,InputMismatchException,IndexOutOfBoundsException{
		  if(l<0||m<0||h<0)throw new NoSuchElementException();
		  if(m>h||l>m)throw new InputMismatchException("request: l<=m<=h");
		  if(h>A.length)throw new IndexOutOfBoundsException();
		  
		 double leftSum=Double.NEGATIVE_INFINITY;//左边最大和
		 double rightSum=Double.NEGATIVE_INFINITY;//右边最大和
		 double sum=0;//记录元素和用于比较
		 int maxLeft=0;//左边界
		 int maxRight=0;//右边界
		 //记录左边
		 for(int i=m;i>=l;i--){
			 sum+=A[i];
			 if(sum>leftSum){
				 leftSum=sum;
				 maxLeft=i;
			 }
		 }
		 //记录右边
		 sum=0;
		 for(int i=m+1;i<=h;i++){
			 sum+=A[i];
			 if(sum>rightSum){
				 rightSum=sum;
				 maxRight=i;
			 }
		 }
		  returnValue r=new returnValue();
		  r.setMaxRight(maxRight);
		  r.setMaxLeft(maxLeft);
		  r.setSum(leftSum+rightSum);  
		  return r;
	  }
	 /**
	  * 递归法寻找最大和连续子序列
	  * @param A
	  * @param l
	  * @param h
	  * @return
	  */
    public static returnValue FindMS(double[] A,int l,int h){
    	//如果子序列为一个元素
    	if(l==h){
    		returnValue r=new returnValue();
    		r.setMaxLeft(l);
    		r.setMaxRight(h);
    		r.setSum(A[l]);
    		return r;
    	}
    	else{
    		//将子序列再分为左右两部分，分别求其左右两部分的最大和连续子序列，并与跨Middle最大和子序列比较，哪个大就返回哪个
    		int m=(l+h)/2;
    		returnValue left=FindMS(A, l, m);
    		returnValue right=FindMS(A,m+1,h);
    		returnValue cross=FindMaxCrossingSubarray(A, l, m, h);
    		if(left.getSum()>right.getSum()&&left.getSum()>cross.getSum())return left;
    		else if(right.getSum()>left.getSum()&&right.getSum()>cross.getSum())return right;
    		else return cross;
    		
    	}
		
    }
    /**
     * 线性时间内找出最大和连续子序列
     * @param A
     * @return
     */
    public static returnValue FindMSInlinearTime(double[] A){
    	double sum=0;//记录一段中元素的和
    	double max=Double.NEGATIVE_INFINITY;//记录最大和
    	int l=0;
    	int h=0;
    	int pointer=0;
    	for(int i=0;i<A.length;i++){
    		if(sum<0){
    			sum=A[i];
    			pointer=i;
    		}
    		else sum+=A[i];
    		if(sum>max){
    			max=sum;
    			h=i;
    			l=pointer;
    		}
    	}
    	returnValue r=new returnValue();
    	r.setMaxLeft(l);
    	r.setMaxRight(h);
    	r.setSum(max);
    	
		return r;
    }
    public static void main(String[] args) {
		double a[]={13,-3,-25,20,9,8,-3,-16,3,-23,18};
		returnValue r=FindMSInlinearTime(a);
		for(int i=r.getMaxLeft();i<=r.getMaxRight();i++)
		System.out.print(a[i]+"  ");
		System.out.println();
		System.out.println(r.getSum());
	}
}

