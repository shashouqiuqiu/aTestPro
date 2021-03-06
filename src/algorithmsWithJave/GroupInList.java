package algorithmsWithJave;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GroupInList {
	 static ArrayList<Integer> result=new ArrayList<Integer>();
/**
 * 对在数组A中寻找长为size的组合，对A[i]，考虑是否加入组合
 * @param A  
 * @param i  
 * @param size
 * @return
 */
 
  private static ArrayList<Integer> putTest(ArrayList<Integer> A,int i,int size){

		if (size == 0)
			System.out.println("result="+result.toString());
		else {
			if (i < A.size()) {
				result.add(A.get(i));
				putTest(A, i + 1, size - 1);
				result.remove(A.get(i));                                                                                    
				putTest(A, i + 1, size);
				
			}
		}

		return result;

  }
  public static void FindGroup(ArrayList<Integer> A){
	  
	  for(int i=1;i<=A.size();i++){
//		  for(int j=0;j<A.size();j++)
		  putTest(A, 0,i );
	  }
  }
  /**
   * 寻找全排列递归版本
   * @param A
   * @param begain
   */
  public static void per(ArrayList<Integer>A,int begain){
	  
	  if(begain==A.size()-1)System.out.println(A.toString());
	  else{
		  for(int i=0;i<A.size();i++){
			  System.out.println("begain="+begain+"i="+i);
			  Sort.swapInList(A, i, begain);
			  per(A,begain+1);
			  Sort.swapInList(A, i, begain);//恢复数据，以保障每次都是从原数据取A[i]交换A[begain].
		  }
		 
	  }
	  
  }
  /**
   * 寻找全排列非递归版
   * 
   * @param A
   */
  public static void per2(ArrayList<Integer>A){
	  QuickSort.Sort(A, 0, A.size()-1);//先将A元素排序，得到最小的排列数
	  //然后思路是不断寻找下一个最小的排列
//	  System.out.println(A.toString());
	 
	  for( int i=A.size()-1;i>0;i--){//从后向前遍历
		  System.out.println(i);
		  if(A.get(i-1)<A.get(i)){  //如果遇到前一个数小于后一个数
			  int min=FindMin(A,A.get(i-1),i, A.size()-1);//则交换前一个数与后面序列中的最小数，注意这整个操作保持着遍历过得数逆序排列
			  Sort.swapInList(A, i-1, min);
			  reverse(A.subList(i, A.size()));//翻转后面的数
			  
			  i=A.size();                     //重设i以重新从底部开始遍历
			  System.out.println(A);
			  
			 
		  }
		  }
		  
	  
	  
	  
  }
  private static int FindMin(ArrayList<Integer> A,int f,int l ,int h){
	  int min=Integer.MAX_VALUE;
	  List<Integer> L=A.subList(l, h+1);
	  Iterator<Integer> it=L.iterator();
	  while (it.hasNext()) {
	  int i=it.next();
	  if(i<min&&i>=f)min=i;
	
		
	}
	  return A.indexOf(min);
	 
  }
  private static void reverse(List<Integer> A){
	  Collections.reverse(A);
  }
  public static void main(String[] args) {
	List<Integer> a=new ArrayList<>();
	for(int i=0;i<4;i++)a.add(i+1);
	per2((ArrayList<Integer>) a);
}
}
