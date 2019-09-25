package main_pack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LcaTest {

	@Test
	public void TestCheckExistence() {
		findLca find = new findLca();
		find.root = new TreeNode(1);
		find.root.left = new TreeNode(2);
		find.root.right =new TreeNode(3);
		find.root.left.left = new TreeNode(4);
		find.root.left.right = new TreeNode(5);
		
		/**
		 *       1
		 *      / \
		 *     2   3
		 *    / \
		 *   4   5
		 */
		
		int Searched_val = 6;
		assertEquals(false,find.root.CheckExistence(Searched_val,find.root));
		
		int Searched_val2 = 3;
		assertEquals(true,find.root.CheckExistence(Searched_val2,find.root));
	}
	
	@Test
	public void TestfindPath() {
		findLca find = new findLca();
		find.root = new TreeNode(1);
		find.root.left = new TreeNode(2);
		find.root.right =new TreeNode(3);
		find.root.left.left = new TreeNode(4);
		find.root.left.right = new TreeNode(5);
		
		/**
		 *       1
		 *      / \
		 *     2   3
		 *    / \
		 *   4   5
		 */
		
		int node1 = 1;
		int node2 = 3;
		int node3 = 4;
		int[] node1_path = {1};
		int[] node2_path = {1,3};
		int[] node3_path = {1,2,4};
		
		List<Integer> path1 = new ArrayList<>(); 
		find.findPath(find.root,node1,path1);
		Integer[] path1_arr = new Integer[path1.size()];
        path1_arr = path1.toArray(path1_arr);
        for(int i = 0; i < path1_arr.length; i++) {
        	assertEquals(node1_path[i],(int)path1_arr[i]);
        }
        
        List<Integer> path2 = new ArrayList<>(); 
		find.findPath(find.root,node2,path2);
		Integer[] path2_arr = new Integer[path2.size()];
        path2_arr = path2.toArray(path2_arr);
        for(int i = 0; i < path2_arr.length; i++) {
        	assertEquals(node2_path[i],(int)path2_arr[i]);
        }
        
        List<Integer> path3 = new ArrayList<>(); 
		find.findPath(find.root,node3,path3);
		Integer[] path3_arr = new Integer[path3.size()];
        path3_arr = path3.toArray(path3_arr);
        for(int i = 0; i < path3_arr.length; i++) {
        	assertEquals(node3_path[i],(int)path3_arr[i]);
        }
		
		
	
	
	}

	

}
