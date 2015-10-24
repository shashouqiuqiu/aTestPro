package algorithmsWithJave;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
	public static<T extends Comparable<T>> int Partition(List<T> A,int l,int h){
		int m=(int) (Math.random()*(h-l+1)+l);//m为h,l间随机值
		
		T c=A.get(m);
		List<T> SubA= A.subList(l, h+1);
//		System.out.println("本轮开始 A="+SubA.toString());
//		System.out.println("选择了"+c);
		Sort.swapInList(A, m, h);//将随机取得的值交换到最后一个元素位置，成为普通版划分情况
		/*以i作为界限，遍历除c外所有元素，小于c的与i位置元素交换，并i++。否则无行动，最后保证i前元素都小于c而i后（包括i）
		 * 元素都大于c,再交换i位置元素与c。
		 */
		
		int i=l;
		for(int j=l;j<h;j++){
//			System.out.println("比较到"+j);
			if(A.get(j).compareTo(c)<0){
				Sort.swapInList(A, j, i);
				i++;
			}
			
		}
		Sort.swapInList(A, h, i);
		return i;
		
	}
	public static <T extends Comparable<T>> void Sort(ArrayList<T> A, int l ,int h){
		if(l<h){
		int p=Partition(A, l, h);
		Sort(A,p+1,h);
		Sort(A,l,p-1);
		}
		
	}
   public static void main(String[] args) {
//	   int [] a={4,1,3,2,16,9,20,14,8,7};
	   int [] a={4,1,3};
       ArrayList<Integer> l=new ArrayList<>();
		for(int i:a){
			l.add(i);
		}
//	  Partition(l, 0, l.size()-1);
//		Sort(l,0,l.size()-1);
//		GroupInList.FindGroup(l);
//		GroupInList.per(l, 0);
		GroupInList.per2(l);
//	  System.out.println(l.toString());
}
}
