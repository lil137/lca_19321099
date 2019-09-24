package main_pack;

import static org.junit.Assert.*;

import org.junit.Test;

public class LcaTest {

	@Test
	public void testCheckExistence() {
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
	
	/*
	 * @Test
	 * public void testArray_Merge() {
		int[] arr1 = {1,3,4,5};
		int[] arr2 = {6,7,8,9,};
		int[] expected_merged = {1,3,4,5,6,7,8,9};
		int[] actual_merged = Array_Merge.Merge_Array(arr1, arr2);
		for(int i = 0; i< expected_merged.length; i++) {
			assertEquals(expected_merged[i],actual_merged[i]);
		}
	}
	 */
	

}
