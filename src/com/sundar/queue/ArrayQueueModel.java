package com.sundar.queue;

import java.util.NoSuchElementException;

public class ArrayQueueModel {

	protected int Queue[];
	protected int front, rear, size, len;
	
	public ArrayQueueModel(int n) {
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
		return front==0 && rear == size -1 ;
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
	
	public void display(){
		
		if(len == 0){
			System.out.println("Empty");
			System.out.println("Length is :" +len);
			return;
		}else{
			int i = 0;
			
			while(i < len){
				System.out.println(Queue[i]+"");
				i++;
			}
			
		}
			
		
		
	}
	
	
	
}
