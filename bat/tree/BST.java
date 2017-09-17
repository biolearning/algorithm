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
	 * �򻯰�
	 * @param root: �������ĸ�
	 * @param value: ��ɾ���Ľڵ�ֵ
	 */
	public void delete2(BSTNode root, int value) {
		if (root == null) return;
		
		//�ҵ���ɾ���Ľڵ�cur���Լ�����parent p
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
		
		//���û���ҵ���ɾ���Ľڵ㣬��ֱ�ӷ���
		if (cur == null) return;
		
		//�����ɾ���ڵ����ٴ���һ��������
		if (cur.left == null || cur.right == null) {
			//�ҵ��ǿ�����grandson��������������������ע��������Ҷ�Ϊ�գ���grandsonΪnull
			BSTNode g = cur.left != null ? cur.left : cur.right;
			//�����ɾ���ڵ�cur��parent�������������Ҳ�ָ��grandson���������ָ��grandson��
			if (cur.value > p.value) p.right = g;
			else p.left = g;
		} else { //������Ҷ���Ϊ��
			//�ҵ���ɾ���ڵ�cur��ֱ�Ӻ�̣���������������ڵ㣻��ʱ��������ڵ�n��������parent np�ڵ�ָ�룻
			BSTNode n = root.right;
			BSTNode np = root.right;
			while (n.left != null) {
				np = n;
				n = n.left;
			}
			//����ɾ���ڵ�cur��ֵ��ֱ�Ӻ�̵�ֵ�����
			cur.value = n.value;
			//ɾ��ֱ�Ӻ��
			//��Ϊn��������������ڵ㣬����nһ�������ٴ���������������npֱ��ָ��n.right ���ɣ�
			//����np��n�Ĺ�ϵ��������np������������ָ��
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
