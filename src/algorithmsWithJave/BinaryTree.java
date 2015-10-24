package algorithmsWithJave;

import java.util.Stack;

public class BinaryTree {
	class node{
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
	public void print(){
		node e=new node();
		Stack<node> s=new Stack<BinaryTree.node>();
		while(true){
			System.out.println(e.key);
			if(e!=null){
				System.out.println(e.key);
				s.push(e);
				e=e.LeftChild;
			}
			if(!s.empty()){
				e=s.pop();
				e=e.RightChild;
			}
		}
	}

}
