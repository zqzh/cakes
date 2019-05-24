//用java实现的数组创建二叉树以及递归先序遍历，
//递归中序遍历，递归后序遍历，非递归前序遍历，非递归中序遍历，非递归后序遍历，深度优先遍历，广度优先遍历8种遍历方式：

package com.alam.app.alam_app;

import java.util.List;

public class test {
	public static void main(String[] args) {
		createTree([1, 2, 0, 0, 3, 4, 5, 0, 6, 7, 8, 0, 0, 9 ]);
		
	}
	public void disp(TreeNode tree){
	    if(tree != null){
	        System.out.print(tree.data);
	        disp(tree.leftNode);
	        disp(tree.rightNode);
	    }
	}
	
	public class TreeNode {
		int data;
		TreeNode leftNode;
		TreeNode rightNode;

		public TreeNode() {
		}

		public TreeNode(int data) {
			this.data = data;
			this.leftNode = null;
			this.rightNode = null;
		}

		public TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}

	// 实现二叉链表结构，建立二叉树
	public TreeNode createTree(List<Integer> data) {
//		int data[] = { 1, 2, 0, 0, 3, 4, 5, 0, 6, 7, 8, 0, 0, 9 };
		TreeNode tree = null;
		
		for (int i = 0; i < data.size(); i++) {
			tree = new TreeNode(data.get(i));
			tree.leftNode = createTree();
			tree.rightNode = createTree();
		}
		return tree;
	}
}
