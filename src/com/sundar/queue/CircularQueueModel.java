package com.sundar.queue;

import java.util.NoSuchElementException;

public class CircularQueueModel {

	protected int Queue[];
	protected int front, rear, size, len;
	
	public CircularQueueModel(int n) {
		Queue = new int[n];
		size = n;
		len = 0;
		front = -1;
		rear = -1;
	}
	
	public boolean isEmpty(){
		return front == -1;
	}
	public boolean isFull(){
		//check the front & rear should be nearer
		return (front == rear + 1 ? true : false);
	}
	
	public int getSize()
	{
	    return len ;
	}    
	 
	public int front(){
		
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception");
		return Queue[front];
	}
	
	public void enQueue(int data){
		
	}
}
