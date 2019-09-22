package main_pack;



	class BinaryTree {
		public int value; 
	    public BinaryTree right; 
		public BinaryTree left; 
 
		public BinaryTree(int val) {
			this.value = val;
			this.left = null;
			this.right = null;
		}
		
		public void MakeleftBranch(int val) {
			this.left = new BinaryTree(val);
		}
		
		public void MakeRightBranch(int val) {
			this.right = new BinaryTree(val);
		}
		
		public boolean CheckExistence(int val) {
			boolean leftResult = false;
			boolean rightResult = false;
			if (this.value == val) {
				return true;
			}else {
				if (this.left != null) {
					leftResult = left.CheckExistence(val);
				}else {
					return false; 
				}
				
				if(this.right != null) {
					rightResult = right.CheckExistence(val);
				}else {
					return false;
				}
				
			}
			return leftResult || rightResult;
		}
	}


public class Lca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree(1);
		tree.MakeleftBranch(2);
		tree.MakeRightBranch(3);
		tree.left.MakeleftBranch(4);
		int Searched_val = 5;
		if (tree.CheckExistence(Searched_val)) {
			System.out.println(Searched_val + " is in the tree");
		}else {
			System.out.println(Searched_val + " is not in the tree");
		}

	}

}
