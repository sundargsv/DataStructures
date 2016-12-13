package com.sundar.queue;

import java.util.NoSuchElementException;

class PriorityQueue {

	private Task[] heap;
	private int heapSize, capacity;
	
	 public PriorityQueue(int capacity)
	    {    
	        this.capacity = capacity;
	        heap = new Task[this.capacity];
	        heapSize = -1;
	    }
	 
	public boolean isEmpty(){
		
		return heapSize == -1;
	}
	
	public boolean isFull(){
		return heapSize == capacity - 1;
	}
	
	public int getSize(){
		return heapSize+1;
	}
	
	public void insert(String jobName, int priority){
		if(isFull())
			throw new IndexOutOfBoundsException("OverFlow Exception");
		Task newJob = new Task(jobName, priority);
		heap[++heapSize] = newJob;
		int pos = heapSize;
		if(pos!=0){
			sortQueueOnPriority(pos);
		}else{
			displayTasks();	
		}
		
	}
	
	public void remove(){
		
		int i = 0;
		if(isEmpty())
			throw new NoSuchElementException("Nothing to remove, your queue is empty");
		System.out.println("Deleted Task/ Job");
		
		while(i < heapSize){
			heap[i] = heap[i+1];
			i++;
		}
		heap[heapSize] = null;
		heapSize--;
		
		displayTasks();
		
	}

	private void sortQueueOnPriority(int pos) {
		
		while(pos != 0){
			
			if(heap[pos].priority > heap[pos - 1].priority){
				//sorting
				Task tmp = heap[pos - 1];
				heap[pos - 1] = heap[pos];
				heap[pos] = tmp;
				pos--;
			}
		}
		displayTasks();
		
	}
	
	public void displayTasks(){
		for(int i=0; i<=heapSize; i++)
			System.out.println(heap[i].toString());
	}
	
	
}
