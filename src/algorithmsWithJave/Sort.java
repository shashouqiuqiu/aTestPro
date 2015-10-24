package algorithmsWithJave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Sort {
	/**sorting a list with insertion sort,
	 * T extends Comparable
	 * @param  List<T extends Comparable> input a unsorted List  
	 * @return sorted list  
	 */
	public static <T extends Comparable<T>>List<T> InsertionSort( List<T> input ){
		int size=input.size();
		if(size<2)return input;
		
		for(int i=1;i<size;i++){
			
			ListIterator<T> it= input.listIterator(i);
			T key=it.next();
			it.remove();
			T element=it.previous();
			it.next();
			while(it.hasPrevious()){
				if(element.compareTo(key)>0){
					it.previous();
					if(it.hasPrevious()){
						element=it.previous();
						it.next();
					}
					
				}else break;
		    }
			it.add(key);
		}
		return input;
	}
	/**
	 * swap list.get(i) with list.get(j)
	 * @param list
	 * @param i
	 * @param j
	 */
	public static <T extends Comparable<T>> void swapInList(List<T> list, int i ,int j){
		if(i==j)return;
		
		T temp=list.get(i);
		list.set(i, list.get(j));
	    list.set(j, temp);
//	    System.out.println("交换了："+list.get(i)+"与"+list.get(j));
//	    System.out.println(list.toString());
		
	}
	/**merge used in merge_sort
	 * 
	 * @param A
	 * @param p
	 * @param q
	 * @param r
	 * @return
	 */
	private static  <T extends Comparable<T>> List<T> merge(List<T> A,int p, int q,int r){
		int n1=q-p+1;
		int n2=r-q;
		ArrayList<T> L= new ArrayList<T>();
		ArrayList<T> R= new ArrayList<T>();
		for(int i=0;i<n1;i++){
			L.add(A.get(p+i));
		}
		for(int i=0;i<n2;i++){
			R.add(A.get(i+q+1));
		}
		ListIterator<T> it=A.listIterator(p);
		ListIterator<T> itl=L.listIterator();
		ListIterator<T> itr=R.listIterator();
		while(itl.hasNext()&&itr.hasNext()){
			T lElement=itl.next();
			T rElement=itr.next();
			if(lElement.compareTo(rElement)>0){
				it.next();
				it.set(rElement);
				itl.previous();
			}else{
				it.next();
				it.set(lElement);
				itr.previous();
			}
		}
		while (itl.hasNext()) {
			T e=itl.next();
			it.next();
			it.set(e);
		}
		while(itr.hasNext()){
			T e=itr.next();
			it.next();
			it.set(e);
		}
		return A;
		
	}
	/**分治法排序
	 * 
	 * @param A
	 * @param p
	 * @param r
	 * @return
	 */
	public static  <T extends Comparable<T>> List<T> mergeSort(List<T> A,int p, int r){
		if(p<r){
		int q=(p+r)/2;
		mergeSort(A,p,q);
		mergeSort(A,q+1,r);
		merge(A,p,q,r);
		}
		return A;
	}
	/**
	 * 
	 * @param A
	 * @return
	 */
	public static <T extends Comparable<T>> List<T> bubbleSort(List<T> A ){
		for(int i=0;i<A.size();i++){
			for(int j=0;j<A.size()-i-1;j++){
				if(A.get(j).compareTo(A.get(j+1))>0){
					swapInList( (ArrayList<T>) A, j, j+1);
					
				}
			}
		}
		
		return A;
	}
	public static void main(String[] args) {
		int []a={5,2,4,7,1,3,2,6};
		
		List<Integer> l=new ArrayList<>();
		for(int i:a){
			l.add(i);
		}
//		ArrayList<String>l2=(ArrayList<String>) InsertionSort(l);
//		swapInList(l2, 0, 6);
		 bubbleSort(l);
		 Iterator<Integer> it=l.iterator();
		 while (it.hasNext())
		 System.out.println(it.next());

//		while(it2.hasNext())
//		System.out.println(it2.next());
	}

}
