package algorithmsWithJave;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {
			
		public static int parent(int number ){
			return number/2;
			
		}
		public static int left(int number){
			return 2*number;
		}
		public static int right(int number){
			return 2*number+1;
		}
		
	
	private static  <T extends Comparable<T>> void MaxHeapify(ArrayList<T> A,int i){
		int l=left(i);
		int r=right(i);
		int largest;
		if(l<=A.size()&&A.get(l-1).compareTo(A.get(i-1))>0)largest=l;
		else largest=i;
		if(r<=A.size()&&A.get(r-1).compareTo(A.get(largest-1))>0)largest=r;
		if(largest!=i){
			T temp=A.get(i-1);
			A.set(i-1, A.get(largest-1));
			A.set(largest-1, temp);
			MaxHeapify(A,largest);
		}
	}
	private static  <T extends Comparable<T>> void BuildMaxHeap(ArrayList<T> A){
		for(int i=A.size()/2;i>=1;i--){
			MaxHeapify(A, i);
		}
	}
	public static<T extends Comparable<T>> void HeapSort(ArrayList<T> A){
		BuildMaxHeap(A);
		List<T> result=new ArrayList<>();
		
		while(A.size()>0){
			int i=A.size()-1;
		    T temp=A.get(i);
		    A.set(i,A.get(0));
		    A.set(0,temp);
		    result.add(A.get(i));
		    A.remove(i);
		    MaxHeapify(A, 1);
		}
		
	}
	public static <T extends Comparable<T>> void HeapIncreaseKey(ArrayList<T> A,int i,T key){
		if(A.get(i-1).compareTo(key)>0)return;
		A.set(i-1, key);
		while(i>1&&A.get(parent(i)-1).compareTo(A.get(i-1))<0){
			T temp=A.get(parent(i)-1);
			A.set(parent(i)-1, A.get(i-1));
			A.set(i-1, temp);
			i=parent(i);
		}
	}
	public static void main(String[] args) {
		int [] a={4,1,3,2,16,9,20,14,8,7};
        ArrayList<Integer> l=new ArrayList<>();
		for(int i:a){
			l.add(i);
		}
		BuildMaxHeap(l);
		System.out.println(l);
		HeapIncreaseKey(l, 2, 20);
		
		System.out.println(l.toString());
		HeapSort(l);
	}
 
}
