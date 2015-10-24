package algorithmsWithJave;
/**
 * 计数排序
 * @author lee
 *
 */
public class CountingSort {
     /**
      * 
      * @param A 
      * 待排数组
      * @param k
      * 待排数组最大值
      */
	public static void sort(int[] A,int k){
		int s=A.length;
		int[] B=new int[s];
		int[] C=new int[k]; 
		for(int a:A){
			C[a]++;       
		}
		for(int i=1;i<k;i++)C[i]+=C[i-1];//现在C中i位置的值即为A中i大小元素在整个数组中有多少小于其的，即保存了次序性
		for(int i=0;i<k;i++)System.out.printf("%3s",C[i]);
		System.out.println();
		for(int i=s-1;i>=0;i--){  //B即重排的A,倒着遍历是为了保证稳定性，即相等元素排后顺序等于排前顺序
			int a=A[i];
			B[C[a]-1]=a;
			C[a]--; //这个--操作实际上是针对重复元素的，保证下一个重复元素排在上一个的之前一位
		}
		for(int i=0;i<s;i++)
		System.out.printf("%3s",B[i]);
		
		
	}
	public static void main(String[] args) {
		int[] A={4,7,6,1,2,4,0,3};
		sort(A,10);
	}
}