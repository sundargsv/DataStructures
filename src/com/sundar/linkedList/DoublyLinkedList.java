package com.sundar.linkedList;

import com.sundar.linkedList.model.DLLNode;
import com.sundar.linkedList.model.Node;

public class DoublyLinkedList {

	protected DLLNode head, tail;
	public static int size;
	
	public DoublyLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int getSize(){
		return size;
	}
	
	public void insertAtStart(int data){
		DLLNode nptr = new DLLNode(data, null, null);
    	size ++;
    	if(head == null && tail == null){
    		/*If it is the 1st node*/
    		head = nptr;
    		tail = head;
    	}else{
    		DLLNode tmp = head;
    		nptr.setNextLink(tmp);
    		tmp.setPrevLink(nptr);
    		head = nptr;
    	}
    	display();
    }
	
	public void insertAtEnd(int data){
		DLLNode nptr = new DLLNode(data, null, null);
		size ++;
		if(head == null && tail == null){
			/*If it is the 1st node*/
    		head = nptr;
    		tail = head;
		}else{
			tail.setNextLink(nptr);
			nptr.setPrevLink(tail);
			tail = nptr;
			
		}
		display();
	}
	
	public void insertAtPos(int data, int position){
		DLLNode nptr = new DLLNode(data, null, null);
		size ++;
		int i = 1;
		DLLNode ptr = head;
		while(i < position){
			if(i == position - 1){
				DLLNode tmp = ptr.getNextLink();
				ptr.setNextLink(nptr);
				nptr.setPrevLink(ptr);
				nptr.setNextLink(tmp);
				tmp.setPrevLink(nptr);
				break;
			}	
			ptr = ptr.getNextLink();
			i++;
		}
		display();
	}
	
	public void deleteAtPos(int position){
		DLLNode tmp;
		if(position == 1){
			/*Deleting first/ head node*/
			tmp = head.getNextLink();
			tmp.setPrevLink(null);
			head = tmp;
			
		}else if(position == size){
			/*Deleting last/ tail node*/
			tmp = tail.getPrevLink();
			tmp.setNextLink(null);
			tail = tmp;
			
		}else{
			int i = 1;
			DLLNode ptr = head;
			while(i < position){
				if(i == position - 1){
					DLLNode deleteNode = ptr.getNextLink();
					tmp = deleteNode.getNextLink();
					ptr.setNextLink(tmp);
					tmp.setPrevLink(ptr);
					break;
				}
				ptr = ptr.getNextLink();
				i ++;
			}
		}
		size --;
		display();
	}	
	
	public void display(){
		System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (head.getNextLink() == null) 
        {
            System.out.println(head.getData() );
            return;
        }
        DLLNode ptr = head;
        System.out.print(head.getData()+ "->");
        ptr = head.getNextLink();
        while (ptr.getNextLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getNextLink();
        }
        System.out.print(ptr.getData()+ "\n");
	}
	
	public void displayInReverse(){
		System.out.print("\nDoubly Linked List in reverse order = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (head.getNextLink() == null) 
        {
            System.out.println(head.getData() );
            return;
        }
        DLLNode ptr = tail;
        System.out.print(tail.getData()+ "->");
        ptr = tail.getPrevLink();
        while (ptr.getPrevLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getPrevLink();
        }
        System.out.print(ptr.getData()+ "\n");
	}
}


