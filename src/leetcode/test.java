package leetcode;

import java.util.HashMap;

public class test {
	

	  public class TreeNode {
	      int val;
	      TreeNode left;
	     TreeNode right;
	    TreeNode(int x) { val = x; }
	  }
	 
	static  public class Solution {
		    public boolean isValidSudoku(char[][] board) {
		        int m[][]=new int[board[0].length][board[0].length];
		        HashMap<Character,Integer> record=new HashMap();  
		        for(int i=0;i<board[0].length;i++){
		        	record.clear();
		            for(int j=0;j<board[0].length;j++ ){
		                if(board[i][j]!='.'){
		           
		                    if(record.get(board[i][j])!=null)return false;
		                    else {
		                    	System.out.println("board="+board[i][j]+" i="+i);
		                    	record.put(board[i][j],i);
		                    	
		                    }
		                 
		              }    
		                  
		            }
		        }
		      
		        record.clear();
		       
		        for(int j=0;j<board[0].length;j++){
		        	record.clear();
		            for(int i=0;i<board[0].length;i++ ){
		                if(board[i][j]!='.'){
		              
		                    if(record.get(board[i][j])!=null){
		                    	return false;
		                    }
		                     else {
		                    	 record.put(board[i][j],j); 
		                    	 System.out.println("record put key="+board[i][j]+" value="+j);
		                    	
		                     }
		                	
		              }     
		                  
		            }
		        }
		      
		       
		         for(int i=0;i<board[0].length;i++){
		
		            for(int j=0;j<board[0].length;j++ ){
		                record.put(board[i][j],-1);
		                if(board[i][j]!='.'){
		                    if(record.get(board[i][j])==i/3*3+j/3)return false;
		                    else {
		                    	record.put(board[i][j],i/3*3+j/3);
		                        System.out.println("record put key="+board[i][j]+" value="+i/3*3+j/3);
		                    }
		              }     
		                  
		            }
		          
		           
		        }
		        return true;
		    }
		}
	public static void main(String[] args) {
		int height=2;
//		System.out.println(1+2<<(height-1));
//		int [][]m=new int[3][4];
//		System.out.println(m[0].length);
		HashMap<Integer, Character> a =new HashMap();
		a.put(1, 'c');
		a.put(1, 'd');
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				a.put(j, 'a');
			}
		}
	 char[][]board ={"..4...63.".toCharArray(),".........".toCharArray(),"5......9.".toCharArray(),"...56....".toCharArray(),
			 "4.3.....1".toCharArray(),"...7.....".toCharArray(),"...5.....".toCharArray(),
			 ".........".toCharArray(),".........".toCharArray()};
	 Solution s=new Solution();
	 s.isValidSudoku(board);
	 
	 
	 
	 }
	}

