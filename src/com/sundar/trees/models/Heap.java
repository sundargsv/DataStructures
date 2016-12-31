package com.sundar.trees.models;

public class Heap {

	private int[] heapArray;
    /** size of array **/
    private int maxSize; 
    /** number of nodes in array **/
    private int heapSize; 
 
    /** Constructor **/
    public Heap(int mx) 
    {
        maxSize = mx;
        heapSize = 0;
        heapArray = new int[maxSize]; 
    }
    
    public boolean isEmpty() 
    {
        return heapSize == 0;
    }
    
    /* Here the array index starts with 1 */
    
    public boolean insert(int data) 
    {
        if (heapSize + 1 == maxSize)
            return false;
        heapArray[++heapSize] = data;
        int pos = heapSize;
        while (pos != 1 && data > heapArray[pos/2])
        {
            heapArray[pos] = heapArray[pos/2];
            pos /=2;
        }
        heapArray[pos] = data;  
        displayHeap();
        return true;
    } 
    
    /* Remove the max */
    public boolean remove(){
    	
    	if (isEmpty() )
            return false;
    	/*1 - interchage 1 & last index
    	 *2 - remove the last index element
    	 *3 - Do Max Heapify
    	 **/
    	int tmp = heapArray[1];
    	heapArray[1] = heapArray[heapSize];
    	heapArray[heapSize] = tmp;
    	
    	heapArray[heapSize] = 0;
    	heapSize --;
    	int CurrentIndex = 1, 
    			maxIndex, lIndex = 2 * CurrentIndex, rIndex = (2 * CurrentIndex)+1, temp;
    	//while(heapArray[2 * CurrentIndex] != 0 || heapArray[(2 * CurrentIndex)+1] != 0){
    	while( heapArray[2 * CurrentIndex] != 0 || heapArray[(2 * CurrentIndex)+1] != 0){
    		System.out.println("inside loop");
    		lIndex = 2 * CurrentIndex; rIndex = (2 * CurrentIndex)+1;
    		/* no child */
    		if(heapArray[lIndex] == 0 && heapArray[rIndex] == 0){
    			System.out.println("No child");
    			break;
    		}
    		
    		/* 1-child (Right child) */
    		else if(heapArray[lIndex] == 0){
    			System.out.println("1 child (Right child)");
    			maxIndex = rIndex;
    			
    			if(heapArray[CurrentIndex] < heapArray[maxIndex]){
    				temp = heapArray[CurrentIndex];
    				heapArray[CurrentIndex] = heapArray[maxIndex];
    				heapArray[maxIndex] = temp;
    				CurrentIndex = maxIndex;
    			}else{
    				break;
    			}
    			
    		}
    		
    		/* 1-child (Left child) */
    		else if(heapArray[rIndex] == 0){
    			System.out.println("1 child (Left child)");
    			maxIndex = lIndex;
    			
    			if(heapArray[CurrentIndex] < heapArray[maxIndex]){
    				temp = heapArray[CurrentIndex];
    				heapArray[CurrentIndex] = heapArray[maxIndex];
    				heapArray[maxIndex] = temp;
    				CurrentIndex = maxIndex;
    			}else{
    				break;
    			}
    		}
    		
    		/* 2-child */
    		else{
    			System.out.println("2 child");
    			if(heapArray[lIndex] > heapArray[rIndex]){
    				maxIndex = lIndex;
    			}else{
    				maxIndex = rIndex;
    			}
    			
    			if(heapArray[CurrentIndex] < heapArray[maxIndex]){
    				
    				temp = heapArray[CurrentIndex];
    				heapArray[CurrentIndex] = heapArray[maxIndex];
    				heapArray[maxIndex] = temp;
    				CurrentIndex = maxIndex;
    				
    			}else{
    				break;
    			}
    					
    		}
    		if(CurrentIndex > heapSize || 2 * CurrentIndex > heapSize || (2 * CurrentIndex)+1 > heapSize)
				break;
    	}
    	displayHeap();
    	return true;
    }
    
    /** Function to print values **/
    public void displayHeap()
    {
        /* Array format */
        System.out.print("\nHeap array: ");    
        for(int i = 1; i <= heapSize; i++)
            System.out.print(heapArray[i] +" ");
        System.out.println("\n");
    }  
}
