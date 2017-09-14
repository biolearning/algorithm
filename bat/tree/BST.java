package bat.tree;

import java.util.Arrays;
import java.util.Random;

public class BST {
	
	public BSTNode buildBST(int[] nums) {
		BSTNode root = new BSTNode(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			buildHelper(root, nums[i]);
		}
		return root;		
	}
	
	private void buildHelper(BSTNode node, int value) {
		if (value > node.value){
			if (node.right == null) node.right = new BSTNode(value);
			else buildHelper(node.right, value);
		}else {
			if (node.left == null) node.left = new BSTNode(value);
			else buildHelper(node.left, value);
		}
	}
	
	public void preOrder(BSTNode root) {
		if (root == null) return;
		System.out.print(root.value + " -> ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public BSTNode find(BSTNode node, int value) {
		if (node == null) return null;
		if (node.value == value) return node;
		else if (value > node.value) return find(node.right, value);
		else return find(node.left, value);
	}
	
	public void inOrder(BSTNode root) {
		if (root == null) return;
		inOrder(root.left);
		System.out.print(root.value + " -> ");
		inOrder(root.right);
	}
	
	public void postOrder(BSTNode root) {
		if (root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.value + " -> ");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int N = 10;
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = rand.nextInt(20);
		}
		nums = new int[]{6, 6, 2, 10, 10, 7, 6, 14, 0, 16};
		System.out.println(Arrays.toString(nums));
		
		
		BST bst = new BST();
		BSTNode root = bst.buildBST(nums);
		
		BSTNode findNode = bst.find(root, 7);
		System.out.println(findNode.value);
		
		bst.preOrder(root);
		System.out.println();
		bst.inOrder(root);
		System.out.println();
		bst.postOrder(root);
	}

}

class BSTNode {
	int value;
	BSTNode left, right;
	BSTNode(int value) {
		this.value = value;
	}
}
