package algorithmsWithJave;

import java.util.ArrayList;
import java.util.List;

public class DataStructure {
	/**
	 * 栈
	 * @author lee
	 *
	 */
	class Stack{
		private int capacity;
		private int stop;
		private int[] A;
		public Stack(int capacity){
			this.capacity=capacity;
			A=new int[capacity];
			stop=-1;
		}
		public boolean Empty(){
			if(stop==-1)return true;
			else return false;
		}
		public void Push(int element)throws IndexOutOfBoundsException{
			if(stop==capacity-1)throw new IndexOutOfBoundsException("栈已满");
			stop++;
			A[stop]=element;
			System.out.println("stop= "+stop+"  A=");
			for(int a:A)
			System.out.print(a);
			System.out.println();
		}
		public int Pop()throws IndexOutOfBoundsException{
			if(stop==-1)throw new IndexOutOfBoundsException("栈下溢");
			stop--;
			System.out.println("stop= "+stop+"  A=");
			for(int a:A)
				System.out.print(a);
			System.out.println();
			return A[stop+1];
			
		}
	}
	/**
	 * 队列
	 * @author lee
	 *
	 */
	class Queue{
		int capacity;
		int head;
		int tail;
		int[] A;
		public Queue(int capacity){
			this.capacity=capacity;
			A=new int[capacity];
			head=0;
			tail=0;
		}
		public void Enqueue(int element)throws IndexOutOfBoundsException{
			int t;
			if(tail==capacity-1)t=0;
			else t=tail+1;
			if(t==head)throw new IndexOutOfBoundsException("队列上溢");
			A[tail]=element;
			tail=t;
			
		}
		public int Dequeue(){
			if(head==capacity-1)head=0;
			else head++;
			if(head==tail)throw new IndexOutOfBoundsException("队列下溢");
			return A[head-1];
		}
	}
	class LinkedList<T>{
		class node{
			public int key;
			public node previous;
			public node next;
			public T value;
			
		}
		node head;
		public LinkedList(){
			head=null;

		}
		public node find(int key){
			node n=head;
			while(n.key!=key){
				if(n.next==null)return null;
				else n=n.next;
			}
			return n;
		}
		public void Insert(T v,int key){
			node n=new node();
			n.key=key;
			n.value=v;
			if(head==null){
				n.previous=null;
				n.next=null;
				head=n;
				
			}
			else{
				n.previous=null;
				head.previous=n;
				n.next=head;
				head=n;
			}
		}
		public void delete(int key){
			node n=find(key);
			if(n.previous!=null){
				n.previous.next=n.next;
			}
			else {
				head=n.next;
			}
			if(n.next!=null){
				n.next.previous=n.previous;
			}
			
		}
		public void showList(){
			if(head==null)return;
			node now=head;
			while(now!=null){
				System.out.println(now.key);
				now=now.next;
			}
		}
	}

}
