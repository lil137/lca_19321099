package main_pack;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Lca_DAGTest {
	
	

	@Test
	public void TestisEmptyDAG() {
		Lca_DAG DAG = new Lca_DAG();
		assertEquals(true,DAG.isEmptyDAG());
		DAG.root = new Node(1);
		assertEquals(false,DAG.isEmptyDAG());
	}
	
	@Test
	public void TestCheckExistenceInDAG(){
		Lca_DAG DAG = new Lca_DAG();
		DAG.root = new Node(1);
		DAG.root.successors.add(new Node(2)); 
		DAG.root.successors.add(new Node(3)); 
		
		Node node_2 = DAG.root.successors.get(0);
		node_2.successors.add(new Node(4));
		Node node_4 = node_2.successors.get(0);
		node_4.successors.add(new Node(6));
		Node node_6 = node_4.successors.get(0);
		
		Node node_3 = DAG.root.successors.get(1);
		node_3.successors.add(new Node(5));
		Node node_5 = node_3.successors.get(0);
		
		node_5.successors.add(new Node(7));
		Node node_7 = node_5.successors.get(0);
		node_2.successors.add(node_7);
		node_6.successors.add(node_7);
		
		node_7.successors.add(new Node(10));
		Node node_10 = node_7.successors.get(0);
		
		node_10.successors.add(new Node(9));
		Node node_9 = node_10.successors.get(0);
		
		node_10.successors.add(new Node(13));
		Node node_13 = node_10.successors.get(1);
		
		node_10.successors.add(new Node(11));
		Node node_11 = node_10.successors.get(2);
		
		node_11.successors.add(new Node(12));
		Node node_12 = node_11.successors.get(0);
		
		node_5.successors.add(new Node(8));
		Node node_8 = node_5.successors.get(1);
		/*
		 *                          1
		 *                        /   \
		 *                       2     3
		 *                      / \      \
		 *                     4   \      5 
		 *                    /     \    / \
		 *                   6       \  /   8
		 *                    \       \/   
		 *                   	\	   |
		 *                   	  \	   |	
		 *                   		\  |
		 *                    		  7   
		 *                             |
		 *                         9！！10
		 *                            / \  
		 *                          13   11
		 *                                \
		 *                                 12
		 * 
		 * 
		 * */
		
		//boolean check1 = DAG.CheckExistenceInDAG(DAG.root,6);
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,1));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,2));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,3));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,4));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,5));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,6));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,7));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,8));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,9));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,10));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,11));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,12));
		assertEquals(true,DAG.CheckExistenceInDAG(DAG.root,13));
		
		
		assertEquals(false,DAG.CheckExistenceInDAG(DAG.root,0));
		assertEquals(false,DAG.CheckExistenceInDAG(DAG.root,100));
	}
	
	
	@Test
	public void TestfindPathInDAG(){
		Lca_DAG DAG = new Lca_DAG();
		DAG.root = new Node(1);
		DAG.root.successors.add(new Node(2)); 
		DAG.root.successors.add(new Node(3)); 
		
		Node node_2 = DAG.root.successors.get(0);
		node_2.successors.add(new Node(4));
		Node node_4 = node_2.successors.get(0);
		node_4.successors.add(new Node(6));
		Node node_6 = node_4.successors.get(0);
		
		Node node_3 = DAG.root.successors.get(1);
		node_3.successors.add(new Node(5));
		Node node_5 = node_3.successors.get(0);
		
		node_5.successors.add(new Node(7));
		Node node_7 = node_5.successors.get(0);
		node_2.successors.add(node_7);
		node_6.successors.add(node_7);
		
		node_7.successors.add(new Node(10));
		Node node_10 = node_7.successors.get(0);
		
		node_10.successors.add(new Node(9));
		Node node_9 = node_10.successors.get(0);
		
		node_10.successors.add(new Node(13));
		Node node_13 = node_10.successors.get(1);
		
		node_10.successors.add(new Node(11));
		Node node_11 = node_10.successors.get(2);
		
		node_11.successors.add(new Node(12));
		Node node_12 = node_11.successors.get(0);
		
		node_5.successors.add(new Node(8));
		Node node_8 = node_5.successors.get(1);
		
		/*
		 *                          1
		 *                        /   \
		 *                       2     3
		 *                      / \      \
		 *                     4   \      5 
		 *                    /     \    / \
		 *                   6       \  /   8
		 *                    \       \/   
		 *                   	\	   |
		 *                   	  \	   |	
		 *                   		\  |
		 *                    		  7   
		 *                             |
		 *                         9！！10
		 *                            / \  
		 *                          13   11
		 *                                \
		 *                                 12
		 * 
		 * 
		 * */
         int node1 = 1;
         ArrayList<Integer> node1Path = new ArrayList<Integer>();
         node1Path.add(1);
         if(DAG.findPathInDAG(DAG.root,node1)){
        	 for(int i = 0 ; i < DAG.Path.size();i++) {
        		 assertEquals(node1Path.get(i),DAG.Path.get(i));
        	 }
         }
         
         DAG.Path = new ArrayList<Integer>();
         
         
         //This method is only try to find signle path from root
         // to certain node according to mark.
         int node2 = 7;
         ArrayList<Integer> node2Path = new ArrayList<Integer>();
         node2Path.add(1);
         node2Path.add(2);
         node2Path.add(4);
         node2Path.add(6);
         node2Path.add(7);
         if(DAG.findPathInDAG(DAG.root,node2)){
        	 for(int i = 0 ; i < DAG.Path.size();i++) {
        		 assertEquals(node2Path.get(i),DAG.Path.get(i));
        	 }
         }
         
         DAG.Path = new ArrayList<Integer>();
	
         node_6.isMarked = true;
         ArrayList<Integer> node2Path2 = new ArrayList<Integer>();
         node2Path2.add(1);
         node2Path2.add(2);
         node2Path2.add(7);
         if(DAG.findPathInDAG(DAG.root,node2)){
        	 for(int i = 0 ; i < DAG.Path.size();i++) {
        		 assertEquals(node2Path2.get(i),DAG.Path.get(i));
        	 }
         }
         
         DAG.Path = new ArrayList<Integer>();
		 
	}
	
	@Test
	public void TestAddPathForEachNode() {
		Lca_DAG DAG = new Lca_DAG();
		DAG.root = new Node(1);
		DAG.root.successors.add(new Node(2)); 
		DAG.root.successors.add(new Node(3)); 
		
		Node node_2 = DAG.root.successors.get(0);
		node_2.successors.add(new Node(4));
		Node node_4 = node_2.successors.get(0);
		node_4.successors.add(new Node(6));
		Node node_6 = node_4.successors.get(0);
		
		Node node_3 = DAG.root.successors.get(1);
		node_3.successors.add(new Node(5));
		Node node_5 = node_3.successors.get(0);
		
		node_5.successors.add(new Node(7));
		Node node_7 = node_5.successors.get(0);
		node_2.successors.add(node_7);
		node_6.successors.add(node_7);
		
		node_7.successors.add(new Node(10));
		Node node_10 = node_7.successors.get(0);
		
		node_10.successors.add(new Node(9));
		Node node_9 = node_10.successors.get(0);
		
		node_10.successors.add(new Node(13));
		Node node_13 = node_10.successors.get(1);
		
		node_10.successors.add(new Node(11));
		Node node_11 = node_10.successors.get(2);
		
		node_11.successors.add(new Node(12));
		Node node_12 = node_11.successors.get(0);
		
		node_5.successors.add(new Node(8));
		Node node_8 = node_5.successors.get(1);
		
		
		assertEquals(false,DAG.AddPathForEachNode(100, 200));
		
		
		int node1 = 4;
		int node2 = 7;
		ArrayList<Integer> node1Path1 = new ArrayList<Integer>();
		node1Path1.add(1);
		node1Path1.add(2);
		node1Path1.add(4);
		
		ArrayList<Integer> node2Path1 = new ArrayList<Integer>();
		node2Path1.add(1);
		node2Path1.add(2);
		node2Path1.add(4);
		node2Path1.add(6);
		node2Path1.add(7);
		
		ArrayList<Integer> node2Path2 = new ArrayList<Integer>();
		node2Path2.add(1);
		node2Path2.add(2);
		node2Path2.add(7);
		
		ArrayList<Integer> node2Path3 = new ArrayList<Integer>();
		node2Path3.add(1);
		node2Path3.add(3);
		node2Path3.add(5);
		node2Path3.add(7);
		
		
		DAG.AddPathForEachNode(node1,node2);
		ArrayList<Integer> temp = DAG.Paths_Node1.get(0);
		for(int j = 0 ; j < temp.size();j++) {
			assertEquals(temp.get(j),node1Path1.get(j));
		}
		
		temp = DAG.Paths_Node2.get(0);
		for(int j = 0 ; j < temp.size();j++) {
			assertEquals(temp.get(j),node2Path1.get(j));
		}
		
		temp = DAG.Paths_Node2.get(1);
		for(int j = 0 ; j < temp.size();j++) {
			assertEquals(temp.get(j),node2Path2.get(j));
		}
		
		temp = DAG.Paths_Node2.get(2);
		for(int j = 0 ; j < temp.size();j++) {
			assertEquals(temp.get(j),node2Path3.get(j));
		}
		
		
	}

	@Test
	public void TestfindPossibleLca() {
		Lca_DAG DAG = new Lca_DAG();
		DAG.root = new Node(1);
		DAG.root.successors.add(new Node(2)); 
		DAG.root.successors.add(new Node(3)); 
		
		Node node_2 = DAG.root.successors.get(0);
		node_2.successors.add(new Node(4));
		Node node_4 = node_2.successors.get(0);
		node_4.successors.add(new Node(6));
		Node node_6 = node_4.successors.get(0);
		
		Node node_3 = DAG.root.successors.get(1);
		node_3.successors.add(new Node(5));
		Node node_5 = node_3.successors.get(0);
		
		node_5.successors.add(new Node(7));
		Node node_7 = node_5.successors.get(0);
		node_2.successors.add(node_7);
		node_6.successors.add(node_7);
		
		node_7.successors.add(new Node(10));
		Node node_10 = node_7.successors.get(0);
		
		node_10.successors.add(new Node(9));
		Node node_9 = node_10.successors.get(0);
		
		node_10.successors.add(new Node(13));
		Node node_13 = node_10.successors.get(1);
		
		node_10.successors.add(new Node(11));
		Node node_11 = node_10.successors.get(2);
		
		node_11.successors.add(new Node(12));
		Node node_12 = node_11.successors.get(0);
		
		node_5.successors.add(new Node(8));
		Node node_8 = node_5.successors.get(1);
		
		int node1 = 4;
		int node2 = 7;
		
		DAG.AddPathForEachNode(node1, node2);
		ArrayList<Integer> temp = DAG.findPossibleLca();
		int count = 0;
		for(int i = 0 ; i < temp.size(); i++) {
			if(temp.get(i) == 1 || temp.get(i) == 2 || temp.get(i) == 4) {
				count++;
			}
		}
		assertEquals(3,count);
		
	}
	
	@Test
	public void TestlocateNodeViaValue() {
		Lca_DAG DAG = new Lca_DAG();
		DAG.root = new Node(1);
		DAG.root.successors.add(new Node(2)); 
		DAG.root.successors.add(new Node(3)); 
		
		Node node_2 = DAG.root.successors.get(0);
		node_2.successors.add(new Node(4));
		Node node_4 = node_2.successors.get(0);
		node_4.successors.add(new Node(6));
		Node node_6 = node_4.successors.get(0);
		
		Node node_3 = DAG.root.successors.get(1);
		node_3.successors.add(new Node(5));
		Node node_5 = node_3.successors.get(0);
		
		node_5.successors.add(new Node(7));
		Node node_7 = node_5.successors.get(0);
		node_2.successors.add(node_7);
		node_6.successors.add(node_7);
		
		node_7.successors.add(new Node(10));
		Node node_10 = node_7.successors.get(0);
		
		node_10.successors.add(new Node(9));
		Node node_9 = node_10.successors.get(0);
		
		node_10.successors.add(new Node(13));
		Node node_13 = node_10.successors.get(1);
		
		node_10.successors.add(new Node(11));
		Node node_11 = node_10.successors.get(2);
		
		node_11.successors.add(new Node(12));
		Node node_12 = node_11.successors.get(0);
		
		node_5.successors.add(new Node(8));
		Node node_8 = node_5.successors.get(1);
		
		/*
		 *                          1
		 *                        /   \
		 *                       2     3
		 *                      / \      \
		 *                     4   \      5 
		 *                    /     \    / \
		 *                   6       \  /   8
		 *                    \       \/   
		 *                   	\	   |
		 *                   	  \	   |	
		 *                   		\  |
		 *                    		  7   
		 *                             |
		 *                         9！！10
		 *                            / \  
		 *                          13   11
		 *                                \
		 *                                 12
		 * 
		 * 
		 * */
		
	    assertEquals(DAG.root,DAG.locateNodeViaValue(1,DAG.root));
	    assertEquals(true, node_2.equals(DAG.locateNodeViaValue(2,DAG.root)));
	    //assertEquals(true, node_3.equals(DAG.locateNodeViaValue(3,DAG.root)));
	    assertEquals(true, node_4.equals(DAG.locateNodeViaValue(4,DAG.root)));
	    //assertEquals(true, node_5.equals(DAG.locateNodeViaValue(5,DAG.root)));
	    assertEquals(true, node_6.equals(DAG.locateNodeViaValue(6,DAG.root)));
	    assertEquals(true, node_7.equals(DAG.locateNodeViaValue(7,DAG.root)));
	    
	    //assertEquals(true, node_8.equals(DAG.locateNodeViaValue(8,DAG.root)));
	    assertEquals(true, node_9.equals(DAG.locateNodeViaValue(9,DAG.root)));
	    assertEquals(true, node_10.equals(DAG.locateNodeViaValue(10,DAG.root)));
	    //assertEquals(true, node_11.equals(DAG.locateNodeViaValue(11,DAG.root)));
	    
	    //assertEquals(true, node_12.equals(DAG.locateNodeViaValue(12,DAG.root)));
	    //assertEquals(true, node_13.equals(DAG.locateNodeViaValue(13,DAG.root)));
	    System.out.println(DAG.locateNodeViaValue(12, DAG.root).value);
	}
	
	/*
	 * 
	 * 	 DAG.AddPathForEachNode(node1,node2);
		 //System.out.println(node_2.isMarked);
		 
		 System.out.println("Node1path" + DAG.Paths_Node1.size());
		 System.out.println("Node2path" + DAG.Paths_Node2.size());
		 for (int i = 0; i< DAG.Paths_Node1.size();i++) {
			 ArrayList<Integer> temp = DAG.Paths_Node1.get(i);
			 for (int j = 0; j < temp.size();j++) {
				 System.out.print(temp.get(j)+ " ");
			 }
			 System.out.println();
			 
		 }
		 
		 System.out.println("----------");
		 
		 for (int i = 0; i< DAG.Paths_Node2.size();i++) {
			 ArrayList<Integer> temp = DAG.Paths_Node2.get(i);
			 for (int j = 0; j < temp.size();j++) {
				 System.out.print(temp.get(j)+ " ");
			 }
			 System.out.println();
			
		 }
		 
		 System.out.println("123----------");
		 ArrayList<Integer> PossibleLca = DAG.findPossibleLca();
		 
		 Node n1 = DAG.locateNodeViaValue(7,DAG.root);
		 System.out.println("locatNodeViaValue" + n1.value);
		 
		 boolean isParentTest =DAG.isParent(2,3);
		 System.out.println(isParentTest);
		 
		 int lcainDAG = DAG.findfinalLca(PossibleLca);
		 System.out.println("LCA in DAG " + lcainDAG);
		 
		 */
	
	
}
