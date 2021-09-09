package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 플랫폼 : 백준
 * 문제번호 : 1991
 * 문제제목 : 트리 순회
 * 난이도 : 실버 1
 * 제한사항 : 2초/128MB
 * 알고리즘 분류 : 트리, 재귀
 *
 * 알고리즘 설명
 * 트리 구현
 * 트리 순회
 *
 * 채점 결과 : 84ms/11636KB
 * 풀이 날짜 : 2021/07/07
**/

class Node {
	char value;
	Node left;
	Node right;
	
	Node(char value) {
		this.value = value;
	}
}

class Tree {
	Node root;
	
	public void insert(char value, char leftValue, char rightValue) {
		if (root == null) {
			root = new Node(value);
			
			if (leftValue != '.') {
				root.left = new Node(leftValue);
			}
			
			if (rightValue != '.') {
				root.right = new Node(rightValue);
			}
		} else {
			search(root, value, leftValue, rightValue);
		}
	}
	
	public void search(Node root, char value, char leftValue, char rightValue) {
		if (root == null) {
			return;
		} else if (root.value == value) {
			if (leftValue != '.') {
				root.left = new Node(leftValue);
			}
			
			if (rightValue != '.') {
				root.right = new Node(rightValue);
			}
		} else {
			search(root.left, value, leftValue, rightValue);
			search(root.right, value, leftValue, rightValue);
		}
	}
	
	public void preOrder(Node root) {
		System.out.print(root.value);
		if (root.left != null) preOrder(root.left);
		if (root.right != null) preOrder(root.right);
	}
	
	public void inOrder(Node root) {
		if (root.left != null) inOrder(root.left);
		System.out.print(root.value);
		if (root.right != null) inOrder(root.right);
	}
	
	public void postOrder(Node root) {
		if (root.left != null) postOrder(root.left);
		if (root.right != null) postOrder(root.right);
		System.out.print(root.value);
	}
}

public class B1991 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree();
		
		for (int i = 0; i < n; i++) {
			char[] inputs = br.readLine().replaceAll(" ", "").toCharArray();
			tree.insert(inputs[0], inputs[1], inputs[2]);
		}
		
		br.close();
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
}
