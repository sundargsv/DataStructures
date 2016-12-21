package com.sundar.trees;

import java.util.NoSuchElementException;

import com.sundar.trees.models.Node;

public class NodeInQueue {

	protected Node Queue[];
	protected int front, rear, size, len;
	
	public NodeInQueue(int nodeCount) {
		Queue = new Node[nodeCount];
		size = nodeCount;
		len = 0;
		front = -1;
		rear = -1;
	}
	
	public boolean isEmpty(){
		return front == -1;
	}
	
	public boolean isFull(){
		return front==0 && rear == size -1 ;
	}
	
	public Node frontNode(){
		
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception");
		return Queue[front];
	}

	public int front(){
		
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception");
		return Queue[front].data;
	}

	public void enQueue(Node data){
		
		if(isFull())
			throw new IndexOutOfBoundsException("Overflow exception");
		else{
			if (rear == -1 && front == -1) 
	        {
				//First element into Queue
	            front = 0;
	            rear = 0;
	            Queue[rear] = data;
	            len ++;
	        }else{
	        	//Increment rear to next index & then assign a value
	        	Queue[++rear] = data;
	    		len ++;
	        }
		}
		
	}
	
	public int deQueue(){
		
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception");
		int data = front();
		len --;
		if(front == rear){
			front = -1; rear = -1;
		}else{
			front ++;
		}	
		return data;
	}
}
