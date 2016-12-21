package com.sundar.linkedList.model;

public class DLLNode {
	
	protected int data;
	protected DLLNode prevLink, nextLink;
	
	public DLLNode(){
		this.data = 0;
		this.prevLink = null;
		this.nextLink = null;
	}
	public DLLNode(int data, DLLNode prevLink, DLLNode nextLink) {
		super();
		this.data = data;
		this.prevLink = prevLink;
		this.nextLink = nextLink;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DLLNode getPrevLink() {
		return prevLink;
	}
	public void setPrevLink(DLLNode prevLink) {
		this.prevLink = prevLink;
	}
	public DLLNode getNextLink() {
		return nextLink;
	}
	public void setNextLink(DLLNode nextLink) {
		this.nextLink = nextLink;
	}
	
	
	
    
}
