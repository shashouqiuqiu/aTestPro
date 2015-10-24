package algorithmsWithJave;
/**
 * ��������
 * @author lee
 *
 */
public class CountingSort {
     /**
      * 
      * @param A 
      * ��������
      * @param k
      * �����������ֵ
      */
	public static void sort(int[] A,int k){
		int s=A.length;
		int[] B=new int[s];
		int[] C=new int[k]; 
		for(int a:A){
			C[a]++;       
		}
		for(int i=1;i<k;i++)C[i]+=C[i-1];//����C��iλ�õ�ֵ��ΪA��i��СԪ���������������ж���С����ģ��������˴�����
		for(int i=0;i<k;i++)System.out.printf("%3s",C[i]);
		System.out.println();
		for(int i=s-1;i>=0;i--){  //B�����ŵ�A,���ű�����Ϊ�˱�֤�ȶ��ԣ������Ԫ���ź�˳�������ǰ˳��
			int a=A[i];
			B[C[a]-1]=a;
			C[a]--; //���--����ʵ����������ظ�Ԫ�صģ���֤��һ���ظ�Ԫ��������һ����֮ǰһλ
		}
		for(int i=0;i<s;i++)
		System.out.printf("%3s",B[i]);
		
		
	}
	public static void main(String[] args) {
		int[] A={4,7,6,1,2,4,0,3};
		sort(A,10);
	}
}