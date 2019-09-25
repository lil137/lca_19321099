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
		
		/**
		 * findLca find1 = new findLca();
		 
		find1.root = null;
		int Searched_val3 = 6;
		assertEquals(false,find1.root.CheckExistence(Searched_val3,find1.root));
		 */
		
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
	
	@Test
	public void Testlocate_lca() {
		Integer[] arr1 = {1,2,3,4,5};
		Integer[] arr2 = {1,6,8};
		findLca find_lca = new findLca();
		int real_lca = find_lca.locate_lca(arr1,arr2);
		int expected_lca = 1;
		assertEquals(expected_lca,real_lca);
		
		
		Integer[] arr3 = {1};
		Integer[] arr4 = {1,6,8};
		findLca find_lca1 = new findLca();
		int real_lca1 = find_lca1.locate_lca(arr3,arr4);
		int expected_lca1 = 1;
		assertEquals(expected_lca1,real_lca1);
		
		Integer[] arr5 = {1,2,3};
		Integer[] arr6 = {1,2,4};
		findLca find_lca2 = new findLca();
		int real_lca2 = find_lca2.locate_lca(arr5,arr6);
		int expected_lca2 = 2;
		assertEquals(expected_lca2,real_lca2);
		
	}

	@Test
	public void TestLca_solution() {
		findLca find1 = new findLca();
		find1.root = new TreeNode(1);
		find1.root.left = new TreeNode(3);
		find1.root.right =new TreeNode(5);
		find1.root.left.left = new TreeNode(4);
		find1.root.left.right = new TreeNode(8);
		find1.root.right.left = new TreeNode(6);
		find1.root.right.right = new TreeNode(12);
		
		/**
		 *          1
		 *          
		 *        /   \
 		 *       3     5
		 *      / \   / \ 
		 *     4   8 6   12
		 * 
		 * 
		 * 
		 */
		
		int node1 = 4;
		int node2 = 8;
		int lca1= find1.Lca_solution(find1.root,node1,node2);
		assertEquals(3,lca1);
		
		int node3 = 3;
		int node4 = 1;
		int lca2= find1.Lca_solution(find1.root,node3,node4);
		assertEquals(1,lca2);
		
		
		int node5 = 8;
		int node6 = 5;
		int lca3= find1.Lca_solution(find1.root,node5,node6);
		assertEquals(1,lca3);
		
		
		int node7 = 100;
		int node8 = 3;
		int lca4= find1.Lca_solution(find1.root,node7,node8);
		assertEquals(-1,lca4);
		
	}
	

}
