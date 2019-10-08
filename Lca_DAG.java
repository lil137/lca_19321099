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
	
	public void ClearMark(int val,Node root) {
		if(root == null) {
        	return;
        }
        
        
		if (root.value == val) {
	    	root.isMarked = false;
	    }else {
	    	for (Node ns : root.successors) {
	    		root.ClearMark(val,ns);
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
		
		//private ArrayList<Integer> Node1PathDemo = new ArrayList<Integer>();
		//private ArrayList<Integer> Node2PathDemo = new ArrayList<Integer>();
		
		
		public List<ArrayList<Integer>> Paths_Node1 = new ArrayList<ArrayList<Integer>>(); // = { new ArrayList<Integer>()};
		public List<ArrayList<Integer>> Paths_Node2 = new ArrayList<ArrayList<Integer>>();; // = { new ArrayList<Integer>()};
		ArrayList<Integer> Path = new ArrayList<Integer>();
		
		// check the existence first then use the below method to find the path
		// so we don't have to check the existence in this function
		public boolean findPathInDAG(Node node, int val,ArrayList<Integer> Path) {
			if (node == null) {
				return false;
			}else if(node.isMarked != true){
				Path.add(node.value);
				
				if (node.value == val) {
					return true;
				}
				for (int i = 0; i < node.successors.size(); i++) {
					if(node.successors.size() != 0 &&
			           findPathInDAG(node.successors.get(i),val,Path)) {
						return true;
					}
				}			
				Path.remove(Path.size()-1);
				return false;
			}else {
				return false;
			}
		}
		
		
		
		//@SuppressWarnings("unchecked")
		/*public void InsertPath(Object[] Paths_node, ArrayList<Integer> Path) {
			if(Paths_node[Paths_node.length-1] != null) {
			    ArrayList<Integer>[] New_Path_Node = (ArrayList<Integer>[])new Object[Paths_node.length*2];
				for(int i =0 ; i < Paths_node.length;i++) {
					New_Path_Node[i] = (ArrayList<Integer>)Paths_node[i];
				}
				Paths_node = New_Path_Node;
			}else {
				for(int i = 0; i < Paths_node.length;i++) {
					if(Paths_node[i] == null) {
						Paths_node[i] = Path;
						break;
					}
				}
			}
			
		}*/
		
		public int findLcaInDAG(int val1, int val2, Lca_DAG DAG){
			if (DAG.CheckExistenceInDAG(DAG.root, val1) && DAG.CheckExistenceInDAG(DAG.root, val2)) {
				boolean val1_find = DAG.findPathInDAG(DAG.root, val1, DAG.Path);
				while(val1_find) {
					for(int i = 0; i < DAG.Path.size();i++) {
						System.out.print(DAG.Path.get(i) + " ");
					}
					System.out.println();
						
					DAG.Paths_Node1.add(DAG.Path);
					if(DAG.Path.size() == 1) {
						 DAG.root.isMarked = true;
						 DAG.Path.clear();
					 }else {
						 int MarkNodeVal = DAG.Path.get(DAG.Path.size()-2);
					     DAG.root.MarkNode(MarkNodeVal, DAG.root);
						 DAG.Path.clear();
					}
					val1_find = DAG.findPathInDAG(DAG.root, val1, DAG.Path);
				}
				
				boolean val2_find = DAG.findPathInDAG(DAG.root, val2, DAG.Path);
				while(val2_find) {
					DAG.Paths_Node2.add(DAG.Path);
					
					System.out.println("test here");
					for (int j = 0; j < DAG.Path.size();j++) {
						 System.out.print(DAG.Path.get(j)+ " ");
					 }
					 System.out.println();
					 
					 
					if(DAG.Path.size() == 1) {
						 DAG.root.isMarked = true;
						 DAG.Path.clear();
						 //DAG.root.ClearMark(root);
					 }else {
						 int MarkNodeVal = DAG.Path.get(DAG.Path.size()-2);
					     DAG.root.MarkNode(MarkNodeVal, DAG.root);
						 DAG.Path.clear();
						 //DAG.root.ClearMark(root);
					}
					val2_find = DAG.findPathInDAG(DAG.root, val2, DAG.Path);
				}
				
				return 0;
				
				
			}else {
				System.out.println("Some or both nodes are not in the DAG");
				return -1; // default value
			}
		}		
		
	
		
		public static void main(String[] args) {
			Lca_DAG DAG = new Lca_DAG();
			DAG.isEmptyDAG(DAG);
			DAG.root = new Node(1);
			//DAG.root.value = 1;
			//DAG.root.successors = new ArrayList<Node>();
			DAG.root.successors.add(new Node(2)); 
			DAG.root.successors.add(new Node(3)); 
			DAG.root.successors.add(new Node(4)); 
			DAG.root.successors.add(new Node(5)); 
			
			//boolean check1 = DAG.CheckExistenceInDAG(DAG.root,6);
			//System.out.println(check1);
			/*for (Node s : DAG.root.successors){
				System.out.println(s.value);
			}*/
		}
		
		
		
		
		
}

