package main_pack;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Lca_DAGTest {

	@Test
	public void test() {
		Lca_DAG DAG = new Lca_DAG(1);
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
		
		
		
	
		
		
		
		
		for (Node s : DAG.root.successors){
			System.out.println(s.value);
		}
	}

}
