package com.sundar.linkedList;

import java.util.NoSuchElementException;

import com.sundar.linkedList.model.Node;

public class SinglyLinkedList {

	protected Node head, tail;
	public static int size;
	
	public SinglyLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	/*LinkedList is dynamic, so no problem of OverFlow*/
	/*public boolean isFull(){
		
	}*/
	
	public boolean isEmpty(){
		
		return head == null;
	}
	
	/*  Function to get size of list  */
    public int getSize(){
        return size;
    }   
    
    public void insertAtStart(int data){
    	Node nptr = new Node(data, null);
    	size ++;
    	if(head == null){
    		/*If it is the 1st node*/
    		head = nptr;
    		tail = head;
    	}else{
    		nptr.setLink(head);
    		head = nptr;
    	}
    	display();
    }
    
    public void insertAtEnd(int data){
    	Node nptr = new Node(data, null);
    	size ++;
    	if(head == null && tail == null){
    		/*If it is the 1st node*/
    		head = nptr;
    		tail = head;
    	}else{
    		tail.setLink(nptr);
    		nptr = tail;
    	}
    	display();
    }
    
    public void insertAtPos(int data, int position){
    	
    	if(position == 1){
    		insertAtStart(data);
    	}else if(position == size + 1){
    		insertAtEnd(data);
    	}else{
    		int i = 1;
    		Node nptr = new Node(data, null);
    	
    		Node ptr = head;
    		while(i < position){
    			if(i == position - 1){
    				Node tmp = ptr.getLink();
    				ptr.setLink(nptr);
    				nptr.setLink(tmp);
    				size ++;
    				break;
    			}
    			ptr = ptr.getLink();
    			i ++;
    		}
    		display();
    	}
    	
    }
    
    public void deletePos(int position){
    	if(size == 0)
    		throw new NoSuchElementException("No element in list");
    	Node ptr = head;
    	int i = 1;
    	while(i < position){
    		if(i == position - 1){
    			Node deleteNode = ptr.getLink();
    			ptr.setLink(deleteNode.getLink());
    			size --;
    			break;
    		}
    		ptr = ptr.getLink();
			i ++;
    	}
    	display();
    }
    
    public void display(){
    	System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (head.getLink() == null) 
        {
            System.out.println(head.getData() );
            return;
        }
        Node ptr = head;
        System.out.print(head.getData()+ "->");
        ptr = head.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
