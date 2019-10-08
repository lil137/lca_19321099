package main_pack;

import java.util.*;

/*Codes and ideas are adapted from:
	1.https://stackoverflow.com/questions/15460661/different-ways-to-implement-dags-in-java
	2.https://www.jianshu.com/p/d4b54510c8ec
	3.http://www.runoob.com/java/java-collections.html
*/


class Node{
	List<Node> successors;
	boolean isMarked;
	int value; 

	public Node() {
	}

	
	public Node(int val) {
		value = val;
		isMarked = false;
		successors = new ArrayList<Node>();
	}

	public Node(int val,List<Node> succ) {
		value = val;
		isMarked = false;
		successors = succ;
	}
	
	public void MarkNode (int val,Node root) {
        if(root == null) {
        	return;
        }
        
        
		if (root.value == val) {
	    	root.isMarked = true;
	    }else {
	    	for (Node ns : root.successors) {
	    		root.MarkNode(val,ns);
	    	}
	    	
	    }		
	}
	
	public void ClearMark(Node root) {
		if(root == null) {
        	return;
        }
          
		if (root.isMarked == true) {
	    	root.isMarked = false;
	    }else {
	    	if(root.successors != null) {
	    		for (Node ns : root.successors) {
	    			root.ClearMark(ns);
	    		}
	    	}
	    }
	}
}

public class Lca_DAG{
		
		Node root;// = new Node(); // assuming only one root exists	
		
		public Lca_DAG() {
		}
		
		public Lca_DAG(int val) {
			root.value = val;
			root.isMarked = false;
			root.successors = new ArrayList<Node>();
		}

		
		public Lca_DAG(int val,List<Node> succ) {
			root.value = val;
			root.isMarked = false;
			root.successors = succ;
		}
	
		public boolean isEmptyDAG(Lca_DAG DAG) {
			if (DAG.root == null){
				System.out.println("The DAG is empty");
				return true;
			}else {
				return false;
			}
		}
				
		
		public boolean CheckExistenceInDAG(Node n, int val) {
		    if (n.value == val) {
		    	return true;
		    }else if(n.successors == null){
		    	return false;
		    }else {
		    	boolean result = false;
		    	for (Node ns : n.successors) {
		    		result = result || CheckExistenceInDAG(ns,val);
		    		if(result == true) {
		    			break;
		    		}
		    	}
		    	return result;
		    }			
		
		}
		
		
		public List<ArrayList<Integer>> Paths_Node1 = new ArrayList<ArrayList<Integer>>(); // = { new ArrayList<Integer>()};
		public List<ArrayList<Integer>> Paths_Node2 = new ArrayList<ArrayList<Integer>>();; // = { new ArrayList<Integer>()};
		ArrayList<Integer> Path = new ArrayList<Integer>();
		
		// check the existence first then use the below method to find the path
		// so we don't have to check the existence in this function
		public boolean findPathInDAG(Node node, int val) {
			if (node == null) {
				return false;
			}else if(node.isMarked != true){
				Path.add(node.value);
				
				if (node.value == val) {
					return true;
				}
				for (int i = 0; i < node.successors.size(); i++) {
					if(node.successors.size() != 0 &&
			           findPathInDAG(node.successors.get(i),val)) {
						return true;
					}
				}			
				Path.remove(Path.size()-1);
				return false;
			}else {
				return false;
			}
		}
		
		public boolean AddPathForEachNode(int val1, int val2){
			if (CheckExistenceInDAG(root, val1) && CheckExistenceInDAG(root, val2)) {
				boolean val1_find = findPathInDAG(root, val1);
				while(val1_find) {
						
					Paths_Node1.add(Path);
					if(Path.size() == 1) {
						 root.isMarked = true;
						 Path = new ArrayList<Integer>();
					 }else {
						 int MarkNodeVal = Path.get(Path.size()-2);
					     root.MarkNode(MarkNodeVal, root);
					     Path = new ArrayList<Integer>();
					}
					val1_find = findPathInDAG(root, val1);
				}
				
				root.ClearMark(root);
				
				boolean val2_find = findPathInDAG(root, val2);
				while(val2_find) {
					Paths_Node2.add(Path);
					 
					if(Path.size() == 1) {
						 root.isMarked = true;
						 Path = new ArrayList<Integer>();
						
					 }else {
						 int MarkNodeVal = Path.get(Path.size()-2);
					     root.MarkNode(MarkNodeVal, root);
					     Path = new ArrayList<Integer>();
				
					}
					val2_find = findPathInDAG(root, val2);
				}			
				root.ClearMark(root);	
				return true;
				
				
				
			}else {
				System.out.println("Some or both nodes are not in the DAG");
				return false;
			}
		}		
	 
		public ArrayList<Integer> findPossibleLca() {
			ArrayList<Integer>Possible_Lca = new ArrayList<Integer>();
			for (ArrayList<Integer> node1 : Paths_Node1) {
				int len_1 = node1.size();
				for (ArrayList<Integer> node2 : Paths_Node2) {
					int len_2 = node2.size();
					int shorter_arr_length = Math.min(len_1,len_2);
					int lca_index = 0;
			
					for (int i = 0; i < shorter_arr_length; i++) {
						if(node1.get(i) == node2.get(i)) {
							lca_index = i;
						}else {
							break;
						}
					}
					
					Possible_Lca.add(node1.get(lca_index));			
			}			
			for (Integer i : Possible_Lca) {
				System.out.println("Possible lca" +  i + " ");
			}
			System.out.println("-----");
			
			}
			return Possible_Lca;
		}
		
		public Node locateNodeViaValue(int val,Node root) {
			Node temp = new Node();
			if(root.value == val) {
				return root;
			}else if(root.successors != null){ 
					for (Node n : root.successors) {
						temp = locateNodeViaValue(val, n);
						if(temp != null) {
							return temp;
						}
					}	
			}else {
				return new Node();
			}
			
			return temp;

		}
		
		// cant pass in the situation 2,3
		public boolean isParent (int val1, int val2) {
			Node node1 = locateNodeViaValue(val1,root);
			Node node2 = locateNodeViaValue(val2,root);;
			
			if(node1.value == node2.value){
				return true; // take node1 as parent in method findfinalLca
			}else {
				if(node1.successors != null) {
					for(Node n : node1.successors) {
						boolean subresult = isParent(n.value, val2);
						if(subresult== true) {
							return true;
						}
					}
				}
			}
			return false;
		}
		
		
		
		
		/*
		public int findfinalLca(ArrayList<Integer> Possible_Lcas) {
			int temp = (int)Possible_Lcas.get(0);
			if(Possible_Lcas.size() == 1) {
				return temp;
			}else {
				for(int i = 0 ;i < Possible_Lcas.size()-1; i++) {
					if()
				}
			}
		}*/
	
		
		public static void main(String[] args) {
			
		}
		
		
		
		
		
}

