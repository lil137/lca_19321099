package main_pack;


import java.util.ArrayList;
import java.util.List;

/** The codes are adapted from:
*   1.https://blog.csdn.net/qq_38737992/article/details/90240422
*   2.https://blog.csdn.net/weixin_41933796/article/details/79826940
*   3.https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
*   4.https://www.breakyizhan.com/java/4052.html
*/
	class TreeNode {
		
		public int value; 
	    public TreeNode right; 
		public TreeNode left; 
	
 
		public TreeNode(int val) {
			this.value = val;
			this.left = null;
			this.right = null;
		}
		
		public boolean CheckExistence(int val, TreeNode BTree) {
			boolean leftResult = false;
			boolean rightResult = false;
			
			//if(BTree == null) {
			//	return false;
			//}
			
			if (BTree.value == val) {
				return true;
			}else {
				if (BTree.left != null) {
					leftResult = CheckExistence(val,BTree.left);
				}else {
					return false; 
				}
				
				if(BTree.right != null) {
					rightResult = CheckExistence(val,BTree.right);
				}else {
					return false;
				}
				return (leftResult || rightResult);
			}
			
		}
		
	}
	
	class findLca{
		
		
	    TreeNode root;
		
		
		public List<Integer> path1 = new ArrayList<>(); 
	    public List<Integer> path2 = new ArrayList<>(); 
	   
		
		public boolean findPath(TreeNode root, int n, List<Integer> path) 
	    { 
	        // base case 
	        if (root == null) { 
	            return false; 
	        } 
	          
	        // Store this node . The node will be removed if 
	        // not in path from root to n. 
	        path.add(root.value); 
	  
	        if (root.value == n) { 
	            return true; 
	        } 
	  
	        if (root.left != null && findPath(root.left, n, path)) { 
	            return true; 
	        } 
	  
	        if (root.right != null && findPath(root.right, n, path)) { 
	            return true; 
	        } 
	  
	        // If not present in subtree rooted with root, remove root from 
	        // path[] and return false 
	        path.remove(path.size()-1); 
	  
	        return false; 
	    }
		
		public int locate_lca(Integer[] arr1, Integer[] arr2) {
			int len_1 = arr1.length;
			int len_2 = arr2.length;
			int shorter_arr_length = Math.min(len_1,len_2);
			int lca_index = 0;
			
			for (int i = 0; i < shorter_arr_length; i++) {
				if(arr1[i] == arr2[i]) {
					lca_index = i;
				}else {
					break;
				}
				
			}
			return arr1[lca_index];		
			
		}
			
		
		
		public int Lca_solution(TreeNode Btree, int n1, int n2) {
			if (Btree.CheckExistence(n1,Btree) && Btree.CheckExistence(n2, Btree)) {
				findPath(Btree,n1,path1);
				findPath(Btree,n2,path2);
				
				Integer[] path1_arr = new Integer[path1.size()];
		        path1_arr = path1.toArray(path1_arr);
		        
		        Integer[] path2_arr = new Integer[path2.size()];
		        path2_arr = path2.toArray(path2_arr);
		        
		        int final_lca = locate_lca(path1_arr, path2_arr);
		        
		        path1.clear();
			    path2.clear();
			
		        return final_lca;
		        
				
			}else {
				System.out.println("Some or both two nodes are not on the tree");
				
				path1.clear();
			    path2.clear();
			
				return -1; /////
			}
		}
		
	
	}
	

public class Lca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findLca find = new findLca();
		find.root = new TreeNode(1);
		find.root.left = new TreeNode(2);
		find.root.right = new TreeNode(3);
		find.root.left.left = new TreeNode(4);
		find.root.left.right = new TreeNode(5);
		//int Searched_val = 5;
		
		int node1=  4;
		int node2 = 7;
		
		int lca_val = find.Lca_solution(find.root, node1, node2);
		
		if(lca_val != -1) {
			System.out.println("The LCA for the node "+ node1 + " and " + node2 + " is " + lca_val);
		}

		
		findLca find1 = new findLca();
		//find1.root = null;
		//int Searched_val3 = 6;
		//boolean EmptyResult = find1.root.CheckExistence(Searched_val3,find1.root);
		//System.out.println(EmptyResult);
		
		Integer[] test_arr1 = {1};
		Integer[] test_arr2 = {1,3};
		
		int test1 = find1.locate_lca(test_arr1,test_arr2);
		System.out.println(test1);
	}

}
