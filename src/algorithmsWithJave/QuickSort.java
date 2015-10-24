package algorithmsWithJave;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
	public static<T extends Comparable<T>> int Partition(List<T> A,int l,int h){
		int m=(int) (Math.random()*(h-l+1)+l);//mΪh,l�����ֵ
		
		T c=A.get(m);
		List<T> SubA= A.subList(l, h+1);
//		System.out.println("���ֿ�ʼ A="+SubA.toString());
//		System.out.println("ѡ����"+c);
		Sort.swapInList(A, m, h);//�����ȡ�õ�ֵ���������һ��Ԫ��λ�ã���Ϊ��ͨ�滮�����
		/*��i��Ϊ���ޣ�������c������Ԫ�أ�С��c����iλ��Ԫ�ؽ�������i++���������ж������֤iǰԪ�ض�С��c��i�󣨰���i��
		 * Ԫ�ض�����c,�ٽ���iλ��Ԫ����c��
		 */
		
		int i=l;
		for(int j=l;j<h;j++){
//			System.out.println("�Ƚϵ�"+j);
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
