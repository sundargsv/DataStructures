package com.sundar.trees;

import java.util.NoSuchElementException;

import com.sundar.linkedList.model.DLLNode;
import com.sundar.queue.ArrayQueueModel;
import com.sundar.trees.models.Node;

public class BinarySearchTree {

	public static  Node root;
	public static int nodeCount;
	
	public BinarySearchTree(){
		BinarySearchTree.root = null;
		BinarySearchTree.nodeCount = 0;
	}
	
	/* To get the count/ no of nodes in tree */
	public int getCount(){
		
		return nodeCount;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public boolean search(int data){
		
		if(root == null){
			return false;
		}
		Node current = root;
		while(current != null){
			if(current.data == data){
				return true;
			}else if(current.data < data){
				current = current.right;
			}else{
				current = current.left;
			}
		}
		return false;
		
	}
	
	/*Insert function to add an element in a tree*/
	public void insert(int id){
		
		Node newNode = new Node(id);
		if(root == null){
			root = newNode;
			nodeCount ++;
			return;
		}
		/*Node current = root;
		Node parent = null;*/
		
	/*	while(true){
			parent = current;
			if(id <= current.data){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					nodeCount ++;
					return;
				}
			}else{
				current = current.right;
				if(current == null){
					parent.right = newNode;
					nodeCount ++;
					return;
				}
			}
		}*/
		Node parent = root;
		
		while(true){
			//parent = current;
			if(id <= parent.data){
				
				if(parent.left == null){
					parent.left = newNode;
					nodeCount ++;
					return;
				}
				//NewParent
				parent = parent.left;
			}else{
				if(parent.right == null){
					parent.right = newNode;
					nodeCount ++;
					return;
				}
				//NewParent
				parent = parent.right;
			}
		}
	}
	
	/*BFT or LevelOrder traversal*/
	public void levelOrderDisplay(){
		if(root == null){
			throw new NoSuchElementException("Underflow Exception");
		}
		NodeInQueue queue = new NodeInQueue(nodeCount);
		Node current = root;
		queue.enQueue(current);
		while(current != null){
			
			if(current.left != null)
				queue.enQueue(current.left);
			if(current.right != null)
				queue.enQueue(current.right);
			
			/*Print Current & D queue the same*/
			int data = queue.front();
			System.out.println(data);
			queue.deQueue();
			if(queue.isEmpty()){
				break;
			}
			current = queue.frontNode();
		}
		
	}
	
	/*DFT*/
	public void preOrderTraversal(){
		preOrder(root);
	}
	
	public void preOrder(Node root){
		if(root != null){
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void inOrderTraversal(){
		inOrder(root);
	}
	
	public void inOrder(Node root){
		if(root != null){
			
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	
	public void postOrderTraversal(){
		postOrder(root);
	}
	
	public void postOrder(Node root){
		if(root != null){
			
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
				
	}
	
	public boolean delete(int data){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		//current.data != data in order to get the parent node
		while(current.data != data){
			parent = current;
			if(current.data > data){
				isLeftChild = true;
				current = current.left;
			}
			else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				/* Which means, there is no such element to delete */
				return false;
			}
		}
		
		/* we have found the node
		 * Case 1: if node to be deleted has no children */
		if(current.left == null && current.right == null){
			if(current == root){
				root = null;
			}
			if(isLeftChild){
				//Left tree
				parent.left = null;
			}else{
				//Right tree
				parent.right = null;
			}
			
		}
		
		//Case 2 : if node to be deleted has only one child
		
		else if(current.left == null){
			//It has right child
			if(current == root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}
		
		else if(current.right == null){
			//It has left child
			if(current == root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		
		else if(current.left!=null && current.right!=null){
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}
		return true;
	}
	
	public Node getSuccessor(Node deleteNode){
		
		Node successorParent = null;
		Node successor = null;
		Node current = deleteNode.right;
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		/* There wont be left child for the successor for sure
		 * Check for right child, if yes then add it to the left of successorParent
		 */
		
		if(successor !=deleteNode.right){
			successorParent.left = successor.right;
			successor.right = deleteNode.right;
		}
		return successor;
	}
	
}
