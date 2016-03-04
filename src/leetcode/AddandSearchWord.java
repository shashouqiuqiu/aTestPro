package leetcode;

import java.util.HashMap;
/*
 * 
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 */

public class AddandSearchWord {
	/**
	 * 回溯法求解
	 * 
	 * @author lee
	 *
	 */
	 class node{
	        char value;
	        boolean end=false;
	        HashMap<Character, node> children=new HashMap<Character, node>();
	        public node(char v){
	            value=v;
	            
	        }
	        public node(){
	            
	        }
	    }
	    node root=new node();

	    // Adds a word into the data structure.
	    public void addWord(String word) {
	       
	            
	        
	        node n=root;
	       for(int i=0;i<word.length();i++){
	          node child=n.children.get(word.charAt(i));
	          if(child==null){
	              node newNode=new node(word.charAt(i));
	              if(i==word.length()-1)newNode.end=true;
	              n.children.put(word.charAt(i),newNode);
	              child=newNode;
	          }
	           n=child;
	          
	       }
	       
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        node n=root;
	    
	        return search1(word,root);
	    }
	    private boolean search1(String words,node n){//递归查找
	    	
	    if (n.children.isEmpty())return words.isEmpty();
		if (words.length() == 0)return n.end;
	   	char c = words.charAt(0);
		if (c == '.') {
			for (node child : n.children.values())
				if (search1(words.substring(1), child))
					return true;
			return false;
		} else if (n.children.get(c) == null)
			return false;
		else
			return search1(words.substring(1), n.children.get(c));
	       
	        
	    }
}
