package main_pack;

import java.util.*;

/*Codes and ideas are adapted from:
	1.https://stackoverflow.com/questions/15460661/different-ways-to-implement-dags-in-java
	2.https://www.jianshu.com/p/d4b54510c8ec
	3.http://www.runoob.com/java/java-collections.html
*/


class Node{
	List<Node> successors;
	int value; 

	public Node() {
	}

	
	public Node(int val) {
		value = val;
		successors = new ArrayList<Node>();
	}

	public Node(int val,List<Node> succ) {
		value = val;
		successors = succ;
	}
}

public class Lca_DAG{
		
		Node root;// = new Node(); // assuming only one root exists	
		
		public Lca_DAG() {
		}
		
		public Lca_DAG(int val) {
			root.value = val;
			root.successors = new ArrayList<Node>();
		}

		
		public Lca_DAG(int val,List<Node> succ) {
			root.value = val;
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
		
		
		private Object[] Paths_Node1 = { new ArrayList<Integer>()};
		private Object[] Paths_Node2 = { new ArrayList<Integer>()};
		ArrayList<Integer> Path = new ArrayList<Integer>();
		
		// check the existence first then use the below method to find the path
		// so we don't have to check the existence in this function
		public boolean findPathInDAG(Node node, int val,ArrayList<Integer> Path) {
			if (node == null) {
				return false;
			}else {
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


/*class PathMap {
	  HashMap<Lca_DAG, List<Lca_DAG> > pathMap;

	  public List<Lca_DAG> getPathFromRoot(Lca_DAG n) {
	     List<Lca_DAG> pathFromRoot = pathMap.get(n);
	     return pathFromRoot;
	  }
}*/
