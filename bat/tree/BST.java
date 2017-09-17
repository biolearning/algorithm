package bat.tree;

import java.util.Arrays;
import java.util.Random;

public class BST {
	
	public BSTNode buildBST(int[] nums) {
		BSTNode root = new BSTNode(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			insert(root, nums[i]);
		}
		return root;		
	}
	
	private void insert(BSTNode node, int value) {
		if (value > node.value){
			if (node.right == null) node.right = new BSTNode(value);
			else insert(node.right, value);
		}else {
			if (node.left == null) node.left = new BSTNode(value);
			else insert(node.left, value);
		}
	}
	
	public BSTNode find(BSTNode node, int value) {
		if (node == null) return null;
		if (node.value == value) return node;
		else if (value > node.value) return find(node.right, value);
		else return find(node.left, value);
	}
	
	public void delete(BSTNode node, int value) {
		if (node == null) return;
		BSTNode p = node;
		while (node != null && node.value != value) {
			p = node;
			if (value > node.value) {
				node = node.right;
			} else {
				node = node.left;
			}			
		}
		
		if (node == null) return;
		
		if (node.left == null && node.right == null) {
			if (node.value > p.value) p.right = null;
			else p.left = null;
		} else if (node.left == null || node.right == null) {
			BSTNode g = node.left != null ? node.left : node.right;
			if (node.value > p.value) p.right = g;
			else p.left = g;
		} else {
			BSTNode n = node.right;
			BSTNode np = node.right;
			while (n.left != null) {
				np = n;
				n = n.left;
			}
			node.value = n.value;
			if (n.right == null) {
				if (n.value > np.value) np.right = null;
				else np.left = null;
			}else {
				if (n.value > np.value) np.right = n.right;
				else np.left = n.right;
			}
			
		}
	}
	
	/**
	 * 简化版
	 * @param root: 二叉树的根
	 * @param value: 待删除的节点值
	 */
	public void delete2(BSTNode root, int value) {
		if (root == null) return;
		
		//找到待删除的节点cur，以及它的parent p
		BSTNode p = root;
		BSTNode cur = root;
		while (cur != null && cur.value != value) {
			p = cur;
			if (value > cur.value) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}			
		}
		
		//如果没有找到待删除的节点，则直接返回
		if (cur == null) return;
		
		//如果待删除节点至少存在一个空子树
		if (cur.left == null || cur.right == null) {
			//找到非空子树grandson，左子树或者右子树；注意如果左右都为空，则grandson为null
			BSTNode g = cur.left != null ? cur.left : cur.right;
			//如果待删除节点cur是parent的右子树，则右侧指向grandson；否则左侧指向grandson；
			if (cur.value > p.value) p.right = g;
			else p.left = g;
		} else { //如果左右都不为空
			//找到待删除节点cur的直接后继，即有子树的最左节点；此时保留最左节点n及其它的parent np节点指针；
			BSTNode n = root.right;
			BSTNode np = root.right;
			while (n.left != null) {
				np = n;
				n = n.left;
			}
			//将待删除节点cur的值用直接后继的值来替代
			cur.value = n.value;
			//删除直接后继
			//因为n是右子树的最左节点，所以n一定不会再存在左子树；所以np直接指向n.right 即可；
			//根据np和n的关系，决定是np的左还是右子树指针
			if (n.value > np.value) np.right = n.right;
			else np.left = n.right;
		}
	}
	
	public void preOrder(BSTNode root) {
		if (root == null) return;
		System.out.print(root.value + " -> ");
		preOrder(root.left);
		preOrder(root.right);
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
			nums[i] = rand.nextInt(50);
		}
		nums = new int[]{41, 26, 10, 1, 39, 4, 2, 7, 23, 11};
		System.out.println(Arrays.toString(nums));
		
		
		BST bst = new BST();
		BSTNode root = bst.buildBST(nums);
		
		BSTNode findNode = bst.find(root, nums[4]);
		System.out.println(findNode);
		
		bst.preOrder(root);
		System.out.println();
		bst.inOrder(root);
		System.out.println();
		bst.postOrder(root);
		System.out.println();
		
		System.out.println("delete 10 ...");
		bst.delete2(root, 10);
		
		bst.preOrder(root);
		System.out.println();
		bst.inOrder(root);
		System.out.println();
		bst.postOrder(root);
		System.out.println();
	}

}

class BSTNode {
	int value;
	BSTNode left, right;
	BSTNode(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return value + "";
	}
	
}
