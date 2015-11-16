package algorithmsWithJave;

import java.util.List;
import java.util.Stack;

public class BinaryTree {
	node root=null;
	static class node{
		node Parent;
		node LeftChild;
		node RightChild;
		public node getParent() {
			return Parent;
		}
		public void setParent(node parent) {
			Parent = parent;
		}
		public node getLeftChild() {
			return LeftChild;
		}
		public void setLeftChild(node leftChild) {
			LeftChild = leftChild;
		}
		public node getRightChild() {
			return RightChild;
		}
		public void setRightChild(node rightChild) {
			RightChild = rightChild;
		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		int key;
	}
	/**
	 * 非递归前序遍历打印二叉树
	 */
	public void print(){
		node e=root;
		Stack<node> s=new Stack<BinaryTree.node>();
		while(e!=null||!s.empty()){
			//System.out.println(e.key);
			while(e!=null){
			
				s.push(e);
				e=e.LeftChild;
			}
			if(!s.empty()){
				
				e=s.pop();
				System.out.println("e.key="+e.key);
				e=e.RightChild;
			}
		}
	}
	/**
	 * 递归法二叉树翻转
	 * @param e
	 */
	public static void reverse1(node e){
		if(e.LeftChild==null&&e.RightChild==null)return;
		node n=e.LeftChild;
		e.LeftChild=e.RightChild;
		e.RightChild=n;
		if(e.LeftChild!=null)reverse1(e.LeftChild);
		if(e.RightChild!=null)reverse1(e.RightChild);
	}
	/**
	 * 非递归法二叉树翻转
	 * @param e
	 */
	public static void reverse2(node e){
		Stack<node> s=new Stack<BinaryTree.node>();
		while(e!=null||!s.empty()){
			while(e!=null){
				s.push(e);
				e=e.LeftChild;
			}
			if(!s.empty()){
				e=s.pop();
				node n=e.LeftChild;
				e.LeftChild=e.RightChild;
				e.RightChild=n;
				e=e.LeftChild;//本来应该是右子节点，但是前面交换左右了
			}
		}
	}

}
