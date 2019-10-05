package main_pack;

import java.util.*;

/*Codes are adopted from: 1.https://stackoverflow.com/questions/15460661/different-ways-to-implement-dags-in-java
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
		
		Node root = new Node(); // assuming only one root exists	
		
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
	
		public static void main(String[] args) {
			Lca_DAG DAG = new Lca_DAG(1);
			DAG.root.successors.add(new Node(2)); 
			DAG.root.successors.add(new Node(3)); 
			DAG.root.successors.add(new Node(4)); 
			DAG.root.successors.add(new Node(5)); 
			for (Node s : DAG.root.successors){
				System.out.println(s.value);
			}
		}
		
		
		
}


class PathMap {
	  HashMap<Lca_DAG, List<Lca_DAG> > pathMap;

	  public List<Lca_DAG> getPathFromRoot(Lca_DAG n) {
	     List<Lca_DAG> pathFromRoot = pathMap.get(n);
	     return pathFromRoot;
	  }
}
