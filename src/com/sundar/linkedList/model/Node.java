package com.sundar.linkedList.model;

public class Node {

	protected int data;
	protected Node nextLink;
	
	public Node(){
		this.data = 0;
		this.nextLink = null;
	}
	public Node(int data, Node nextLink) {
		super();
		this.data = data;
		this.nextLink = nextLink;
	}
	
	/*  Function to set link to next Node  */
    public void setLink(Node n)
    {
    	nextLink = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return nextLink;
    }    
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
    
    
	
}
