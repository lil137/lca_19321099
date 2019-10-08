package main_pack;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Lca_DAGTest {

	@Test
	public void TestisEmptyDAG() {
		Lca_DAG DAG = new Lca_DAG();
		assertEquals(true,DAG.isEmptyDAG(DAG));
		DAG.root = new Node(1);
		assertEquals(false,DAG.isEmptyDAG(DAG));
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
		 *                   		   7   
		 *                             |
		 *                         9����10
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
		//Node node_1 = new Node(1);
		//DAG.root = node_1;
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
		 *                         9����10
		 *                            / \  
		 *                          13   11
		 *                                \
		 *                                 12
		 * 
		 * 
		 * */
		 //ArrayList<Integer> Path = new ArrayList<Integer>();

		 System.out.println(node_6.isMarked);
		 
	

		 /*boolean test1 =DAG.findPathInDAG(DAG.root,7,DAG.Path);
		 if(test1) {
			 for ( Integer integer : DAG.Path) {
				 System.out.println(integer);
			 }
			 DAG.Paths_Node1.add(DAG.Path);
			 if(DAG.Path.size() == 1) {
				 DAG.root.isMarked = true;
				 DAG.Path.clear();
			 }else {
				 int MarkNodeVal = DAG.Path.get(DAG.Path.size()-2);
			     DAG.root.MarkNode(MarkNodeVal, DAG.root);
				 DAG.Path.clear();

			 }		
		 }else {
			 System.out.println("Val not in");
		 }*/
		 
		 System.out.println(node_6.isMarked);
		 
		 DAG.findLcaInDAG(4, 7, DAG);
		 System.out.println(DAG.Paths_Node1.size());
		 System.out.println(DAG.Paths_Node2.size());
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
		 
		 
	}

}
