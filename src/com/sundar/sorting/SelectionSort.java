package com.sundar.sorting;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner scan = new Scanner(System.in);
		int array[] = {2, 7, 4, 1, 5, 3};
		int recordSize = array.length, min, temp, minIndex;
	    System.out.println("Selection sort algo (in-place) ");
	    
	    for(int i = 0; i <= recordSize - 2; i ++){
	    	/* find the min of the array from index i --> recordSize-1 */
	    	//min = array[i];//array[0]
	    	minIndex = i;
	    	for(int j = i+1; j <= recordSize - 1; j ++){
	    		if(array[j] < array[minIndex]){
	    			
	    			minIndex = j;
	    		}
	    	}
	    	
	    	/* swap min & ith element */
	    	temp = array[i];
	    	array[i] = array[minIndex];
	    	array[minIndex] = temp;
	    	
	    }
	   for(int k = 0; k < recordSize; k ++)
		   System.out.println(array[k]);
		  
	}

}
