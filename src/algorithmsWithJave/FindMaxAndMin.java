package algorithmsWithJave;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithmsWithJave.DataStructure.LinkedList;
import algorithmsWithJave.DataStructure.Queue;
import algorithmsWithJave.DataStructure.Stack;

public class FindMaxAndMin {
 static	class Pair{
		 int max;
		 int min;
	}
	
	public static Pair Find(int [] A){
		
		Pair p=new Pair();
		p.max=Integer.MIN_VALUE;
		p.min=Integer.MIN_VALUE;
		for(int i=0;i<A.length-2;i++){
			if(A[i]>A[i+1]){
				if(p.max<A[i])p.max=A[i];
				if(p.min>A[i+i])p.min=A[i+1];
			}
			else{
				if(p.max<A[i+1])p.max=A[i+1];
				if(p.min>A[i])p.min=A[i];
			}
			
		
		}
		return p;
	}
	/**
	 * 找到最i小元素
	 * @param A
	 * @param l
	 * @param h
	 * @param i
	 * @return
	 */
   public static int  RandomizedSelection(List<Integer> A,int l,int h,int i){
	   if(l==h){
		   
		   System.out.println("l== "+l+" h=="+h+" A=="+A.toString());
		   return A.get(l);
	   }
	   int q=QuickSort.Partition(A, l, h);
	   System.out.println("q=="+q+" A=="+A.toString());
	   int k=q-l+1;
	   if(k==i){
		   System.out.println("k=="+k+" q=="+q+" l=="+l+" A=="+A.toString());
		   return A.get(q);
	   }
		else if (q+1 > i)
			return RandomizedSelection(A, l, q - 1, i);
		else
			return RandomizedSelection(A, q + 1, h, i - q-1);
   }
   public static void FindKPartition(List<Integer> A,int l,int h,int k){
	   if(k<=1)return;
	   
	   int ik=k/2;
	  int i= RandomizedSelection(A, l, h, ik);
	   System.out.println("找出"+A.get(i));
	   FindKPartition(A, l, ik-2, ik);
	   FindKPartition(A, ik, h, k-ik);
	   
	   
   }
   public static void main(String[] args) {
	int[] a={1,5,4,2,6,6,8,9,6,4,7,34,12,9};
	List<Integer> A=new ArrayList<>();
	for(int e:a)A.add(e);
//	FindKPartition(A, 0, A.size()-1, 4);
//	System.out.println(RandomizedSelection(A, 0, A.size()-1, 1));
	DataStructure d=new DataStructure();
	Stack s=d.new Stack(5);
	Queue q=d.new Queue(6);
    LinkedList<Integer> l=d.new LinkedList<Integer>();
	try {
		
		for(int element:A){
			s.Push(element);
			l.Insert(element, element);
		}
		
		
	} catch (IndexOutOfBoundsException e) {
		// TODO: handle exception
		for(int i=0;i<5;i++)s.Pop();
	
	}
	
	
	}
}

