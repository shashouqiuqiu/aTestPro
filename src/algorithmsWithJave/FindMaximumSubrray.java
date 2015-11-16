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
	 * ����һ�������У��ҳ����Ԫ��Middle���������������У�����¼���ұ߽������
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
		  
		 double leftSum=Double.NEGATIVE_INFINITY;//�������
		 double rightSum=Double.NEGATIVE_INFINITY;//�ұ�����
		 double sum=0;//��¼Ԫ�غ����ڱȽ�
		 int maxLeft=0;//��߽�
		 int maxRight=0;//�ұ߽�
		 //��¼���
		 for(int i=m;i>=l;i--){
			 sum+=A[i];
			 if(sum>leftSum){
				 leftSum=sum;
				 maxLeft=i;
			 }
		 }
		 //��¼�ұ�
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
	  * �ݹ鷨Ѱ����������������
	  * @param A
	  * @param l
	  * @param h
	  * @return
	  */
    public static returnValue FindMS(double[] A,int l,int h){
    	//���������Ϊһ��Ԫ��
    	if(l==h){
    		returnValue r=new returnValue();
    		r.setMaxLeft(l);
    		r.setMaxRight(h);
    		r.setSum(A[l]);
    		return r;
    	}
    	else{
    		//���������ٷ�Ϊ���������֣��ֱ��������������ֵ��������������У������Middle���������бȽϣ��ĸ���ͷ����ĸ�
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
     * ����ʱ�����ҳ���������������
     * @param A
     * @return
     */
    public static returnValue FindMSInlinearTime(double[] A){
    	double sum=0;//��¼һ����Ԫ�صĺ�
    	double max=Double.NEGATIVE_INFINITY;//��¼����
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

